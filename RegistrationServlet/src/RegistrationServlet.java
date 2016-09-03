/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegistrationServlet extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        String name=request.getParameter("fname");
        String address=request.getParameter("add");
        int age=Integer.parseInt(request.getParameter("age"));
        String gen=request.getParameter("gender");
        String year=request.getParameter("year");
        pw.println("<html><body><center><h1>Student Information<h1><h2>Name : "+name+"</h2><br><h2>Address : "+address+"</h2><br><h2>Age : "+age+"</h2><br><h2>Gender : "+gen+"</h2><br><h2>Year : "+year+"</h2></center></body></html>");
    }
}
