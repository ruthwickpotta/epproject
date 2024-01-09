package com.contoller;

// LoginContextListener.java
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
public class LoginContextListener implements ServletContextListener  {
	private static final long serialVersionUID = 1L;
	public void contextInitialized(ServletContextEvent event) {
        // Initialize totalLogins attribute to 0
        ServletContext context = event.getServletContext();
        context.setAttribute("totalLogins", 0);
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Cleanup code, if needed.
    }
}