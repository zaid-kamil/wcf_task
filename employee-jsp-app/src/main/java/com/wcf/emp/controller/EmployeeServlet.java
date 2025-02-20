package com.wcf.emp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.wcf.emp.dao.EmployeeDao;
import com.wcf.emp.model.EmployeeModel;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeModel model = new EmployeeModel();
		model.setName(request.getParameter("name"));
		model.setEmail(request.getParameter("email"));
		model.setDept(request.getParameter("dept"));
		model.show();
		EmployeeDao dao = new EmployeeDao();
		try {
			dao.addEmployee(model);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
