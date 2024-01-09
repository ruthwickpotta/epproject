package com.contoller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/Storeproduct")
@MultipartConfig
public class Storeproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String url = "jdbc:mysql://localhost:3306/ruthwick";
	        String username = "root";
	        String password = "admin";
	        Connection con = null;
	        Statement st=null;
	        PreparedStatement ps = null;
		
		
		int id=1;
		String name=request.getParameter("proname");
		Part image = request.getPart("prophoto");
		int price=Integer.parseInt(request.getParameter("proprice"));
		String category=request.getParameter("category");
		   try {
			    
	            con = DriverManager.getConnection(url, username, password);
	            st=con.createStatement();
	            ps = con.prepareStatement("INSERT INTO product VALUES(?,?,?,?,?);");
	            ResultSet rs=st.executeQuery("select max(idproduct) from product");
	            while(rs.next()) {
	            	id=rs.getInt(1);
	            	id=id+1;
	            }
	            ps.setInt(1, id);
	            ps.setString(2, name);
	            Blob imageBlob = con.createBlob();
	            InputStream inputStream = image.getInputStream();
	            try (InputStream inStream = image.getInputStream()) {
	                byte[] buffer = new byte[1000000];
	                int bytesRead;
	                while ((bytesRead = inStream.read(buffer)) != -1) {
	                    imageBlob.setBytes(1, buffer, 0, bytesRead);
	                }
	            }
	           
	            ps.setInt(4, price);
	           
	            ps.setBlob(3, imageBlob);
	            ps.setString(5,category);

	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (ps != null) {
	                    ps.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        response.sendRedirect("aindex.jsp");
	    }

}
