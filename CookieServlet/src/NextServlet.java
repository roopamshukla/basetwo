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
public class NextServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] ck=request.getCookies();
         PrintWriter pw=response.getWriter();
        pw.println("<html><body><center><h1>Cookie ID : "
                +ck[0]+"</h1><br><h1>User Name : "
                +ck[0].getValue()+"</h1><br><h1>Cookie Name : "
                +ck[0].getName()+"</h1></center></body></html>");
    }

   
}
