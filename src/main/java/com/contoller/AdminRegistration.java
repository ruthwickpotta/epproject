package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Admin;
import com.model.AdminManager;
import com.model.User;
import com.model.UserManager;

/**
 * Servlet implementation class AdminRegistration
 */
@WebServlet("/AdminRegistration")
public class AdminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String ucont=request.getParameter("contact");
		String upass=request.getParameter("pass");
		
		
		Admin a=new Admin();
		a.setAname(uname);
		a.setAemail(uemail);
		a.setAnum(ucont);
		a.setApass(upass);
		
	String st=null;
	AdminManager am=new AdminManager();
		try {
		st=am.insertData(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw=response.getWriter();
		pw.print(st);
		
		
		
		
		
	}
}


