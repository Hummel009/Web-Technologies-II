package hummel.controller;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
	@GetMapping("/cart/addBook/{id}")
	private void addBook(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.addBook(request, response, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/cart/clear")
	private void clear(HttpServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.clearCart(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/cart/makeOrder")
	private void makeOrder(HttpServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.makeOrder(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/cart")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.getCart(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/cart/removeBook/{id}")
	private void removeBook(HttpServletRequest request, ServletResponse response, @PathVariable String id) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.removeBook(request, response, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}