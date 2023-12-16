package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/index", "/index/*"})
public class IndexController extends MappingServlet {
	public IndexController() {
		urlMappingRegistrar.get("/", this::open);
		urlMappingRegistrar.get("/paging", this::paging);
		urlMappingRegistrar.get("/logout", this::logout);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var indexService = serviceFactory.getIndexService();
			indexService.logout(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void open(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var indexService = serviceFactory.getIndexService();
			indexService.getIndexPage(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void paging(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var indexService = serviceFactory.getIndexService();
			indexService.paging(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}