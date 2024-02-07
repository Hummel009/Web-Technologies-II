package com.github.hummel.wt.lab3.dao;

import com.github.hummel.wt.lab3.bean.Author;
import com.github.hummel.wt.lab3.bean.container.Page;
import com.github.hummel.wt.lab3.dao.ex.AuthorDaoEx;
import com.github.hummel.wt.lab3.exception.ConnectionException;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {
	/**
	 * Inserts the provided Author object in the database.
	 *
	 * @param author The Author object to be inserted.
	 */
	void addAuthor(Author author);

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

	AuthorDao ex(AuthorDaoEx authorDaoEx);
}