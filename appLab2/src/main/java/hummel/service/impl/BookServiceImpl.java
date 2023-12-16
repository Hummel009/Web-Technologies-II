package hummel.service.impl;

import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.factory.DaoFactory;
import hummel.service.BookService;
import jakarta.servlet.*;

import java.io.IOException;
import java.sql.SQLException;

import static hummel.utils.Constants.*;

public class BookServiceImpl implements BookService {
	@Override
	public void getBook(ServletRequest request, ServletResponse response, ServletConfig servlet, String id) throws DatabaseException, ServiceException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var bookDao = daoFactory.getBookDao();
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + BOOK_PAGE + POSTFIX);
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