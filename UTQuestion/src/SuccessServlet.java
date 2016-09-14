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
public class SuccessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uname[]=new String[100];
         String cnt[]=new String[100];
         String email[]=new String[100];
        int i=0;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","password");
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select * from user_form1");
            while(rs.next())
            {
              uname[i]=rs.getString(1);
             cnt[i]=rs.getString(3);
             email[i]=rs.getString(4);
              i++;
            }
           
              } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuccessServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SuccessServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
           
        response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
       pw.println("<!DOCTYPE>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Bootstrap Demo</title>\n" +
"\n" +
"        <link rel=\"stylesheet\" href=\"bootstrap-3.3.7-dist/css/bootstrap.min.css\">\n" +
"\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"container\">\n" +
"            <div class=\"row\">\n" +
"\n" +
"                <div class=\"col-md-2\"></div>\n" +
"                <div class=\"col-md-8\">\n" +
"                    <h2 id=\"register\" >Information Display</h2>\n<table width=100% border=2px class='table'><tr><td><b>Name</b></td><td><b>Country</b></td><td><b>E-Mail</b></td></tr>");
               for(int m=0;m<i;m++)
        {
            pw.println("<tr><td>"+uname[m]+"</td><td>"+cnt[m]+"</td><td>"+email[m]+"</td></tr>");
        }
pw.println("</table> </div>\n" +
"                <div class=\"col-md-2\"><br>\n</div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </div>\n" +
"\n" +
"    <script src=\"js/jquery.min.js\"></script>\n" +
"    <script src=\"bootstrap-3.3.7-dist/js/bootstrap.min.js\" ></script>\n" +
"\n" +
"</body>\n" +
"\n" +
"</html>\n" +
"");
    }


}
