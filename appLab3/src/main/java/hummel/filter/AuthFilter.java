package hummel.filter;

import hummel.bean.User;
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

import static hummel.utils.Constants.USER;

@Component
@WebFilter("/*")
public class AuthFilter implements Filter {
	private static final String LOGIN_URI = "/login";

	private boolean auth(Iterable<String> protectedURIS, String actualURI, HttpServletRequest request, Iterable<String> requiredRoles) {
		for (var URI : protectedURIS) {
			if (isPathMatches(actualURI, request.getContextPath() + URI)) {
				var session = request.getSession();
				var user = (User) session.getAttribute(USER);
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
		var request = (HttpServletRequest) req;
		var response = (HttpServletResponse) res;
		var URI = request.getRequestURI();
		var contextPath = request.getContextPath();
		if (auth(Arrays.asList("/profile/**", "/profile"), URI, request, Collections.emptyList()) && auth(Arrays.asList("/admin/**", "/admin"), URI, request, Collections.singletonList("ROLE_ADMIN")) && auth(Collections.singletonList("/cart/makeOrder"), URI, request, Collections.emptyList())) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(contextPath + LOGIN_URI);
		}
	}

	public boolean isPathMatches(String path, String template) {
		return FileSystems.getDefault().getPathMatcher("glob:" + template).matches(Paths.get(path));
	}
}