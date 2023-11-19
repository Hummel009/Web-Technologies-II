package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@PostMapping("/login")
	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var loginService = serviceFactory.getLoginService();
			loginService.login(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/login")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var loginService = serviceFactory.getLoginService();
			loginService.getLoginPage(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}