package com.github.hummel.wt.lab2.service.impl;

import com.github.hummel.wt.lab2.bean.User;
import com.github.hummel.wt.lab2.bean.container.Page;
import com.github.hummel.wt.lab2.exception.ConnectionException;
import com.github.hummel.wt.lab2.exception.DatabaseException;
import com.github.hummel.wt.lab2.exception.ServiceException;
import com.github.hummel.wt.lab2.factory.DaoFactory;
import com.github.hummel.wt.lab2.service.ProfileService;
import com.github.hummel.wt.lab2.utils.Tools;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import static com.github.hummel.wt.lab2.utils.Constants.*;

public class ProfileServiceImpl implements ProfileService {
	private static final Pattern PATTERN = Pattern.compile("^\\+375((29)|(44)|(25)|(33))[0-9]{7}$");

	@SuppressWarnings("StringConcatenationMissingWhitespace")
	private static boolean validateAddressAndPhoneNumber(ServletRequest request) {
		var address = request.getParameter(ADDRESS);
		var phoneNumber = request.getParameter(PHONE_NUMBER);
		var status = true;
		if (address.length() < 10 || address.length() > 90) {
			request.setAttribute(ADDRESS + ERROR, ADDRESS_ERROR);
			status = false;
		}
		if (!PATTERN.matcher(phoneNumber).matches()) {
			request.setAttribute(PHONE_NUMBER + ERROR, PHONE_NUMBER_ERROR);
			return false;
		}
		return status;
	}

	@Override
	public void addAddressAndPhoneNumber(HttpServletRequest request, HttpServletResponse response) throws DatabaseException, ServiceException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var userDao = daoFactory.getUserDao();
			if (validateAddressAndPhoneNumber(request)) {
				var session = request.getSession();
				var user = (User) session.getAttribute(USER);
				var address = request.getParameter(ADDRESS);
				var phoneNumber = request.getParameter(PHONE_NUMBER);
				userDao.updateAddressPhone(address, phoneNumber, user.getId());
				user.setAddress(address);
				user.setPhoneNumber(phoneNumber);
			}
			response.sendRedirect(request.getContextPath() + "/profile");
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException | SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}

	@Override
	public void getUserInfo(HttpServletRequest request, ServletResponse response, ServletConfig servlet) throws DatabaseException, ServiceException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var userDao = daoFactory.getUserDao();
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + PROFILE_PAGE + POSTFIX);
			var session = request.getSession();
			var userId = ((User) session.getAttribute(USER)).getId();
			request.setAttribute(ORDERS, userDao.getOrders(userId, (Page) session.getAttribute(ORDER_PAGING_PARAMS)));
			requestDispatcher.forward(request, response);
		} catch (ConnectionException | SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void paging(HttpServletRequest request, ServletResponse response, ServletConfig servlet) throws DatabaseException, ServiceException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var userDao = daoFactory.getUserDao();
			var session = request.getSession();
			var user = (User) session.getAttribute(USER);
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + PROFILE_PAGE + POSTFIX);
			request.setAttribute(ORDERS, userDao.getOrders(user.getId(), Tools.updatePagingParams(request, ORDER_PAGING_PARAMS)));
			requestDispatcher.forward(request, response);
		} catch (ConnectionException | SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}