package com.github.hummel.wt.lab2.filter;

import com.github.hummel.wt.lab2.bean.User;
import com.github.hummel.wt.lab2.utils.Constants;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

@WebFilter("/*")
public class AuthFilter implements Filter {
	private static final String LOGIN_URI = "/login";

	private static boolean auth(Iterable<String> protectedURIS, String actualURI, HttpServletRequest request, Iterable<String> requiredRoles) {
		for (var uri : protectedURIS) {
			if (isPathMatches(actualURI, request.getContextPath() + uri)) {
				var session = request.getSession();
				var user = (User) session.getAttribute(Constants.USER);
				if (user != null && user.getBanned() == 0) {
					var isAuthorized = true;
					for (var role : requiredRoles) {
						isAuthorized = isAuthorized && user.hasRole(role);
					}
					return isAuthorized;
				}
				return false;
			}
		}
		return true;
	}

	private static boolean isPathMatches(String path, String template) {
		return FileSystems.getDefault().getPathMatcher("glob:" + template).matches(Paths.get(path));
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
		var request = (HttpServletRequest) servletRequest;
		var response = (HttpServletResponse) servletResponse;
		var uri = request.getRequestURI();
		var contextPath = request.getContextPath();
		if (auth(Arrays.asList("/profile/**", "/profile"), uri, request, Collections.emptyList()) && auth(Arrays.asList("/admin/**", "/admin"), uri, request, Collections.singletonList("ROLE_ADMIN")) && auth(Collections.singletonList("/cart/makeOrder"), uri, request, Collections.emptyList())) {
			filterChain.doFilter(request, response);
		} else {
			response.sendRedirect(contextPath + LOGIN_URI);
		}
	}
}