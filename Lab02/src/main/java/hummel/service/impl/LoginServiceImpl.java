package hummel.service.impl;

import hummel.bean.User;
import hummel.dao.UserDao;
import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.factory.DaoFactory;
import hummel.service.LoginService;
import hummel.utils.Tools;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static hummel.utils.Constants.*;

public class LoginServiceImpl implements LoginService {
	@Override
	public void getLoginPage(ServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException {
		try {
			RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + LOGIN_PAGE + POSTFIX);
			requestDispatcher.forward(request, response);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response, ServletConfig servlet) throws DatabaseException, ServiceException {
		try {
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			UserDao userDao = daoFactory.getUserDao();
			RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + LOGIN_PAGE + POSTFIX);
			User user = userDao.getUserByEmailPassword(request.getParameter(EMAIL), Tools.getHash(request.getParameter(PASSWORD)));
			if (user != null) {
				request.getSession().setAttribute(USER, user);
				response.sendRedirect(request.getContextPath() + "/profile");
			} else {
				request.setAttribute(STATUS, INVALID_CREDENTIALS);
				requestDispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}