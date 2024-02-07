package com.github.hummel.wt.lab3.controller;

import com.github.hummel.wt.lab3.service.BookService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/books/{id}")
	private void open(ServletRequest request, ServletResponse response, @PathVariable String id) {
		try {
			bookService.getBook(request, response, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}