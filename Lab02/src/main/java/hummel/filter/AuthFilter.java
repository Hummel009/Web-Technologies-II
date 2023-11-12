package hummel.filter;

import hummel.bean.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

import static hummel.utils.Constants.USER;

@WebFilter("/*")
public class AuthFilter implements Filter {
	private static final String LOGIN_URI = "/login";

	private boolean auth(Iterable<String> protectedURIS, String actualURI, HttpServletRequest request, Iterable<String> requiredRoles) {
		for (String URI : protectedURIS) {
			if (isPathMatches(actualURI, request.getContextPath() + URI)) {
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute(USER);
				if (user != null && user.getBanned() == 0) {
					boolean isAuthorized = true;
					for (String role : requiredRoles) {
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
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String URI = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (auth(Arrays.asList("/profile/**", "/profile"), URI, request, Collections.<String>emptyList()) && auth(Arrays.asList("/admin/**", "/admin"), URI, request, Collections.singletonList("ROLE_ADMIN")) && auth(Collections.singletonList("/cart/makeOrder"), URI, request, Collections.<String>emptyList())) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(contextPath + LOGIN_URI);
		}
	}

	public boolean isPathMatches(String path, String template) {
		return FileSystems.getDefault().getPathMatcher("glob:" + template).matches(Paths.get(path));
	}
}