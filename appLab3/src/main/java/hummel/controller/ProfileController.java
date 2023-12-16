package hummel.controller;

import hummel.service.ProfileService;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
	@Autowired
	private ProfileService profileService;

	@PostMapping("/profile")
	private void addAddressAndPhoneNumber(HttpServletRequest request, HttpServletResponse response) {
		try {
			profileService.addAddressAndPhoneNumber(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/profile")
	private void open(HttpServletRequest request, ServletResponse response) {
		try {
			profileService.getUserInfo(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/profile/paging")
	private void paging(HttpServletRequest request, ServletResponse response) {
		try {
			profileService.paging(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}