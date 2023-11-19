package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
	@PostMapping("/profile/addAddressAndPhoneNumber")
	private void addAddressAndPhoneNumber(HttpServletRequest request, HttpServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var profileService = serviceFactory.getProfileService();
			profileService.addAddressAndPhoneNumber(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/profile")
	private void open(HttpServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var profileService = serviceFactory.getProfileService();
			profileService.getUserInfo(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/profile/paging")
	private void paging(HttpServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var profileService = serviceFactory.getProfileService();
			profileService.paging(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}