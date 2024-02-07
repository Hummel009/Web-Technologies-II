package com.github.hummel.wt.lab3.controller;

import com.github.hummel.wt.lab3.service.RegistrationService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/registration")
	private void open(ServletRequest request, ServletResponse response) {
		try {
			registrationService.getRegistrationPage(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/registration")
	private void register(ServletRequest request, ServletResponse response) {
		try {
			registrationService.registerUser(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}