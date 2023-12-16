package hummel.dao;

import hummel.bean.Book;
import hummel.bean.container.Page;
import hummel.exception.ConnectionException;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
	/**
	 * Inserts the provided Book object in the database.
	 *
	 * @param book The Book object to be inserted.
	 * @throws ConnectionException If there is an issue establishing a database
	 *                             connection.
	 * @throws SQLException        If a SQL error occurs during the operation.
	 */
	void addBook(Book book) throws ConnectionException, SQLException;

	/**
	 * Retrieves a specific book by its unique identifier.
	 *
	 * @param id The unique identifier of the book to be retrieved.
	 * @return The Book object corresponding to the specified identifier.
	 * @throws ConnectionException If there is an issue establishing a database
	 *                             connection.
	 * @throws SQLException        If a SQL error occurs during the operation.
	 */
	Book getBookById(int id) throws ConnectionException, SQLException;

	/**
	 * Retrieves a list of books written by the specified author based on the
	 * provided pagination parameters.
	 *
	 * @param author The name of the author for whom the books are to be
	 *               retrieved.
	 * @param params The pagination parameters for retrieving the list of books.
	 * @return A list of Book objects matching the specified author.
	 * @throws ConnectionException If there is an issue establishing a database
	 *                             connection.
	 * @throws SQLException        If a SQL error occurs during the operation.
	 */
	List<Book> getBooksByAuthor(String author, Page params) throws ConnectionException, SQLException;

	/**
	 * Retrieves a list of books associated with a particular order.
	 *
	 * @param orderId The identifier of the order for which books are to be
	 *                retrieved.
	 * @return A list of Book objects associated with the specified order.
	 * @throws ConnectionException If there is an issue establishing a database
	 *                             connection.
	 * @throws SQLException        If a SQL error occurs during the operation.
	 */
	List<Book> getBooksByOrder(int orderId) throws ConnectionException, SQLException;
}