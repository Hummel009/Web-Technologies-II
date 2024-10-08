package com.github.hummel.wt.lab2.service.impl;

import com.github.hummel.wt.lab2.exception.ConnectionException;
import com.github.hummel.wt.lab2.exception.DatabaseException;
import com.github.hummel.wt.lab2.exception.ServiceException;
import com.github.hummel.wt.lab2.factory.DaoFactory;
import com.github.hummel.wt.lab2.service.LoginService;
import com.github.hummel.wt.lab2.utils.Tools;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static com.github.hummel.wt.lab2.utils.Constants.*;

public class LoginServiceImpl implements LoginService {
	@Override
	public void getLoginPage(ServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException {
		try {
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + LOGIN_PAGE + POSTFIX);
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response, ServletConfig servlet) throws DatabaseException, ServiceException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var userDao = daoFactory.getUserDao();
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + LOGIN_PAGE + POSTFIX);
			var user = userDao.getUserByEmailPassword(request.getParameter(EMAIL), Tools.getHash(request.getParameter(PASSWORD)));
			if (user != null) {
				request.getSession().setAttribute(USER, user);
				response.sendRedirect(request.getContextPath() + "/profile");
			} else {
				request.setAttribute(STATUS, INVALID_CREDENTIALS);
				requestDispatcher.forward(request, response);
			}
		} catch (SQLException | ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ServletException | IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}