package hummel.controller;

import hummel.service.IndexService;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;

	@GetMapping("/index/logout")
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			indexService.logout(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/index")
	private void open(HttpServletRequest request, ServletResponse response) {
		try {
			indexService.getIndexPage(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/index/paging")
	private void paging(HttpServletRequest request, ServletResponse response) {
		try {
			indexService.paging(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}