package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Order;
import com.model.OrderManager;
import com.model.User;


@WebServlet("/OrderNowServlet")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            String name=request.getSession().getAttribute("username").toString();
            if (name != null) {
                String productId = request.getParameter("id");
                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
                if (productQuantity <= 0) {
                	productQuantity = 1;
                }
                
                Order orderModel = new Order();
                orderModel.setId(Integer.parseInt(productId));
                orderModel.setName(name);
                orderModel.setQunatity(productQuantity);
                orderModel.setDate(formatter.format(date));

                OrderManager orderDao = new OrderManager();
                boolean result = orderDao.insertOrder(orderModel);
                if (result) {
//                    ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
//                    if (cart_list != null) {
//                        for (Cart c : cart_list) {
//                            if (c.getId() == Integer.parseInt(productId)) {
//                                cart_list.remove(cart_list.indexOf(c));
//                                break;
//                            }
//                        }
//                    }
                    response.sendRedirect("orders.jsp");
                } else {
                    out.println("order failed");
                }
            } else {
                response.sendRedirect("login.jsp");
            }

        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
