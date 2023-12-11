package com.welcome;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Welcome {

	public static void main(String[] args) throws IOException {
		 HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

	        // Create a context for the "/welcome" path
	        server.createContext("/welcome", new WelcomeHandler());

	        // Start the server
	        server.start();

	        System.out.println("Server started on port 8080");
	    }

	    // HTTP handler for the "/welcome" path
	    static class WelcomeHandler implements HttpHandler {
	        public void handle(HttpExchange exchange) throws IOException {
	            // Send "Welcome to the page" as the response
	            String response = "Welcome to the page";
	            exchange.sendResponseHeaders(200, response.length());
	            OutputStream os = exchange.getResponseBody();
	            os.write(response.getBytes());
	            os.close();
	        }

	}

}
