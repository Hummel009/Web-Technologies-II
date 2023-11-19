package hummel.service;

import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public interface RegistrationService {
	/**
	 * Retrieves the registration page.
	 *
	 * @param request  the ServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws ServiceException if a service-related exception occurs
	 */
	void getRegistrationPage(ServletRequest request, ServletResponse response) throws ServiceException;

	/**
	 * Registers a user.
	 *
	 * @param request  the ServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws ServiceException  if a service-related exception occurs
	 * @throws DatabaseException if a database-related exception occurs
	 */
	void registerUser(ServletRequest request, ServletResponse response) throws ServiceException, DatabaseException;
}