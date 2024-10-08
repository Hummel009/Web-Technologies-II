package com.github.hummel.wt.lab2.service;

import com.github.hummel.wt.lab2.exception.DatabaseException;
import com.github.hummel.wt.lab2.exception.ServiceException;
import jakarta.servlet.ServletConfig;
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
	 * @throws DatabaseException if a database-related exception occurs
	 */
	void addBook(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DatabaseException;

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
	void getAdminPage(ServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException, DatabaseException;
}