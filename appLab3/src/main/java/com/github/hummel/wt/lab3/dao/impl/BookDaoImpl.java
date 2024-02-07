package com.github.hummel.wt.lab3.dao.impl;

import com.github.hummel.wt.lab3.bean.Book;
import com.github.hummel.wt.lab3.bean.container.Page;
import com.github.hummel.wt.lab3.dao.BookDao;
import com.github.hummel.wt.lab3.dao.ex.BookDaoEx;
import com.github.hummel.wt.lab3.exception.ConnectionException;
import com.github.hummel.wt.lab3.ConnectionPool;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
	private static final ConnectionPool POOL = ConnectionPool.getInstance();

	private static final String INSERT_BOOK = "INSERT INTO books (name, description, imagePath, author, price) VALUES (?, ?, ?, ?, ?)";

	private static final String SELECT_BOOKS_BY_AUTHOR = "SELECT * FROM books WHERE author = ? LIMIT ?, ?";
	private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";

	private BookDaoEx bookDaoEx;

	@Override
	public BookDao ex(BookDaoEx bookDaoEx) {
		this.bookDaoEx = bookDaoEx;
		return this;
	}

	@Override
	public void addBook(Book book) {
		bookDaoEx.save(book);
	}

	@Override
	public Book getBookById(int id) {
		if (bookDaoEx.findById(id).isPresent()) {
			return bookDaoEx.findById(id).get();
		}
		return null;
	}

	@Override
	public List<Book> getBooksByAuthor(String author, Page params) throws ConnectionException, SQLException {
		var connection = POOL.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SELECT_BOOKS_BY_AUTHOR);
			var startPosition = params.getPageNumber() * params.getPageSize();
			statement.setString(1, author);
			statement.setInt(2, startPosition);
			statement.setInt(3, params.getPageSize());
			var set = statement.executeQuery();
			List<Book> result = new ArrayList<>();
			while (set.next()) {
				result.add(Book.builder().id(set.getInt("id")).name(set.getString("name")).description(set.getString("description")).imagePath(set.getString("imagePath")).author(set.getString("author")).price(set.getDouble("price")).build());
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
