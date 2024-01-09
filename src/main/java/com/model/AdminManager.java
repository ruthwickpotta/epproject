package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminManager {
	String url="jdbc:mysql://localhost:3306/ruthwick";
    String username="root";
    String password="admin";
    Connection con=null;
    PreparedStatement ps=null;
    List<Admin> al=new ArrayList<>();
    public String insertData(Admin a) throws SQLException {
	     con=DriverManager.getConnection(url,username,password);
	        ps=con.prepareStatement("insert into admin values(?,?,?,?)");
	        ps.setString(1, a.getAname());
	        ps.setString(2, a.getAemail());
	        ps.setString(3, a.getAnum());  
	        ps.setString(4, a.getApass());
	      
	        ps.execute();    
	return "Insertion done successfully";
	
}
    public List<Admin> getDetails() throws Exception{
        con=DriverManager.getConnection(url,username,password);
        String s="select * from admin";
        ps=con.prepareStatement(s);
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
          Admin a=new Admin();
          a.setAemail(rs.getString(2));
          a.setApass(rs.getString(4));
          al.add(a); 
        }
        return al;
    }

}
