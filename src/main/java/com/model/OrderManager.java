package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderManager {
	String url = "jdbc:mysql://localhost:3306/ruthwick";
    String username = "root";
    String password = "admin";
    Connection con=null;
    PreparedStatement ps=null;
    Statement st=null;
    public boolean insertOrder(Order model) throws SQLException {
        boolean result = false;
        con=DriverManager.getConnection(url,username,password);
        st=con.createStatement();
        int id=0;
        String query = "insert into order values(?,?,?,?,?)";
        try {
        	 ResultSet rs=st.executeQuery("select max(idorder) from order");
	            while(rs.next()) {
	            	id=rs.getInt(1);
	            	id=id+1;
	            }
        	
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, model.getId());
            ps.setString(3, model.getName());
            ps.setString(4,model.getDate());
            ps.setInt(5,model.getQunatity());
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


}
