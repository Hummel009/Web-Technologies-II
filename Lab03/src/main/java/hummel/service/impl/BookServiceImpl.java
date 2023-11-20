package hummel.service.impl;

import hummel.dao.BookDao;
import hummel.dao.ex.BookDaoEx;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static hummel.utils.Constants.*;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookDaoEx bookDaoEx;

	@Override
	public void getBook(ServletRequest request, ServletResponse response, String id) throws DatabaseException, ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + BOOK_PAGE + POSTFIX);
			if (!id.matches("\\d+")) {
				throw new NumberFormatException("id is not a number");
			}
			var book = bookDao.ex(bookDaoEx).getBookById(Integer.parseInt(id));
			if (book == null) {
				throw new IOException("No book with given id");
			}
			request.setAttribute(BOOK, book);
			requestDispatcher.forward(request, response);
		} catch (ServletException | NumberFormatException | IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}