package com.github.hummel.wt.lab2.service.impl;

import com.github.hummel.wt.lab2.exception.ConnectionException;
import com.github.hummel.wt.lab2.exception.DatabaseException;
import com.github.hummel.wt.lab2.exception.ServiceException;
import com.github.hummel.wt.lab2.bean.container.Page;
import com.github.hummel.wt.lab2.factory.DaoFactory;
import com.github.hummel.wt.lab2.service.IndexService;
import com.github.hummel.wt.lab2.utils.Tools;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static com.github.hummel.wt.lab2.utils.Constants.*;

public class IndexServiceImpl implements IndexService {
	@Override
	public void getIndexPage(HttpServletRequest request, ServletResponse response, ServletConfig servlet) throws DatabaseException, ServiceException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var authorDao = daoFactory.getAuthorDao();
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + INDEX_PAGE + POSTFIX);
			var authorPaging = (Page) request.getSession().getAttribute(AUTHOR_PAGING_PARAMS);
			request.setAttribute(AUTHORS, authorDao.getAuthors(authorPaging));
			requestDispatcher.forward(request, response);
		} catch (SQLException | ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException | ServletException e) {
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
			var daoFactory = DaoFactory.INSTANCE;
			var authorDao = daoFactory.getAuthorDao();
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + INDEX_PAGE + POSTFIX);
			request.setAttribute(AUTHORS, authorDao.getAuthors(Tools.updatePagingParams(request, AUTHOR_PAGING_PARAMS)));
			requestDispatcher.forward(request, response);
		} catch (SQLException | ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}