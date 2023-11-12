package hummel.service.impl;

import hummel.bean.container.Page;
import hummel.dao.BookDao;
import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.factory.DaoFactory;
import hummel.service.AuthorService;
import hummel.utils.Tools;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.SQLException;

import static hummel.utils.Constants.*;

public class AuthorServiceImpl implements AuthorService {
	@Override
	public void getBooks(HttpServletRequest request, ServletResponse response, ServletConfig servlet, String author) throws DatabaseException, ServiceException {
		try {
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			BookDao bookDao = daoFactory.getBookDao();
			RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + AUTHOR_PAGE + POSTFIX);
			Page bookPaging = (Page) request.getSession().getAttribute(BOOK_PAGING_PARAMS);
			request.setAttribute(AUTHOR_BOOKS, bookDao.getBooksByAuthor(author, bookPaging));
			request.setAttribute(AUTHOR_NAME, author);
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void paging(HttpServletRequest request, ServletResponse response, ServletConfig servlet, String author) throws DatabaseException, ServiceException {
		try {
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			BookDao bookDao = daoFactory.getBookDao();
			RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + AUTHOR_PAGE + POSTFIX);
			request.setAttribute(AUTHOR_BOOKS, bookDao.getBooksByAuthor(author, Tools.updatePagingParams(request, BOOK_PAGING_PARAMS)));
			request.setAttribute(AUTHOR_NAME, author);
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}