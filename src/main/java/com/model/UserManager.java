package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
	String url="jdbc:mysql://localhost:3306/ruthwick";
	    String username="root";
	    String password="admin";
	    Connection con=null;
	    PreparedStatement ps=null;
	    List<User> al=new ArrayList<>();
	
		public String insertData(User u) throws SQLException {
		     con=DriverManager.getConnection(url,username,password);
		        ps=con.prepareStatement("insert into user values(?,?,?,?)");
		        ps.setString(1, u.getName());
		        ps.setString(2, u.getEmail());
		        ps.setString(3, u.getPwd());
		        ps.setString(4, u.getNum());  
		        ps.execute();    
		return "Insertion done successfully";
		
	}
		public List<User> getDetails() throws Exception{
	        con=DriverManager.getConnection(url,username,password);
	        String s="select * from user";
	        ps=con.prepareStatement(s);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()) {
	          User u=new User();
	          u.setName(rs.getString(1));
	          u.setPwd(rs.getString(3));
	          al.add(u); 
	        }
	        return al;
		}
	        

}
