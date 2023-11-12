package hummel.service.impl;

import hummel.bean.container.Page;
import hummel.dao.AuthorDao;
import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.factory.DaoFactory;
import hummel.service.IndexService;
import hummel.utils.Tools;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static hummel.utils.Constants.*;

public class IndexServiceImpl implements IndexService {
	@Override
	public void getIndexPage(HttpServletRequest request, ServletResponse response, ServletConfig servlet) throws DatabaseException, ServiceException {
		try {
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			AuthorDao authorDao = daoFactory.getAuthorDao();
			RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + INDEX_PAGE + POSTFIX);
			Page authorPaging = (Page) request.getSession().getAttribute(AUTHOR_PAGING_PARAMS);
			request.setAttribute(AUTHORS, authorDao.getAuthors(authorPaging));
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
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		try {
			request.getSession().setAttribute(USER, null);
			response.sendRedirect(request.getContextPath() + "/login");
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void paging(HttpServletRequest request, ServletResponse response, ServletConfig servlet) throws DatabaseException, ServiceException {
		try {
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			AuthorDao authorDao = daoFactory.getAuthorDao();
			RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + INDEX_PAGE + POSTFIX);
			request.setAttribute(AUTHORS, authorDao.getAuthors(Tools.updatePagingParams(request, AUTHOR_PAGING_PARAMS)));
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