/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author roopamshukla
 */
public class InputServlet extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String uname=request.getParameter("pid");
        String u=uname;
       // Cookie ck=new Cookie("uname",uname);
       // response.addCookie(ck);
       HttpSession s= request.getSession(true);
       s.setAttribute("uname", u);
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
"                    <h2 id=\"register\" >Enter Product Information</h2>\n" +
"                    <form method=\"post\">\n" +
"                        <label class=\"control-label\">Product ID</label>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"pid\" value=\""+uname+"\" disabled></input>\n" +
"                        <label class=\"control-label\">Product Name</label>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"pname\" required></input>\n" +
"                        <label class=\"control-label\">Description</label>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"des\" required></input>\n" +
"                        <label class=\"control-label\">Date</label><tr><br>\n" +
"                        <input class=\"form-control\" type=\"date\" name=\"date\" required></input>\n" +
"                        <label class=\"control-label\">Quantity</label><br>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"qty\" required></input>\n" +
"                        <label class=\"control-label\">Price</label><tr><br>\n" +
"                        <input class=\"form-control\" type=\"text\" name=\"price\" required></input><br>\n" +
               "<input type='hidden' name='uname' value='"+u+"'/>" +
"                        <center><button class=\"btn btn-primary\" formaction=\"ProductServlet\">Submit</button>\n" +
"                        <button class=\"btn btn-danger\" formaction=\"check.html\" formnovalidate>Cancel</button></center>\n" +
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
