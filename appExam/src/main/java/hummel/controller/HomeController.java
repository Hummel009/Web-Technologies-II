package hummel.controller;

import hummel.factory.ServiceFactory;
import hummel.service.XmlService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SuppressWarnings("SpringMVCViewInspection")
public class HomeController {
	private final XmlService saxService = ServiceFactory.INSTANCE.getSaxService();
	private final XmlService staxService = ServiceFactory.INSTANCE.getStaxService();
	private final XmlService domService = ServiceFactory.INSTANCE.getStaxService();

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/showData")
	public String showData(ServletRequest request, HttpServletResponse response) {
		var buttonClicked = request.getParameter("button");
		if (buttonClicked != null) {
			var listUsers = (switch (buttonClicked) {
				case "sax" -> saxService;
				case "stax" -> staxService;
				case "dom" -> domService;
				default -> throw new IllegalStateException("Unexpected value: " + buttonClicked);
			}).getUsers();
			request.setAttribute("result", listUsers);
		}
		return "result";
	}
}