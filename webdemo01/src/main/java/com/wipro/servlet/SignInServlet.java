package com.wipro.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignInServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("--->"+email+" & "+password);
		if(email.equals(password)) {
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
