package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletRequestHandler;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import hummel.service.AuthorService;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/authors", "/authors/*"})
public class AuthorController extends MappingServlet {
	public AuthorController() {
		urlMappingRegistrar.get("/{name}/paging", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				paging(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.get("/{name}", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				open(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
	}

	private void open(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			AuthorService authorService = serviceFactory.getAuthorService();
			String author = servletUrl.variable("name");
			authorService.getBooks(request, response, this, author);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void paging(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			AuthorService authorService = serviceFactory.getAuthorService();
			String author = servletUrl.variable("name");
			authorService.paging(request, response, this, author);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}