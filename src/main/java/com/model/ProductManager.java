package com.model;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class ProductManager {
	 String url = "jdbc:mysql://localhost:3306/ruthwick";
     String username = "root";
     String password = "admin";
     Connection con=null;
     PreparedStatement ps=null;
	public List<Product> getAllProducts() {
        List<Product> book = new ArrayList<>();
        try {
        	con=DriverManager.getConnection(url,username,password);
	        
	        

           String  query = "select * from product";
           ps=con.prepareStatement(query);
           ResultSet rs=ps.executeQuery();
           

            while (rs.next()) {
            	Product row = new Product();
            	Blob imageBlob = rs.getBlob(3);
            	 byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
            	row.setId(rs.getInt(1));
                row.setName(rs.getString(2));
                row.setCategory(rs.getString(5));
                row.setPrice(rs.getInt(4));
                row.setImage(imageBytes);

                book.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
	public int getTotalCartPrice(ArrayList<Cart> cartList) {
        int sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                	con=DriverManager.getConnection(url,username,password);
                   String query = "select proprice from product where idproduct=?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, item.getId());
                    
                  ResultSet  rs = ps.executeQuery();
                    while (rs.next()) {
                    	 int price=rs.getInt("proprice");
                        sum+=rs.getInt("proprice")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }

    
    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                   con=DriverManager.getConnection(url,username,password);
                   String query = "select * from product where idproduct=?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, item.getId());
                   ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt(1));
                        row.setName(rs.getString(2));
                        row.setCategory(rs.getString(5));
                        row.setPrice(rs.getInt(4)*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }

	

}
