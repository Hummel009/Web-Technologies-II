package hummel.service.impl;

import hummel.bean.Author;
import hummel.bean.Book;
import hummel.bean.container.Page;
import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.factory.DaoFactory;
import hummel.service.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import static hummel.utils.Constants.*;

public class AdminServiceImpl implements AdminService {
	@Override
	public void addAuthor(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DatabaseException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var authorDao = daoFactory.getAuthorDao();
			var name = request.getParameter(AUTHOR_NAME);
			var filePart = request.getPart(AUTHOR_FILE);
			var fileName = filePart.getSubmittedFileName();
			fileName = name + "." + fileName.split("\\.")[1];
			var fileContent = filePart.getInputStream();
			Files.copy(fileContent, new File("D:\\Source\\Web-Technologies-II\\Lab02\\src\\main\\webapp\\assets\\authors\\" + fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
			authorDao.addAuthor(Author.builder().name(name).imagePath("assets/authors/" + fileName).build());
			response.sendRedirect(request.getContextPath() + "/admin");
		} catch (ServletException | IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (SQLException | ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}

	@Override
	public void addBook(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DatabaseException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var bookDao = daoFactory.getBookDao();
			var name = request.getParameter(BOOK_NAME);
			var description = request.getParameter(BOOK_DESCRIPTION);
			var filePart = request.getPart(BOOK_FILE);
			var author = request.getParameter(BOOK_AUTHOR);
			var price = Double.parseDouble(request.getParameter(BOOK_PRICE));
			var fileName = filePart.getSubmittedFileName();
			fileName = name + "." + fileName.split("\\.")[1];
			var fileContent = filePart.getInputStream();
			Files.copy(fileContent, new File("D:\\Source\\Web-Technologies-II\\Lab02\\src\\main\\webapp\\assets\\books\\" + fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
			bookDao.addBook(Book.builder().name(name).description(description).imagePath("assets/books/" + fileName).author(author).price(price).build());
			response.sendRedirect(request.getContextPath() + "/admin");
		} catch (ServletException | IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException | SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}

	@Override
	public void banUser(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DatabaseException {
		try {
			var daoFactory = DaoFactory.INSTANCE;
			var userDao = daoFactory.getUserDao();
			var banEmail = request.getParameter(BAN_EMAIL);
			var user = userDao.getUserByEmail(banEmail);
			if (user != null) {
				userDao.updateBanStatus(1, user.getId());
				user.setBanned(1);
			}
			response.sendRedirect(request.getContextPath() + "/admin");
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException | SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}

	@Override
	public void getAdminPage(ServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException, DatabaseException {
		var daoFactory = DaoFactory.INSTANCE;
		var authorDao = daoFactory.getAuthorDao();
		var requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + ADMIN_PAGE + POSTFIX);
		try {
			request.setAttribute(AUTHORS, authorDao.getAuthors(new Page(0, 999)));
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException | SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}
}