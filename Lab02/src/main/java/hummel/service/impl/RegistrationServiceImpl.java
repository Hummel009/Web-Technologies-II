package hummel.service.impl;

import hummel.bean.User;
import hummel.dao.UserDao;
import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.factory.DaoFactory;
import hummel.service.RegistrationService;
import hummel.utils.Tools;
import jakarta.servlet.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.regex.Pattern;

import static hummel.utils.Constants.*;

public class RegistrationServiceImpl implements RegistrationService {
	private static boolean validateRegistration(ServletRequest request) {
		String name = request.getParameter(NAME);
		String lastName = request.getParameter(LAST_NAME);
		String email = request.getParameter(EMAIL);
		String birthDate = request.getParameter(BIRTH_DATE);
		String password = request.getParameter(PASSWORD);
		boolean status = true;
		Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (!name.matches("[A-Za-z]+")) {
			request.setAttribute(NAME + ERROR, NAME_ERROR);
			status = false;
		}
		if (!lastName.matches("[A-Za-z]+")) {
			request.setAttribute(LAST_NAME + ERROR, LAST_NAME_ERROR);
			status = false;
		}
		if (!emailPattern.matcher(email).matches()) {
			request.setAttribute(EMAIL + ERROR, EMAIL_ERROR);
			status = false;
		}
		if (!isDateValid("yyyy-MM-dd", birthDate)) {
			request.setAttribute(BIRTH_DATE + ERROR, DATE_ERROR);
			status = false;
		}
		if ((password.length() <= 2)) {
			request.setAttribute(PASSWORD + ERROR, PASSWORD_ERROR);
			status = false;
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
	public void getRegistrationPage(ServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException {
		try {
			RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + REGISTRATION_PAGE + POSTFIX);
			requestDispatcher.forward(request, response);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void registerUser(ServletRequest request, ServletResponse response, ServletConfig servlet) throws ServiceException, DatabaseException {
		try {
			RequestDispatcher requestDispatcher = servlet.getServletContext().getRequestDispatcher(PREFIX + REGISTRATION_PAGE + POSTFIX);
			DaoFactory daoFactory = DaoFactory.INSTANCE;
			UserDao userDao = daoFactory.getUserDao();
			if (validateRegistration(request)) {
				User user = User.builder().id(0).name(request.getParameter(NAME)).lastName(request.getParameter(LAST_NAME)).email(request.getParameter(EMAIL)).birthDate(LocalDate.parse(request.getParameter(BIRTH_DATE))).registrationDate(LocalDate.now()).balance(0).password(Tools.getHash(request.getParameter(PASSWORD))).address(null).phoneNumber(null).build();
				if (userDao.getUserExistance(user.getEmail())) {
					request.setAttribute(COLOR, ERROR_COLOR);
					request.setAttribute(STATUS, USER_EXISTS_ERROR);
				} else {
					userDao.addUser(user);
					request.setAttribute(COLOR, SUCCESS_COLOR);
					request.setAttribute(STATUS, SUCCESS);
				}
			}
			requestDispatcher.forward(request, response);
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		} catch (SQLException e) {
			throw new DatabaseException(DB_EXCEPTION);
		}
	}
}