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
public class DisplayExisting extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pid[]=new String[100];
         String pname[]=new String[100];
         String des[]=new String[100];
         String date[]=new String[100];
         int qty[]=new int[100];
         int price[]=new int[100];
        int i=0;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_info","root","godzilla");
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select * from product_details");
            while(rs.next())
            {
              pid[i]=rs.getString(2);
             pname[i]=rs.getString(3);
             des[i]=rs.getString(4);
             date[i]=rs.getString(5);
              qty[i]=rs.getInt(6);
              price[i]=rs.getInt(7);
              
              i++;
            }
           
              } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisplayExisting.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayExisting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         String uname=request.getParameter("pid");
         Cookie[] ck=request.getCookies();
         int m=0;
        for(m=0;m<i;m++)
        {
            if(pid[m].equalsIgnoreCase(uname))
            {
                break;
            }
            
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
"                <div class=\"col-md-1\"></div>\n" +
"                <div class=\"col-md-6\">\n" +
"                    <h2 id=\"register\" >Product Information *Display*</h2>\n" +
"                    <form action=\"ProductServlet\" method=\"post\">\n" +
"                        <label class=\"control-label\">Product ID</label>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"pid\" value=\""+pid[m]+"\" disabled></input>\n" +
"                        <label class=\"control-label\">Product Name</label>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"pname\" value=\""+pname[m]+"\" disabled></input>\n" +
"                        <label class=\"control-label\">Description</label>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"des\" value=\""+des[m]+"\" disabled></input>\n" +
"                        <label class=\"control-label\">Date</label><tr><br>\n" +
"                        <input class=\"form-control\" type=\"date\" name=\"date\" value=\""+date[m]+"\" disabled></input>\n" +
"                        <label class=\"control-label\">Quantity</label><br>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"qty\" value=\""+qty[m]+"\" disabled></input>\n" +
"                        <label class=\"control-label\">Price</label><tr><br>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"price\" value=\""+price[m]+"\" disabled></input><br>\n" +
"                        <center><button class=\"btn btn-success\" formaction=\"check.html\" formnovalidate>Back</button></center>\n" +
"                    </form>\n" +
"                </div>\n" +
"                <div class=\"col-md-4\"><br>\n" +
"                    <img src=\"image.jpg\" height=\"430\" width=\"270\" />\n" +
"                </div>\n" +
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
