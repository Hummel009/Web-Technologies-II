package com.github.hummel.wt.lab3.controller;

import com.github.hummel.wt.lab3.service.CartService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class CartController {
	@Autowired
	private CartService cartService;

	@GetMapping("/cart/addBook/{id}")
	private void addBook(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		try {
			cartService.addBook(request, response, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/cart/clear")
	private void clear(HttpServletRequest request, ServletResponse response) {
		try {
			cartService.clearCart(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/cart/makeOrder")
	private void makeOrder(HttpServletRequest request, ServletResponse response) {
		try {
			cartService.makeOrder(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/cart")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			cartService.getCart(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/cart/removeBook/{id}")
	private void removeBook(HttpServletRequest request, ServletResponse response, @PathVariable String id) {
		try {
			cartService.removeBook(request, response, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}