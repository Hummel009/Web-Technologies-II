package com.github.hummel.wt.lab2.controller;

import com.github.hummel.wt.lab2.factory.ServiceFactory;
import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/books/*")
public class BookController extends MappingServlet {
	public BookController() {
		urlMappingRegistrar.get("/{id}", this::open);
	}

	private void open(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var bookService = serviceFactory.getBookService();
			String id = servletUrl.variable("id");
			bookService.getBook(request, response, this, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}