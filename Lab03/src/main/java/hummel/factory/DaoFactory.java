package hummel.factory;

import hummel.dao.AuthorDao;
import hummel.dao.BookDao;
import hummel.dao.UserDao;
import hummel.dao.impl.AuthorDaoImpl;
import hummel.dao.impl.BookDaoImpl;
import hummel.dao.impl.UserDaoImpl;

public final class DaoFactory {
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