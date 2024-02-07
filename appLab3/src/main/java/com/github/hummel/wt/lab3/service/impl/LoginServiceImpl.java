package com.github.hummel.wt.lab3.service.impl;

import com.github.hummel.wt.lab3.exception.ConnectionException;
import com.github.hummel.wt.lab3.exception.DatabaseException;
import com.github.hummel.wt.lab3.exception.ServiceException;
import com.github.hummel.wt.lab3.dao.UserDao;
import com.github.hummel.wt.lab3.dao.ex.UserDaoEx;
import com.github.hummel.wt.lab3.service.LoginService;
import com.github.hummel.wt.lab3.utils.Tools;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

import static com.github.hummel.wt.lab3.utils.Constants.*;

@Service
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserDaoEx userDaoEx;

	@Override
	public void getLoginPage(ServletRequest request, ServletResponse response) throws ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + LOGIN_PAGE + POSTFIX);
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) throws DatabaseException, ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + LOGIN_PAGE + POSTFIX);
			var user = userDao.ex(userDaoEx).getUserByEmailPassword(request.getParameter(EMAIL), Tools.getHash(request.getParameter(PASSWORD)));
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