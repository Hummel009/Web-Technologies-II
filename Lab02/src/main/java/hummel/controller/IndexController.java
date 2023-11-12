package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletRequestHandler;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import hummel.service.IndexService;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/index", "/index/*"})
public class IndexController extends MappingServlet {
	public IndexController() {
		urlMappingRegistrar.get("/", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				open(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.get("/paging", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				paging(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.get("/logout", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				logout(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
	}

	private void logout(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			IndexService indexService = serviceFactory.getIndexService();
			indexService.logout(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void open(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			IndexService indexService = serviceFactory.getIndexService();
			indexService.getIndexPage(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void paging(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			IndexService indexService = serviceFactory.getIndexService();
			indexService.paging(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}