package com.github.hummel.wt.exam.factory;

import com.github.hummel.wt.exam.dao.FileDao;
import com.github.hummel.wt.exam.dao.impl.FileDaoImpl;

public class DaoFactory {
	public static final DaoFactory INSTANCE = new DaoFactory();

	private final FileDao fileDao = new FileDaoImpl();

	private DaoFactory() {
	}

	public FileDao getFileDao() {
		return fileDao;
	}
}
