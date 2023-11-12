package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletRequestHandler;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import hummel.service.ProfileService;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/profile", "/profile/*"})
public class ProfileController extends MappingServlet {
	public ProfileController() {
		urlMappingRegistrar.get("/", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				open(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.get("/paging", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				paging(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
		urlMappingRegistrar.post("/", new ServletRequestHandler() {
			@Override
			public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletUrl servletUrl) {
				addAddressAndPhoneNumber(httpServletRequest, httpServletResponse, servletUrl);
			}
		});
	}

	private void addAddressAndPhoneNumber(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			ProfileService profileService = serviceFactory.getProfileService();
			profileService.addAddressAndPhoneNumber(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void open(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			ProfileService profileService = serviceFactory.getProfileService();
			profileService.getUserInfo(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void paging(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
			ProfileService profileService = serviceFactory.getProfileService();
			profileService.paging(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}