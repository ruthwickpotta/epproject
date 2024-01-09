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

import com.model.User;
import com.model.UserManager;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count=0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session=request.getSession();
			response.setContentType("text/html");
			String uname=request.getParameter("username");
			String pwd=request.getParameter("password");
		    UserManager obj=new UserManager();
		    List<User> l = null;
		    try {
		      l=obj.getDetails();
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    boolean val=false;
		    
		    for(int i=0;i<l.size();i++)
		    {
		      if(uname.equals(l.get(i).getName())&&pwd.equals(l.get(i).getPwd()))
		      {
		        val=true;count++;
		        session.setAttribute("username", l.get(i).getName());
		        session.setAttribute("count", count);
		        break;
		      }
		    }
//		    String contextPath = request.getContextPath();
//		    System.out.println(contextPath);
//		      String pagePath = contextPath + "/index.html";  
//		      String pagePath1 = contextPath + "src/main/webapp/index.html";
		    if(val)
		    {
//		        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
//		        dispatcher.forward(request, response);
		      response.sendRedirect("index.jsp");
//		      PrintWriter pw=response.getWriter();
//		      pw.print("valid login");
		      }
		    else {
//		      RequestDispatcher rd=request.getRequestDispatcher("NewFile.html");
//		      rd.forward(request, response);
		      PrintWriter pw=response.getWriter();
		      pw.print("Hi");
//		      PrintWriter pw=response.getWriter();
//		      pw.print("invalid login");
		    }
		    
		    
		  }

	}


