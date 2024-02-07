package com.github.hummel.wt.lab3.service;

import com.github.hummel.wt.lab3.exception.DatabaseException;
import com.github.hummel.wt.lab3.exception.ServiceException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ProfileService {
	/**
	 * Adds address and phone number.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @throws DatabaseException if a database-related exception occurs
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void addAddressAndPhoneNumber(HttpServletRequest request, HttpServletResponse response) throws DatabaseException, ServiceException;

	/**
	 * Retrieves user information.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the ServletResponse object
	 * @param servlet  the ServletConfig object
	 * @throws DatabaseException if a database-related exception occurs
	 * @throws ServiceException  if a service-related exception occurs
	 */
	void getUserInfo(HttpServletRequest request, ServletResponse response) throws DatabaseException, ServiceException;

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