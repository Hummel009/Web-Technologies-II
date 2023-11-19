package hummel.service;

import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public interface BookService {
	/**
	 * Retrieves a book by its ID.
	 *
	 * @param request  the ServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @param id       the ID of the book
	 * @throws DatabaseException if a database-related exception occurs
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void getBook(ServletRequest request, ServletResponse response, String id) throws DatabaseException, ServiceException;
}