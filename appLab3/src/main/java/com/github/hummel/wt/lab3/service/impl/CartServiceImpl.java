package com.github.hummel.wt.lab3.service.impl;

import com.github.hummel.wt.lab3.exception.ConnectionException;
import com.github.hummel.wt.lab3.exception.DatabaseException;
import com.github.hummel.wt.lab3.exception.ServiceException;
import com.github.hummel.wt.lab3.service.CartService;
import com.github.hummel.wt.lab3.bean.User;
import com.github.hummel.wt.lab3.bean.container.Cart;
import com.github.hummel.wt.lab3.dao.BookDao;
import com.github.hummel.wt.lab3.dao.UserDao;
import com.github.hummel.wt.lab3.dao.ex.BookDaoEx;
import com.github.hummel.wt.lab3.dao.ex.UserDaoEx;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import static com.github.hummel.wt.lab3.utils.Constants.*;

@Service
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class CartServiceImpl implements CartService {
	private static final Pattern PATTERN = Pattern.compile("\\d+");
	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookDaoEx bookDaoEx;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserDaoEx userDaoEx;

	@Override
	public void addBook(HttpServletRequest request, HttpServletResponse response, String id) throws ServiceException {
		try {
			if (!PATTERN.matcher(id).matches()) {
				throw new NumberFormatException("id is not a number");
			}
			var book = bookDao.ex(bookDaoEx).getBookById(Integer.parseInt(id));
			if (book == null) {
				throw new IOException("No book with given id");
			}
			((Cart) request.getSession().getAttribute(CART)).addBook(book);
			response.sendRedirect(request.getContextPath() + "/books/" + id);
		} catch (NumberFormatException | IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void clearCart(HttpServletRequest request, ServletResponse response) throws ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + CART_PAGE + POSTFIX);
			((Cart) request.getSession().getAttribute(CART)).clear();
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException | NumberFormatException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void getCart(ServletRequest request, ServletResponse response) throws ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + CART_PAGE + POSTFIX);
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void makeOrder(HttpServletRequest request, ServletResponse response) throws DatabaseException, ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + CART_PAGE + POSTFIX);
			var session = request.getSession();
			var user = (User) session.getAttribute(USER);
			var cart = (Cart) session.getAttribute(CART);
			if (userDao.ex(userDaoEx).getBalance(user.getId()) - cart.getSummaryPrice() >= 0.0) {
				if (cart.isEmpty()) {
					request.setAttribute(COLOR, ERROR_COLOR);
					request.setAttribute(STATUS, EMPTY_CART);
				} else {
					user.getOrders().add(userDao.ex(userDaoEx).addOrder(cart, user.getId()));
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
	public void removeBook(HttpServletRequest request, ServletResponse response, String id) throws ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + CART_PAGE + POSTFIX);
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