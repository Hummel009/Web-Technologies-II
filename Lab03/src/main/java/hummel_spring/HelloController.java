package hummel_spring;

import hummel.factory.ServiceFactory;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/")
	private void open(HttpServletRequest request, ServletResponse response) {
		try {
			var serviceFactory = ServiceFactory.INSTANCE;
			var indexService = serviceFactory.getIndexService();
			indexService.getIndexPage(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}