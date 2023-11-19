package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
	@GetMapping("/registration")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var registrationService = serviceFactory.getRegistrationService();
			registrationService.getRegistrationPage(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/registration")
	private void register(ServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var registrationService = serviceFactory.getRegistrationService();
			registrationService.registerUser(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}