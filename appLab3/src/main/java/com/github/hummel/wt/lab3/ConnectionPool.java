package com.github.hummel.wt.lab3;

import com.github.hummel.wt.lab3.exception.ConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {
	private static final String URL = "jdbc:mysql://localhost:3306/hummel_wt_02";
	private static final String LOGIN = "root";
	private static final String PASS = "amogus134";

	private static final int MAX_CONNECTION_COUNT = 10;
	private static final int MIN_CONNECTION_COUNT = 5;
	private static final Integer CURRENT_CONNECTION_NUMBER_LOCK = 0;
	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class);
	private static volatile ConnectionPool instance;
	private final BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(MAX_CONNECTION_COUNT, true);
	private volatile int currentConnectionNumber = MIN_CONNECTION_COUNT;

	@SuppressWarnings("CallToDriverManagerGetConnection")
	private ConnectionPool() {
		for (var i = 0; i < MIN_CONNECTION_COUNT; i++) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				pool.add(DriverManager.getConnection(URL, LOGIN, PASS));
			} catch (ClassNotFoundException | SQLException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	@SuppressWarnings("SynchronizeOnThis")
	public static ConnectionPool getInstance() {
		if (instance == null) {
			synchronized (ConnectionPool.class) {
				if (instance == null) {
					instance = new ConnectionPool();
				}
			}
		}
		return instance;
	}

	public void closeConnections() {
		for (var connection : pool) {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	public Connection getConnection() throws ConnectionException {
		try {
			if (pool.isEmpty() && currentConnectionNumber < MAX_CONNECTION_COUNT) {
				openAdditionalConnection();
			}
			return pool.take();
		} catch (ConnectionException | InterruptedException e) {
			LOGGER.error(e.getMessage());
			throw new ConnectionException(e.getMessage());
		}
	}

	@SuppressWarnings({"CallToDriverManagerGetConnection", "synchronization", "SynchronizationOnStaticField", "SynchronizedOnLiteralObject"})
	private void openAdditionalConnection() throws ConnectionException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			pool.add(DriverManager.getConnection(URL, LOGIN, PASS));
			synchronized (CURRENT_CONNECTION_NUMBER_LOCK) {
				currentConnectionNumber++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new ConnectionException("New connection wasn't added in the connection pool");
		}
	}

	@SuppressWarnings({"synchronization", "SynchronizationOnStaticField", "SynchronizedOnLiteralObject"})
	public void returnConnection(Connection connection) throws ConnectionException {
		if (connection != null) {
			if (currentConnectionNumber > MIN_CONNECTION_COUNT) {
				synchronized (CURRENT_CONNECTION_NUMBER_LOCK) {
					currentConnectionNumber--;
				}
			}
			try {
				pool.put(connection);
			} catch (InterruptedException e) {
				LOGGER.error("Connection wasn't successfully returned to the pool");
				throw new ConnectionException(e.getMessage());
			}
		}
	}
}