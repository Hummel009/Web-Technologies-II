package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	@GetMapping("/")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var registrationService = serviceFactory.getRegistrationService();
			registrationService.getRegistrationPage(request, response, (ServletConfig) this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/")
	private void register(ServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var registrationService = serviceFactory.getRegistrationService();
			registrationService.registerUser(request, response, (ServletConfig) this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}