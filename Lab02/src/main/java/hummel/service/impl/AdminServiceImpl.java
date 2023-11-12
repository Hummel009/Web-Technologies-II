package hummel.service.impl;

import hummel.bean.Author;
import hummel.bean.Book;
import hummel.bean.User;
import hummel.bean.container.Page;
import hummel.dao.AuthorDao;
import hummel.dao.BookDao;
import hummel.dao.UserDao;
import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.factory.DaoFactory;
import hummel.service.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import static hummel.utils.Constants.*;

public strictfp class AdminServiceImpl implements AdminService {
	@Override
	public void addAuthor(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DatabaseException {
		try {
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			AuthorDao authorDao = daoFactory.getAuthorDao();
			String name = request.getParameter(AUTHOR_NAME);
			Part filePart = request.getPart(AUTHOR_FILE);
			String fileName = filePart.getSubmittedFileName();
			fileName = name + "." + fileName.split("\\.")[1];
			InputStream fileContent = filePart.getInputStream();
			Files.copy(fileContent, new File("D:\\Source\\Web-Technologies-II\\Lab02\\src\\main\\webapp\\assets\\authors\\" + fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
			authorDao.addAuthor(Author.builder().name(name).imagePath("assets/authors/" + fileName).build());
			response.sendRedirect(request.getContextPath() + "/admin");
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}

	@Override
	public strictfp void addBook(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DatabaseException {
		try {
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			BookDao bookDao = daoFactory.getBookDao();
			String name = request.getParameter(BOOK_NAME);
			String description = request.getParameter(BOOK_DESCRIPTION);
			Part filePart = request.getPart(BOOK_FILE);
			String author = request.getParameter(BOOK_AUTHOR);
			double price = Double.parseDouble(request.getParameter(BOOK_PRICE));
			String fileName = filePart.getSubmittedFileName();
			fileName = name + "." + fileName.split("\\.")[1];
			InputStream fileContent = filePart.getInputStream();
			Files.copy(fileContent, new File("D:\\Source\\Web-Technologies-II\\Lab02\\src\\main\\webapp\\assets\\books\\" + fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
			bookDao.addBook(Book.builder().name(name).description(description).imagePath("assets/books/" + fileName).author(author).price(price).build());
			response.sendRedirect(request.getContextPath() + "/admin");
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}

	@Override
	public void banUser(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DatabaseException {
		try {
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			UserDao userDao = daoFactory.getUserDao();
			String banEmail = request.getParameter(BAN_EMAIL);
			User user = userDao.getUserByEmail(banEmail);
			if (user != null) {
				userDao.updateBanStatus(1, user.getId());
				user.setBanned(1);
			}
			response.sendRedirect(request.getContextPath() + "/admin");
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}

	@Override
	public void getAdminPage(ServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException, DatabaseException {
		DaoFactory daoFactory = DaoFactory.INSTANCE;
		AuthorDao authorDao = daoFactory.getAuthorDao();
		RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + ADMIN_PAGE + POSTFIX);
		try {
			request.setAttribute(AUTHORS, authorDao.getAuthors(new Page(0, 999)));
			requestDispatcher.forward(request, response);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}
}