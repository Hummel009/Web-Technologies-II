package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletRequestHandler;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import hummel.service.RegistrationService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/registration")
public class RegistrationController extends MappingServlet {
	public RegistrationController() {
		urlMappingRegistrar.get("/", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				open(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.post("/", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				register(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
	}

	private void open(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			RegistrationService registrationService = serviceFactory.getRegistrationService();
			registrationService.getRegistrationPage(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void register(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			RegistrationService registrationService = serviceFactory.getRegistrationService();
			registrationService.registerUser(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}