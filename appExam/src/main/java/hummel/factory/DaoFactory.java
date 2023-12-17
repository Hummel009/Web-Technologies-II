package hummel.factory;

import hummel.dao.FileDao;
import hummel.dao.impl.FileDaoImpl;

public final class DaoFactory {
	public static final DaoFactory INSTANCE = new DaoFactory();

	private final FileDao fileDao = new FileDaoImpl();

	private DaoFactory() {
	}

	public FileDao getFileDao() {
		return fileDao;
	}
}
