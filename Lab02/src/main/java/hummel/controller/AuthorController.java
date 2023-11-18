package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet(urlPatterns = {"/authors", "/authors/*"})
public class AuthorController extends MappingServlet {
	public AuthorController() {
		urlMappingRegistrar.get("/{name}/paging", this::paging);
		urlMappingRegistrar.get("/{name}", this::open);
	}

	private void open(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var authorService = serviceFactory.getAuthorService();
			String author = servletUrl.variable("name");
			authorService.getBooks(request, response, this, author);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void paging(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var authorService = serviceFactory.getAuthorService();
			String author = servletUrl.variable("name");
			authorService.paging(request, response, this, author);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}