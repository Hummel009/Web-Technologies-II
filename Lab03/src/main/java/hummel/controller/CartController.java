package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/cart", "/cart/*"})
public class CartController {
	@PostMapping("/{id}/addBook")
	private void addBook(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.addBook(request, response, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/clear")
	private void clear(HttpServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.clearCart(request, response, (ServletConfig) this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/makeOrder")
	private void makeOrder(HttpServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.makeOrder(request, response, (ServletConfig) this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.getCart(request, response, (ServletConfig) this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/{id}/removeBook")
	private void removeBook(HttpServletRequest request, ServletResponse response, @PathVariable String id) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.removeBook(request, response, (ServletConfig) this, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}