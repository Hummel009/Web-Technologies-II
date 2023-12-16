package hummel.controller;

import hummel.service.LoginService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			loginService.login(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/login")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			loginService.getLoginPage(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}