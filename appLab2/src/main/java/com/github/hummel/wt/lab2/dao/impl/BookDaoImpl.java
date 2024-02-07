package com.github.hummel.wt.lab2.dao.impl;

import com.github.hummel.wt.lab2.bean.container.Page;
import com.github.hummel.wt.lab2.exception.ConnectionException;
import com.github.hummel.wt.lab2.ConnectionPool;
import com.github.hummel.wt.lab2.bean.Book;
import com.github.hummel.wt.lab2.dao.BookDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
	private static final ConnectionPool POOL = ConnectionPool.getInstance();

	private static final String INSERT_BOOK = "INSERT INTO books (name, description, imagePath, author, price) VALUES (?, ?, ?, ?, ?)";

	private static final String SELECT_BOOKS_BY_AUTHOR = "SELECT * FROM books WHERE author = ? LIMIT ?, ?";
	private static final String SELECT_BOOKS_BY_ORDER = "SELECT * FROM orders_books JOIN books ON orders_books.bookId = books.id WHERE orderId = ?";
	private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";

	@Override
	public void addBook(Book book) throws ConnectionException, SQLException {
		var connection = POOL.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(INSERT_BOOK);
			statement.setString(1, book.getName());
			statement.setString(2, book.getDescription());
			statement.setString(3, book.getImagePath());
			statement.setString(4, book.getAuthor());
			statement.setDouble(5, book.getPrice());
			statement.execute();
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

	@Override
	public Book getBookById(int id) throws ConnectionException, SQLException {
		var connection = POOL.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SELECT_BOOK_BY_ID);
			statement.setInt(1, id);
			var set = statement.executeQuery();
			Book book = null;
			if (set.next()) {
				book = Book.builder().id(set.getInt("id")).name(set.getString("name")).description(set.getString("description")).imagePath(set.getString("imagePath")).author(set.getString("author")).price(set.getDouble("price")).build();
			}
			set.close();
			return book;
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

	@Override
	public List<Book> getBooksByOrder(int orderId) throws ConnectionException, SQLException {
		var connection = POOL.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SELECT_BOOKS_BY_ORDER);
			statement.setInt(1, orderId);
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
