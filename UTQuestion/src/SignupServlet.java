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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author roopamshukla
 */
public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String uid[]=new String[100];
        int i=0;
       try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","godzilla");
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select * from user_form1");
            while(rs.next())
            {
              uid[i]=rs.getString(1);
              i++;
            }
           
              } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidationDBMS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ValidationDBMS.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int status=0;
        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        String cnt=request.getParameter("cnt");
        String email=request.getParameter("email");
        for(int m=0;m<i;m++)
        {
            if(uid[m].equalsIgnoreCase(uname))
            {
                status=1;
                break;
            }
            
        }
        
        if(status==1)
            {
           
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       pw.println("<html><body><center><h1>Sorry ID not available..<h1></center></body></html>");
       RequestDispatcher rd = request.getRequestDispatcher("/form.html");
       rd.include(request, response);
            }
          else {
         
              
         
              try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","godzilla");
            Statement s=c.createStatement();
            s.execute("insert into user_form1 values('"+uname+"','"+pwd+"','"+cnt+"','"+email+"')"); 
              } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidationDBMS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ValidationDBMS.class.getName()).log(Level.SEVERE, null, ex);
        }
              
            RequestDispatcher rd=request.getRequestDispatcher("SuccessServlet");
            rd.forward(request,response);
   }
    }
    }
