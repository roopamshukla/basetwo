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

/**
 *
 * @author roopamshukla
 */
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String d=request.getParameter("uname");
       Cookie ck=new Cookie("username",d);
       response.addCookie(ck);
       PrintWriter pw = response.getWriter();
       pw.println("<html><head>\n" +
"		<title>Bootstrap Demo</title>\n" +
"			\n" +
"			<link rel=\"stylesheet\" href=\"bootstrap-3.3.7-dist/css/bootstrap.min.css\">\n" +
"			\n" +
"	</head><body> <form method=\"post\">\n"+"<br><br><center><button class=\"btn btn-success\" formaction=\"NextServlet\">GO!</button></center></body></html>");
    }

}
