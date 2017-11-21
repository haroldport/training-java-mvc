package com.arquitecturajava.ejemplo001;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet002")
public class Servlet002 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<p>texto texto texto</p>");
		
		pw.println("<p>" + request.getAttribute("nombre") + "</p>");
		
		pw.println("<p>texto texto texto</p>");
		pw.close();
	}

}
