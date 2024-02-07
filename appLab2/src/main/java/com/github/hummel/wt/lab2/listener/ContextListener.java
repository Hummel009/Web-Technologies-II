package com.github.hummel.wt.lab2.listener;

import com.github.hummel.wt.lab2.ConnectionPool;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ConnectionPool.getInstance().closeConnections();
	}
}