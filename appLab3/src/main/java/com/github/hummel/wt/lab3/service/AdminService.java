package com.github.hummel.wt.lab3.service;

import com.github.hummel.wt.lab3.exception.DatabaseException;
import com.github.hummel.wt.lab3.exception.ServiceException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AdminService {
	/**
	 * Adds an author.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @throws ServiceException  if a service-related exception occurs
	 * @throws DatabaseException if a database-related exception occurs
	 */
	void addAuthor(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DatabaseException;

	/**
	 * Adds a book.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void addBook(HttpServletRequest request, HttpServletResponse response) throws ServiceException;

	/**
	 * Bans a user.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @throws ServiceException  if a service-related exception occurs
	 * @throws DatabaseException if a database-related exception occurs
	 */
	void banUser(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DatabaseException;

	/**
	 * Retrieves the admin page.
	 *
	 * @param request  the ServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws ServiceException  if a service-related exception occurs
	 * @throws DatabaseException if a database-related exception occurs
	 */
	void getAdminPage(ServletRequest request, ServletResponse response) throws ServiceException, DatabaseException;
}