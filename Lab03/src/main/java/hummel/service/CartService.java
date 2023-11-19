package hummel.service;

import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CartService {
	/**
	 * Adds a book to the cart.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @param id       the ID of the book to add
	 * @throws ServiceException  if a service-related exception occurs
	 * @throws DatabaseException if a database-related exception occurs
	 */
	void addBook(HttpServletRequest request, HttpServletResponse response, String id) throws ServiceException, DatabaseException;

	/**
	 * Clears the cart.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws ServiceException if a service-related exception occurs
	 */
	void clearCart(HttpServletRequest request, ServletResponse response) throws ServiceException;

	/**
	 * Retrieves the cart.
	 *
	 * @param request  the ServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws ServiceException if a service-related exception occurs
	 */
	void getCart(ServletRequest request, ServletResponse response) throws ServiceException;

	/**
	 * Makes an order based on the contents of the cart.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws DatabaseException if a database-related exception occurs
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void makeOrder(HttpServletRequest request, ServletResponse response) throws DatabaseException, ServiceException;

	/**
	 * Removes a book from the cart.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @param id       the ID of the book to remove
	 * @throws ServiceException if a service-related exception occurs
	 */
	void removeBook(HttpServletRequest request, ServletResponse response, String id) throws ServiceException;
}