package org.cditest;
 
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.openshift.data.DBConnection;
 
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    @Inject private HelloWorld hello;
    @Inject private DBConnection dbj;
       
    public HelloServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        //response.getOutputStream().println("<html><h1>" + hello.getGreeting() + "</h1></html>");
    	response.getOutputStream().println("<html><h1>" + dbj.getMessage() + "</h1></html>");
    }
}
