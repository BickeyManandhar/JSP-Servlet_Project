package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("Bickey") && password.equals("test@123")) {
			request.setAttribute("uname", username);
			request.setAttribute("pass", password);
			request.setAttribute("success", "Congrats!! You have successfully logged in.");
			request.getRequestDispatcher("congrats.jsp").forward(request, response);
		}
		else {
			request.setAttribute("unsuccess", "Sorry!! Your email or password is incorrect.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
