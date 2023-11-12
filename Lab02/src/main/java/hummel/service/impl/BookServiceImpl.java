package hummel.service.impl;

import hummel.bean.Book;
import hummel.dao.BookDao;
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
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			BookDao bookDao = daoFactory.getBookDao();
			RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + BOOK_PAGE + POSTFIX);
			if (!id.matches("\\d+")) {
				throw new NumberFormatException("id is not a number");
			}
			Book book = bookDao.getBookById(Integer.parseInt(id));
			if (book == null) {
				throw new IOException("No book with given id");
			}
			request.setAttribute(BOOK, book);
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (NumberFormatException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}