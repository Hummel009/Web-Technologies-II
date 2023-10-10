package by.bsuir.hummel;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleJavaWebApp {
	public static void main(String[] args) throws IOException {
		int serverPort = 8080;
		HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
		server.createContext("/button", new MyHandler());
		server.setExecutor(null);
		server.start();

		System.out.println("Server started on port " + serverPort);
	}
}