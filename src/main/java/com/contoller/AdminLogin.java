package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Admin;
import com.model.AdminManager;
import com.model.User;
import com.model.UserManager;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		String aemail=request.getParameter("adminemail");
		String pwd=request.getParameter("password");
	    AdminManager obj=new AdminManager();
	    List<Admin> l = null;
	    try {
	      l=obj.getDetails();
	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    boolean val=false;
	    for(int i=0;i<l.size();i++)
	    {
	      if(aemail.equals(l.get(i).getAemail())&&pwd.equals(l.get(i).getApass()))
	      {
	        val=true;
	        session.setAttribute("adminemail", l.get(i).getAemail());
	        break;
	      }
	    }
//	    String contextPath = request.getContextPath();
//	    System.out.println(contextPath);
//	      String pagePath = contextPath + "/index.html";  
//	      String pagePath1 = contextPath + "src/main/webapp/index.html";
	    if(val)
	    {
//	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
//	        dispatcher.forward(request, response);
	      response.sendRedirect("aindex.jsp");
//	      PrintWriter pw=response.getWriter();
//	      pw.print("valid login");
	      }
	    else {
//	      RequestDispatcher rd=request.getRequestDispatcher("NewFile.html");
//	      rd.forward(request, response);
	      PrintWriter pw=response.getWriter();
	      pw.print("Hi");
//	      PrintWriter pw=response.getWriter();
//	      pw.print("invalid login");
	    }
	    
	    
	  }

}
