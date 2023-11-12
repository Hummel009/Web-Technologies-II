package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletRequestHandler;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import hummel.service.AdminService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin", "/admin/*"})
@MultipartConfig
public class AdminController extends MappingServlet {
	public AdminController() {
		urlMappingRegistrar.get("/", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				open(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.post("/addAuthor", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				addAuthor(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.post("/addBook", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				addBook(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.post("/banUser", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				banUser(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
	}

	private void addAuthor(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			AdminService adminService = serviceFactory.getAdminService();
			adminService.addAuthor(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			AdminService adminService = serviceFactory.getAdminService();
			adminService.addBook(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void banUser(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			AdminService adminService = serviceFactory.getAdminService();
			adminService.banUser(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void open(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			AdminService adminService = serviceFactory.getAdminService();
			adminService.getAdminPage(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}