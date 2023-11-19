package hummel.listener;

import hummel.ConnectionPool;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.stereotype.Component;

@Component
@WebListener
public class ContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ConnectionPool.getInstance().closeConnections();
	}
}