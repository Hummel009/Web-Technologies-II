package hummel.dao;

import hummel.bean.Book;
import hummel.bean.Order;
import hummel.bean.Role;
import hummel.bean.User;
import hummel.bean.container.Cart;
import hummel.bean.container.Page;
import hummel.dao.ex.UserDaoEx;
import hummel.exception.ConnectionException;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	/**
	 * Makes an order for a user based on the contents of a cart.
	 *
	 * @param cart   the Cart object representing the user's cart
	 * @param userId the ID of the user
	 * @return the Order object representing the made order
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	Order addOrder(Cart cart, int userId) throws ConnectionException, SQLException;

	/**
	 * Inserts a user.
	 *
	 * @param user the User object to addAuthor
	 * @throws SQLException        if a SQL-related exception occurs
	 * @throws ConnectionException if a connection-related exception occurs
	 */
	void addUser(User user) throws SQLException, ConnectionException;

	/**
	 * Retrieves the balance of a user.
	 *
	 * @param userId the ID of the user
	 * @return the balance of the user
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	double getBalance(int userId) throws ConnectionException, SQLException;

	/**
	 * Retrieves the banned status of a user.
	 *
	 * @param userId the ID of the user
	 * @return the banned status of the user (0 for not banned, 1 for banned)
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	int getBanStatus(int userId) throws ConnectionException, SQLException;

	/**
	 * Retrieves the number of purchased books by a user.
	 *
	 * @param userId the ID of the user
	 * @return the number of purchased books by the user
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	int getBooksQuantity(int userId) throws ConnectionException, SQLException;

	/**
	 * Retrieves the favorite author of a user.
	 *
	 * @param userId the ID of the user
	 * @return the favorite author ofthe user
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	String getFavouriteAuthor(int userId) throws ConnectionException, SQLException;

	/**
	 * Retrieves a list of orders for a user with pagination.
	 *
	 * @param userId the ID of the user
	 * @param params the Page object containing pagination parameters
	 * @return a list of Order objects
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	List<Order> getOrders(int userId, Page params) throws ConnectionException, SQLException;

	/**
	 * Retrieves the number of orders made by a user.
	 *
	 * @param userId the ID of the user
	 * @return the number of orders made by the user
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	int getOrdersQuantity(int userId) throws ConnectionException, SQLException;

	/**
	 * Retrieves the roles of a user.
	 *
	 * @param userId the ID of the user
	 * @return a list of Role objects representing the roles of the user
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	List<Role> getRoles(int userId) throws ConnectionException, SQLException;

	/**
	 * Retrieves a user by email.
	 *
	 * @param email the email of the user
	 * @return the User object if found, null otherwise
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	User getUserByEmail(String email) throws ConnectionException, SQLException;

	/**
	 * Retrieves a user by credentials (email and password).
	 *
	 * @param email    the email of the user
	 * @param password the password of the user
	 * @return the User object if the credentials match, null otherwise
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	User getUserByEmailPassword(String email, String password) throws ConnectionException, SQLException;

	/**
	 * Checks if a user with the specified email is present in the database.
	 *
	 * @param userEmail the email of the user
	 * @return true if the user is present, false otherwise
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	boolean getUserExistance(String userEmail) throws ConnectionException, SQLException;

	/**
	 * Updates the address and phone number of a user.
	 *
	 * @param address     the new address
	 * @param phoneNumber the new phone number
	 * @param userId      the ID of the user
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	void updateAddressPhone(String address, String phoneNumber, int userId) throws ConnectionException, SQLException;

	/**
	 * Sets the banned status of a user.
	 *
	 * @param banned the banned status (0 for not banned, 1 for banned)
	 * @param userId the ID of the user
	 * @throws ConnectionException if a connection-related exception occurs
	 * @throws SQLException        if a SQL-related exception occurs
	 */
	void updateBanStatus(int banned, int userId) throws ConnectionException, SQLException;

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

	UserDao ex(UserDaoEx bookDaoEx);
}