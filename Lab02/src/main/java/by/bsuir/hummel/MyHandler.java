package by.bsuir.hummel;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

class MyHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange t) throws IOException {
		String response = "<html><body><form method='post' action='/clicked'>" + "<button type='submit'>Click me!</button></form></body></html>";
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes(StandardCharsets.UTF_8));
		os.close();
	}
}
