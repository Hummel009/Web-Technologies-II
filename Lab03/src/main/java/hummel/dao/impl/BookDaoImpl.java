package hummel.dao.impl;

import hummel.ConnectionPool;
import hummel.bean.Book;
import hummel.bean.container.Page;
import hummel.dao.BookDao;
import hummel.dao.ex.BookDaoEx;
import hummel.exception.ConnectionException;
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
		return bookDaoEx.findById(id).isPresent() ? bookDaoEx.findById(id).get() : null;
	}

	@Override
	public List<Book> getBooksByAuthor(String author, Page params) throws ConnectionException, SQLException {
		List<Book> result = new ArrayList<>();
		var connection = POOL.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SELECT_BOOKS_BY_AUTHOR);
			var startPosition = params.getPageNumber() * params.getPageSize();
			statement.setString(1, author);
			statement.setInt(2, startPosition);
			statement.setInt(3, params.getPageSize());
			var set = statement.executeQuery();
			while (set.next()) {
				result.add(Book.builder().id(set.getInt("id")).name(set.getString("name")).description(set.getString("description")).imagePath(set.getString("imagePath")).author(set.getString("author")).price(set.getDouble("price")).build());
			}
			set.close();
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
		return result;
	}
}
