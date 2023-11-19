package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuthorController {
	@GetMapping("/authors/{name}")
	private void open(HttpServletRequest request, ServletResponse response, @PathVariable String name) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var authorService = serviceFactory.getAuthorService();
			authorService.getBooks(request, response, name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/authors/{name}/paging")
	private void paging(HttpServletRequest request, ServletResponse response, @PathVariable String name) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var authorService = serviceFactory.getAuthorService();
			authorService.paging(request, response, name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}