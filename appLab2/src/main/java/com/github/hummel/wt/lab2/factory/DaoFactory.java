package com.github.hummel.wt.lab2.factory;

import com.github.hummel.wt.lab2.dao.AuthorDao;
import com.github.hummel.wt.lab2.dao.BookDao;
import com.github.hummel.wt.lab2.dao.UserDao;
import com.github.hummel.wt.lab2.dao.impl.AuthorDaoImpl;
import com.github.hummel.wt.lab2.dao.impl.BookDaoImpl;
import com.github.hummel.wt.lab2.dao.impl.UserDaoImpl;

public class DaoFactory {
	public static final DaoFactory INSTANCE = new DaoFactory();

	private final AuthorDao authorDao = new AuthorDaoImpl();
	private final BookDao bookDao = new BookDaoImpl();
	private final UserDao userDao = new UserDaoImpl();

	private DaoFactory() {
	}

	public AuthorDao getAuthorDao() {
		return authorDao;
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
}