package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.model.UserManager;


@WebServlet("/Register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String upass=request.getParameter("pass");
		String ucont=request.getParameter("contact");
		
		User us=new User();
		us.setName(uname);
		us.setEmail(uemail);
		us.setPwd(upass);
		us.setNum(ucont);
	String st=null;
		UserManager um=new UserManager();
		try {
		st=um.insertData(us);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw=response.getWriter();
		pw.print(st);
		
		
		
		
		
	}

}
