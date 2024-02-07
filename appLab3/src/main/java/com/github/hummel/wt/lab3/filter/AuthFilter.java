package com.github.hummel.wt.lab3.filter;

import com.github.hummel.wt.lab3.utils.Constants;
import com.github.hummel.wt.lab3.bean.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

@Component
@WebFilter("/*")
public class AuthFilter implements Filter {
	private static final String LOGIN_URI = "/login";

	private boolean auth(Iterable<String> protectedURIS, String actualURI, HttpServletRequest request, Iterable<String> requiredRoles) {
		for (var URI : protectedURIS) {
			if (isPathMatches(actualURI, request.getContextPath() + URI)) {
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

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
		var request = (HttpServletRequest) servletRequest;
		var response = (HttpServletResponse) servletResponse;
		var URI = request.getRequestURI();
		var contextPath = request.getContextPath();
		if (auth(Arrays.asList("/profile/**", "/profile"), URI, request, Collections.emptyList()) && auth(Arrays.asList("/admin/**", "/admin"), URI, request, Collections.singletonList("ROLE_ADMIN")) && auth(Collections.singletonList("/cart/makeOrder"), URI, request, Collections.emptyList())) {
			filterChain.doFilter(request, response);
		} else {
			response.sendRedirect(contextPath + LOGIN_URI);
		}
	}

	private boolean isPathMatches(String path, String template) {
		return FileSystems.getDefault().getPathMatcher("glob:" + template).matches(Paths.get(path));
	}
}