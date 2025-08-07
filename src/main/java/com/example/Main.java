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
      
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));

  
        Server server = new Server(port);

   
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

      
        context.addServlet(new ServletHolder(new HelloWorldServlet()), "/hello");

  
        server.start();
        server.join();
    }
}