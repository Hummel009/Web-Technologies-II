package hummel.controller;

import com.kodgemisi.servlet_url_mapping.MappingServlet;
import com.kodgemisi.servlet_url_mapping.ServletUrl;
import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/profile", "/profile/*"})
public class ProfileController extends MappingServlet {
	public ProfileController() {
		urlMappingRegistrar.get("/", this::open);
		urlMappingRegistrar.get("/paging", this::paging);
		urlMappingRegistrar.post("/", this::addAddressAndPhoneNumber);
	}

	private void addAddressAndPhoneNumber(HttpServletRequest request, HttpServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var profileService = serviceFactory.getProfileService();
			profileService.addAddressAndPhoneNumber(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void open(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var profileService = serviceFactory.getProfileService();
			profileService.getUserInfo(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void paging(HttpServletRequest request, ServletResponse response, ServletUrl servletUrl) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var profileService = serviceFactory.getProfileService();
			profileService.paging(request, response, this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}