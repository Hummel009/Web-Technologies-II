package hummel.service.impl;

import hummel.bean.User;
import hummel.bean.container.Page;
import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.factory.DaoFactory;
import hummel.service.ProfileService;
import hummel.utils.Tools;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static hummel.utils.Constants.*;

public class ProfileServiceImpl implements ProfileService {
	private static boolean validateAddressAndPhoneNumber(ServletRequest request) {
		var address = request.getParameter(ADDRESS);
		var phoneNumber = request.getParameter(PHONE_NUMBER);
		var status = true;
		if (address.length() < 10 || address.length() > 90) {
			request.setAttribute(ADDRESS + ERROR, ADDRESS_ERROR);
			status = false;
		}
		if (!phoneNumber.matches("^\\+375((29)|(44)|(25)|(33))[0-9]{7}$")) {
			request.setAttribute(PHONE_NUMBER + ERROR, PHONE_NUMBER_ERROR);
			status = false;
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