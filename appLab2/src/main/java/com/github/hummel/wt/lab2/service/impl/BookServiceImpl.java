package com.github.hummel.wt.lab2.service.impl;

import com.github.hummel.wt.lab2.exception.ConnectionException;
import com.github.hummel.wt.lab2.exception.DatabaseException;
import com.github.hummel.wt.lab2.exception.ServiceException;
import com.github.hummel.wt.lab2.factory.DaoFactory;
import com.github.hummel.wt.lab2.service.BookService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import static com.github.hummel.wt.lab2.utils.Constants.*;

public class BookServiceImpl implements BookService {
	private static final Pattern PATTERN = Pattern.compile("\\d+");

	@Override
	public void getBook(ServletRequest request, ServletResponse response, ServletConfig servlet, String id) throws DatabaseException, ServiceException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var bookDao = daoFactory.getBookDao();
			var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + BOOK_PAGE + POSTFIX);
			if (!PATTERN.matcher(id).matches()) {
				throw new NumberFormatException("id is not a number");
			}
			var book = bookDao.getBookById(Integer.parseInt(id));
			if (book == null) {
				throw new IOException("No book with given id");
			}
			request.setAttribute(BOOK, book);
			requestDispatcher.forward(request, response);
		} catch (SQLException | ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ServletException | NumberFormatException | IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}