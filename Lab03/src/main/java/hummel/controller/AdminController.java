package hummel.controller;

import hummel.service.AdminService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping("/admin/addAuthor")
	private void addAuthor(HttpServletRequest request, HttpServletResponse response) {
		try {
			adminService.addAuthor(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/admin/addBook")
	private void addBook(HttpServletRequest request, HttpServletResponse response) {
		try {
			adminService.addBook(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/admin/banUser")
	private void banUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			adminService.banUser(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/admin")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			adminService.getAdminPage(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}