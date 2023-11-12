package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletRequestHandler;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import hummel.service.CartService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cart", "/cart/*"})
public class CartController extends MappingServlet {
	public CartController() {
		urlMappingRegistrar.get("/", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				open(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.get("/addBook/{id}", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				addBook(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.get("/removeBook/{id}", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				removeBook(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.get("/clear", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				clear(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.get("/makeOrder", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				makeOrder(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			CartService cartService = serviceFactory.getCartService();
			String id = servletUrl.variable("id");
			cartService.addBook(request, response, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void clear(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			CartService cartService = serviceFactory.getCartService();
			cartService.clearCart(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void makeOrder(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			CartService cartService = serviceFactory.getCartService();
			cartService.makeOrder(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void open(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			CartService cartService = serviceFactory.getCartService();
			cartService.getCart(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void removeBook(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			CartService cartService = serviceFactory.getCartService();
			String id = servletUrl.variable("id");
			cartService.removeBook(request, response, this, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}