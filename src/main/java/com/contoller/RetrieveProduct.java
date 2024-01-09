package com.contoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;



public class RetrieveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String url = "jdbc:mysql://localhost:3306/ruthwick";
	        String username = "root";
	        String password = "admin";
	        List<Product> pro = new ArrayList<>();

	        Connection con = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        try {
	            // Establish a database connection
	            con = DriverManager.getConnection(url, username, password);
	            stmt = con.createStatement();

	            // Retrieve data from the database table
	            String sql = "SELECT * FROM product";
	            rs = stmt.executeQuery(sql);

	            // Create a list to store the retrieved data
	            // Iterate over the result set and create Recruiter objects
	            while (rs.next()) {
	                Product obj=new Product();

	              
	                String name=rs.getString(2);
	                Blob imageBlob = rs.getBlob(3);
	                int price=rs.getInt(4);
	                String category=rs.getString(5);
	                
	                byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
	               
	                
	                obj.setName(name);
	                obj.setImage(imageBytes);
	                obj.setPrice(price);
	                
	                obj.setCategory(category);
	              
	                
	                pro.add(obj);
	            }
	            // Store the data in request attribute
	            request.setAttribute("list", pro);
	RequestDispatcher rd=request.getRequestDispatcher("table1.jsp");
	rd.forward(request, response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the database resources
	         System.out.println("Size of the list is"+pro.size());
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
