package com.github.hummel.wt.lab3.listener;

import com.github.hummel.wt.lab3.ConnectionPool;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.stereotype.Component;

@Component
@WebListener
public class ContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ConnectionPool.getInstance().closeConnections();
	}
}