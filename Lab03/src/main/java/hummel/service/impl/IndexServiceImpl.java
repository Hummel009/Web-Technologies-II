package hummel.service.impl;

import hummel.bean.container.Page;
import hummel.dao.AuthorDao;
import hummel.dao.ex.AuthorDaoEx;
import hummel.exception.ConnectionException;
import hummel.exception.DatabaseException;
import hummel.exception.ServiceException;
import hummel.service.IndexService;
import hummel.utils.Tools;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

import static hummel.utils.Constants.*;

@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private AuthorDaoEx authorDaoEx;

	@Override
	public void getIndexPage(HttpServletRequest request, ServletResponse response) throws DatabaseException, ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + INDEX_PAGE + POSTFIX);
			var authorPaging = (Page) request.getSession().getAttribute(AUTHOR_PAGING_PARAMS);
			request.setAttribute(AUTHORS, authorDao.ex(authorDaoEx).getAuthors(authorPaging));
			requestDispatcher.forward(request, response);
		} catch (SQLException | ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		try {
			request.getSession().setAttribute(USER, null);
			response.sendRedirect(request.getContextPath() + "/login");
		} catch (IOException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}

	@Override
	public void paging(HttpServletRequest request, ServletResponse response) throws DatabaseException, ServiceException {
		try {
			var requestDispatcher = request.getServletContext().getRequestDispatcher(PREFIX + INDEX_PAGE + POSTFIX);
			request.setAttribute(AUTHORS, authorDao.ex(authorDaoEx).getAuthors(Tools.updatePagingParams(request, AUTHOR_PAGING_PARAMS)));
			requestDispatcher.forward(request, response);
		} catch (SQLException | ConnectionException e) {
			throw new DatabaseException(DB_EXCEPTION);
		} catch (IOException | ServletException e) {
			throw new ServiceException(SERVICE_EXCEPTION);
		}
	}
}