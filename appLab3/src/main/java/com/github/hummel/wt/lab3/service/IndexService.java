package com.github.hummel.wt.lab3.service;

import com.github.hummel.wt.lab3.exception.DatabaseException;
import com.github.hummel.wt.lab3.exception.ServiceException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IndexService {
	/**
	 * Retrieves the index page.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the ServletResponse object
	 * @throws DatabaseException if a database-related exception occurs
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void getIndexPage(HttpServletRequest request, ServletResponse response) throws DatabaseException, ServiceException;

	/**
	 * Logs out the user.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @throws ServiceException if a service-related exception occurs
	 */
	void logout(HttpServletRequest request, HttpServletResponse response) throws ServiceException;

	/**
	 * Performs paging.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws DatabaseException if a database-related exception occurs
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void paging(HttpServletRequest request, ServletResponse response) throws DatabaseException, ServiceException;
}