package hummel.service.impl;

import hummel.dao.AuthorDao;
import hummel.dao.BookDao;
import hummel.dao.UserDao;
import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

import static hummel.utils.Constants.*;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private UserDao userDao;

	@Override
	public void getBook(ServletRequest request, ServletResponse response, String id) throws DatabaseException, ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + BOOK_PAGE + POSTFIX);
			if (!id.matches("\\d+")) {
				throw new NumberFormatException("id is not a number");
			}
			var book = bookDao.getBookById(Integer.parseInt(id));
			if (book == null) {
				throw new IOException("No book with given id");
			}
			request.setAttribute(BOOK, book);
			requestDispatcher.forward(request, response);
		} catch (SQLException | ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ServletException | NumberFormatException | IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}