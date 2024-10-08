package com.github.hummel.wt.lab2.dao;

import com.github.hummel.wt.lab2.bean.Author;
import com.github.hummel.wt.lab2.bean.container.Page;
import com.github.hummel.wt.lab2.exception.ConnectionException;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {
	/**
	 * Inserts the provided Author object in the database.
	 *
	 * @param author The Author object to be inserted.
	 * @throws ConnectionException If there is an issue establishing a database
	 *                             connection.
	 * @throws SQLException        If a SQL error occurs during the operation.
	 */
	void addAuthor(Author author) throws ConnectionException, SQLException;

	/**
	 * Retrieves a list of authors based on the provided pagination parameters.
	 *
	 * @param params The pagination parameters for retrieving the list of
	 *               authors.
	 * @return A list of Author objects.
	 * @throws ConnectionException If there is an issue establishing a database
	 *                             connection.
	 * @throws SQLException        If a SQL error occurs during the operation.
	 */
	List<Author> getAuthors(Page params) throws ConnectionException, SQLException;
}