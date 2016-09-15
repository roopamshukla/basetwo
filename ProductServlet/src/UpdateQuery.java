/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class UpdateQuery extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String []inputs=new String[100];
      /*  Cookie[] ck=request.getCookies();
        String pid=ck[0].getValue();
        System.out.print(pid);*/
     
      
      HttpSession ss =request.getSession(false);
        
      String pid=(String)ss.getAttribute("uname");
      
    
        String pname=request.getParameter("pname");
        String des=request.getParameter("des");
        String date=request.getParameter("date");
        int qty=Integer.parseInt(request.getParameter("qty"));
        int price=Integer.parseInt(request.getParameter("price"));
        System.out.print(pid+pname+des+date+qty+price);
        int count=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_info","root","godzilla");
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select * from product_details");
            while(rs.next())
            {
                count++;
            }
            String q="update product_details set sno=?, pname=?, des=?, date=?, qty=?, price=? where pid=?";
            PreparedStatement ps=c.prepareStatement(q);
            ps.setInt(1,count);
            ps.setString(2,pname);
            ps.setString(3,des);
            ps.setString(4,date);
            ps.setInt(5,qty);
            ps.setInt(6,price);
            ps.setString(7,pid);
            
            ps.executeUpdate();
            
              } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd=request.getRequestDispatcher("DisplayExisting");
        rd.forward(request,response);
    }
}
