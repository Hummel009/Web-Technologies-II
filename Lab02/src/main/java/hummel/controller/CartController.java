package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cart", "/cart/*"})
public class CartController extends MappingServlet {
	public CartController() {
		urlMappingRegistrar.get("/", this::open);
		urlMappingRegistrar.get("/addBook/{id}", this::addBook);
		urlMappingRegistrar.get("/removeBook/{id}", this::removeBook);
		urlMappingRegistrar.get("/clear", this::clear);
		urlMappingRegistrar.get("/makeOrder", this::makeOrder);
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			String id = servletUrl.variable("id");
			cartService.addBook(request, response, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void clear(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.clearCart(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void makeOrder(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.makeOrder(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void open(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			cartService.getCart(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void removeBook(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var cartService = serviceFactory.getCartService();
			String id = servletUrl.variable("id");
			cartService.removeBook(request, response, this, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}