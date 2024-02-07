package com.github.hummel.wt.exam.dao.impl;

import com.github.hummel.wt.exam.dao.FileDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileDaoImpl implements FileDao {
	@Override
	public File getFile(String filePath) {
		return new File(filePath);
	}

	@Override
	public FileInputStream getFileInputStream(String filePath) throws FileNotFoundException {
		return new FileInputStream(filePath);
	}
}
