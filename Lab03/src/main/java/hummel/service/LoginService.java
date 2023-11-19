package hummel.service;

import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface LoginService {
	/**
	 * Retrieves the login page.
	 *
	 * @param request  the ServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws ServiceException if a service-related exception occurs
	 */
	void getLoginPage(ServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException;

	/**
	 * Performs user login.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws DatabaseException if a database-related exception occurs
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void login(HttpServletRequest request, HttpServletResponse response, ServletConfig servlet) throws DatabaseException, ServiceException;
}