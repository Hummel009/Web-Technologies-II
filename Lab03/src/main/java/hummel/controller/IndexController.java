package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/index/logout")
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var indexService = serviceFactory.getIndexService();
			indexService.logout(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/index")
	private void open(HttpServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var indexService = serviceFactory.getIndexService();
			indexService.getIndexPage(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/index/paging")
	private void paging(HttpServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var indexService = serviceFactory.getIndexService();
			indexService.paging(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}