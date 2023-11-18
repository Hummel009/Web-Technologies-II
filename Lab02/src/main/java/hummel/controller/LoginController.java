package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginController extends MappingServlet {
	public LoginController() {
		urlMappingRegistrar.get("/", this::open);
		urlMappingRegistrar.post("/", this::login);
	}

	private void login(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var loginService = serviceFactory.getLoginService();
			loginService.login(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void open(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var loginService = serviceFactory.getLoginService();
			loginService.getLoginPage(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}