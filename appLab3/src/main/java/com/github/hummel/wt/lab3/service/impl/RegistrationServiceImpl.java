package com.github.hummel.wt.lab3.service.impl;

import com.github.hummel.wt.lab3.exception.ConnectionException;
import com.github.hummel.wt.lab3.exception.DatabaseException;
import com.github.hummel.wt.lab3.exception.ServiceException;
import com.github.hummel.wt.lab3.bean.User;
import com.github.hummel.wt.lab3.dao.UserDao;
import com.github.hummel.wt.lab3.dao.ex.UserDaoEx;
import com.github.hummel.wt.lab3.service.RegistrationService;
import com.github.hummel.wt.lab3.utils.Tools;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.regex.Pattern;

import static com.github.hummel.wt.lab3.utils.Constants.*;

@Service
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class RegistrationServiceImpl implements RegistrationService {
	private static final Pattern PATTERN = Pattern.compile("[A-Za-z]+");
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserDaoEx userDaoEx;

	private static boolean validateRegistration(ServletRequest request) {
		var name = request.getParameter(NAME);
		var lastName = request.getParameter(LAST_NAME);
		var email = request.getParameter(EMAIL);
		var birthDate = request.getParameter(BIRTH_DATE);
		var password = request.getParameter(PASSWORD);
		var status = true;
		if (!PATTERN.matcher(name).matches()) {
			request.setAttribute(NAME + ERROR, NAME_ERROR);
			status = false;
		}
		if (!PATTERN.matcher(lastName).matches()) {
			request.setAttribute(LAST_NAME + ERROR, LAST_NAME_ERROR);
			status = false;
		}
		var emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (!emailPattern.matcher(email).matches()) {
			request.setAttribute(EMAIL + ERROR, EMAIL_ERROR);
			status = false;
		}
		if (!isDateValid("yyyy-MM-dd", birthDate)) {
			request.setAttribute(BIRTH_DATE + ERROR, DATE_ERROR);
			status = false;
		}
		if (password.length() <= 2) {
			request.setAttribute(PASSWORD + ERROR, PASSWORD_ERROR);
			return false;
		}
		return status;
	}

	private static boolean isDateValid(String dateFormat, String dateStr) {
		DateFormat sdf = new SimpleDateFormat(dateFormat, Locale.ROOT);
		sdf.setLenient(false);
		try {
			sdf.parse(dateStr);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	@Override
	public void getRegistrationPage(ServletRequest request, ServletResponse response) throws ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + REGISTRATION_PAGE + POSTFIX);
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void registerUser(ServletRequest request, ServletResponse response) throws ServiceException, DatabaseException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + REGISTRATION_PAGE + POSTFIX);
			if (validateRegistration(request)) {
				var user = User.builder().id(0).name(request.getParameter(NAME)).lastName(request.getParameter(LAST_NAME)).email(request.getParameter(EMAIL)).birthDate(LocalDate.parse(request.getParameter(BIRTH_DATE))).registrationDate(LocalDate.now()).balance(0).password(Tools.getHash(request.getParameter(PASSWORD))).address(null).phoneNumber(null).build();
				if (userDao.ex(userDaoEx).getUserExistance(user.getEmail())) {
					request.setAttribute(COLOR, ERROR_COLOR);
					request.setAttribute(STATUS, USER_EXISTS_ERROR);
				} else {
					userDao.ex(userDaoEx).addUser(user);
					request.setAttribute(COLOR, SUCCESS_COLOR);
					request.setAttribute(STATUS, SUCCESS);
				}
			}
			requestDispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException | SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}
}