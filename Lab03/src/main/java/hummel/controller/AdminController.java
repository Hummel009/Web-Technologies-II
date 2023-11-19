package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin", "/admin/*"})
public class AdminController {
	@PostMapping("/addAuthor")
	private void addAuthor(HttpServletRequest request, HttpServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var adminService = serviceFactory.getAdminService();
			adminService.addAuthor(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/addBook")
	private void addBook(HttpServletRequest request, HttpServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var adminService = serviceFactory.getAdminService();
			adminService.addBook(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/banUser")
	private void banUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var adminService = serviceFactory.getAdminService();
			adminService.banUser(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var adminService = serviceFactory.getAdminService();
			adminService.getAdminPage(request, response, (ServletConfig) this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}