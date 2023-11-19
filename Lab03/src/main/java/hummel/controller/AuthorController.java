package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/authors", "/authors/*"})
public class AuthorController {
	@GetMapping("/{name}")
	private void open(HttpServletRequest request, ServletResponse response, @PathVariable String name) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var authorService = serviceFactory.getAuthorService();
			authorService.getBooks(request, response, (ServletConfig) this, name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/{name}/paging")
	private void paging(HttpServletRequest request, ServletResponse response, @PathVariable String name) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var authorService = serviceFactory.getAuthorService();
			authorService.paging(request, response, (ServletConfig) this, name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}