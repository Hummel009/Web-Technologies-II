package com.github.hummel.wt.lab2.controller;

import com.github.hummel.wt.lab2.factory.ServiceFactory;
import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin", "/admin/*"})
@MultipartConfig
public class AdminController extends MappingServlet {
	public AdminController() {
		urlMappingRegistrar.get("/", this::open);
		urlMappingRegistrar.post("/addAuthor", AdminController::addAuthor);
		urlMappingRegistrar.post("/addBook", AdminController::addBook);
		urlMappingRegistrar.post("/banUser", AdminController::banUser);
	}

	private static void addAuthor(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var adminService = serviceFactory.getAdminService();
			adminService.addAuthor(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void addBook(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var adminService = serviceFactory.getAdminService();
			adminService.addBook(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void banUser(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var adminService = serviceFactory.getAdminService();
			adminService.banUser(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void open(ServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var adminService = serviceFactory.getAdminService();
			adminService.getAdminPage(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}