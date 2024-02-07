package com.github.hummel.wt.lab3.service.impl;

import com.github.hummel.wt.lab3.exception.DatabaseException;
import com.github.hummel.wt.lab3.exception.ServiceException;
import com.github.hummel.wt.lab3.dao.BookDao;
import com.github.hummel.wt.lab3.dao.ex.BookDaoEx;
import com.github.hummel.wt.lab3.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Pattern;

import static com.github.hummel.wt.lab3.utils.Constants.*;

@Service
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class BookServiceImpl implements BookService {
	private static final Pattern PATTERN = Pattern.compile("\\d+");
	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookDaoEx bookDaoEx;

	@Override
	public void getBook(ServletRequest request, ServletResponse response, String id) throws ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + BOOK_PAGE + POSTFIX);
			if (!PATTERN.matcher(id).matches()) {
				throw new NumberFormatException("id is not a number");
			}
			var book = bookDao.ex(bookDaoEx).getBookById(Integer.parseInt(id));
			if (book == null) {
				throw new IOException("No book with given id");
			}
			request.setAttribute(BOOK, book);
			requestDispatcher.forward(request, response);
		} catch (ServletException | NumberFormatException | IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}