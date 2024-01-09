package com.contoller;

//LoginCounterServlet.java
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

@WebServlet("/LoginCounterServlet")
public class LoginCounterServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 private static final String LOGIN_COUNT_SESSION_KEY = "loginCount";
 private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

 private HashMap<String, Integer> loginCounts;

 public void init() {
     loginCounts = new HashMap<>();
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String username = request.getParameter("username");
     String password = request.getParameter("password");

     // Here, you would typically validate the login credentials.
     // For this example, let's assume the login is successful.

     HttpSession session = request.getSession(true);
     String dateKey = getDateKey();

     int loginCount = loginCounts.getOrDefault(dateKey, 0);
     loginCounts.put(dateKey, loginCount + 1);
     session.setAttribute(LOGIN_COUNT_SESSION_KEY, loginCount + 1);

     // Update total login count and store it in the application scope
     ServletContext application = getServletContext();
     int totalLogins = (int) application.getAttribute("totalLogins");
     application.setAttribute("totalLogins", totalLogins + 1);

     response.sendRedirect("index.jsp");
 }

 private String getDateKey() {
     // Use this method to get a unique key for each day,
     // so we can store and retrieve login counts for each day.
     // The dateKey will be consistent for the entire day.
     Date now = new Date();
     return DATE_FORMAT.format(now);
 }
}
