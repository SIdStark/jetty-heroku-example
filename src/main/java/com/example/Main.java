/**
 * 
 */
package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * @author Sid
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // Use the port assigned by Heroku or default to 8080
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));

        // Create a new Jetty server instance
        Server server = new Server(port);

        // Set up the context handler for servlets
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Add our HelloWorldServlet to the context, mapping it to the "/hello" path
        context.addServlet(new ServletHolder(new HelloWorldServlet()), "/hello");

        // Start the server and join the thread to keep it running
        server.start();
        server.join();
    }
}