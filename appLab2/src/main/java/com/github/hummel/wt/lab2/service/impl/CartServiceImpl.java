package com.github.hummel.wt.lab2.service.impl;

import com.github.hummel.wt.lab2.exception.ConnectionException;
import com.github.hummel.wt.lab2.exception.DatabaseException;
import com.github.hummel.wt.lab2.exception.ServiceException;
import com.github.hummel.wt.lab2.bean.User;
import com.github.hummel.wt.lab2.bean.container.Cart;
import com.github.hummel.wt.lab2.factory.DaoFactory;
import com.github.hummel.wt.lab2.service.CartService;
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

public class CartServiceImpl implements CartService {
	private static final Pattern PATTERN = Pattern.compile("\\d+");

	@Override
	public void addBook(HttpServletRequest request, HttpServletResponse response, String id) throws ServiceException, DatabaseException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var bookDao = daoFactory.getBookDao();
			if (!PATTERN.matcher(id).matches()) {
				throw new NumberFormatException("id is not a number");
			}
			var book = bookDao.getBookById(Integer.parseInt(id));
			if (book == null) {
				throw new IOException("No book with given id");
			}
			((Cart) request.getSession().getAttribute(CART)).addBook(book);
			response.sendRedirect(request.getContextPath() + "/books/" + id);
		} catch (NumberFormatException | IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException | SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}

	@Override
	public void clearCart(HttpServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException {
		try {
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + CART_PAGE + POSTFIX);
			((Cart) request.getSession().getAttribute(CART)).clear();
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException | NumberFormatException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void getCart(ServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException {
		try {
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + CART_PAGE + POSTFIX);
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void makeOrder(HttpServletRequest request, ServletResponse response, ServletConfig servlet) throws DatabaseException, ServiceException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var userDao = daoFactory.getUserDao();
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + CART_PAGE + POSTFIX);
			var session = request.getSession();
			var user = (User) session.getAttribute(USER);
			var cart = (Cart) session.getAttribute(CART);
			if (userDao.getBalance(user.getId()) - cart.getSummaryPrice() >= 0.0) {
				if (cart.isEmpty()) {
					request.setAttribute(COLOR, ERROR_COLOR);
					request.setAttribute(STATUS, EMPTY_CART);
				} else {
					user.getOrders().add(userDao.addOrder(cart, user.getId()));
					user.setBalance(user.getBalance() - cart.getSummaryPrice());
					request.setAttribute(COLOR, SUCCESS_COLOR);
					request.setAttribute(STATUS, COMPLETED);
					cart.clear();
				}
			} else {
				request.setAttribute(COLOR, ERROR_COLOR);
				request.setAttribute(STATUS, INSUFFICIENT_FUNDS);
			}
			requestDispatcher.forward(request, response);
		} catch (SQLException | ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void removeBook(HttpServletRequest request, ServletResponse response, ServletConfig servlet, String id) throws ServiceException {
		try {
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + CART_PAGE + POSTFIX);
			if (!PATTERN.matcher(id).matches()) {
				throw new NumberFormatException("id is not a number");
			}
			((Cart) request.getSession().getAttribute(CART)).removeBook(Integer.parseInt(id));
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException | NumberFormatException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}