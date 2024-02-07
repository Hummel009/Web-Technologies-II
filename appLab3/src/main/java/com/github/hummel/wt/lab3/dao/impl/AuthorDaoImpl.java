package com.github.hummel.wt.lab3.dao.impl;

import com.github.hummel.wt.lab3.bean.container.Page;
import com.github.hummel.wt.lab3.exception.ConnectionException;
import com.github.hummel.wt.lab3.ConnectionPool;
import com.github.hummel.wt.lab3.bean.Author;
import com.github.hummel.wt.lab3.dao.AuthorDao;
import com.github.hummel.wt.lab3.dao.ex.AuthorDaoEx;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {
	private static final ConnectionPool POOL = ConnectionPool.getInstance();

	private static final String INSERT_AUTHOR = "INSERT INTO authors (name, imagePath) VALUES(?, ?)";

	private static final String SELECT_AUTHORS = "SELECT * FROM authors LIMIT ?, ?";

	private AuthorDaoEx authorDaoEx;

	@Override
	public AuthorDao ex(AuthorDaoEx authorDaoEx) {
		this.authorDaoEx = authorDaoEx;
		return this;
	}

	@Override
	public void addAuthor(Author author) {
		authorDaoEx.save(author);
	}

	@Override
	public List<Author> getAuthors(Page params) throws ConnectionException, SQLException {
		var connection = POOL.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SELECT_AUTHORS);
			var startPosition = params.getPageNumber() * params.getPageSize();
			statement.setInt(1, startPosition);
			statement.setInt(2, params.getPageSize());
			var set = statement.executeQuery();
			List<Author> result = new ArrayList<>();
			while (set.next()) {
				result.add(Author.builder().id(set.getInt("id")).name(set.getString("name")).imagePath(set.getString("imagePath")).build());
			}
			set.close();
			return result;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			POOL.returnConnection(connection);
		}
	}
}