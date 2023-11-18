package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/registration")
public class RegistrationController extends MappingServlet {
	public RegistrationController() {
		urlMappingRegistrar.get("/", this::open);
		urlMappingRegistrar.post("/", this::register);
	}

	private void open(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var registrationService = serviceFactory.getRegistrationService();
			registrationService.getRegistrationPage(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void register(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var registrationService = serviceFactory.getRegistrationService();
			registrationService.registerUser(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}