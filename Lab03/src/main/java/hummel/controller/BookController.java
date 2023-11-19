package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
	@GetMapping("/{id}")
	private void open(ServletRequest request, ServletResponse response, @PathVariable String id) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var bookService = serviceFactory.getBookService();
			bookService.getBook(request, response, (ServletConfig) this, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}