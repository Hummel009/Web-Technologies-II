package com.github.hummel.wt.lab3.controller;

import com.github.hummel.wt.lab3.service.AuthorService;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@GetMapping("/authors/{name}")
	private void open(HttpServletRequest request, ServletResponse response, @PathVariable String name) {
		try {
			authorService.getBooks(request, response, name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/authors/{name}/paging")
	private void paging(HttpServletRequest request, ServletResponse response, @PathVariable String name) {
		try {
			authorService.paging(request, response, name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}