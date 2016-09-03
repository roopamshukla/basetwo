/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author roopamshukla
 */
public class ValidatePID extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String pid[]=new String[100];
         
        int i=0;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_info","root","password");
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select * from product_details");
            while(rs.next())
            {
              pid[i]=rs.getString(2);
              i++;
            }
           
              } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidatePID.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ValidatePID.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         int status=0;
        String uname=request.getParameter("pid");
        for(int m=0;m<i;m++)
        {
            if(pid[m].equalsIgnoreCase(uname))
            {
                status=1;
                break;
            }
            
        }
        
        if(status==1)
            {
                
             //   Cookie ck=new Cookie("uname",uname);
             //   request.addCookie(ck);
           RequestDispatcher rd=request.getRequestDispatcher("DisplayExisting");
           rd.forward(request,response);
            }
          else {
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       RequestDispatcher rd = request.getRequestDispatcher("InputServlet");
       rd.include(request, response);
   }
    }
    }

