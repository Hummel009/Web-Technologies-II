package com.github.hummel.wt.lab3.service;

import com.github.hummel.wt.lab3.exception.DatabaseException;
import com.github.hummel.wt.lab3.exception.ServiceException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthorService {
	/**
	 * Retrieves the books of a specific author.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @param author   the name of the author
	 * @throws DatabaseException if a database-related exception occurs
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void getBooks(HttpServletRequest request, ServletResponse response, String author) throws DatabaseException, ServiceException;

	/**
	 * Performs paging for a specific author's books.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @param author   the name of the author
	 * @throws DatabaseException if a database-related exception occurs
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void paging(HttpServletRequest request, ServletResponse response, String author) throws DatabaseException, ServiceException;
}