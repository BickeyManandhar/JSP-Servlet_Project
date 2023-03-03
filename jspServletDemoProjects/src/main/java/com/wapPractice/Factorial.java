package com.wapPractice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Factorial")
public class Factorial extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputValueInString = request.getParameter("inputValue"); //since we are getting value from the URL in string we need to parse this value in Integer
		int inputValueInInteger = Integer.parseInt(inputValueInString); 
		int factorial =1;
		for(int i =1; i<=inputValueInInteger; i++) {
			factorial = factorial*i;
		}
		//System.out.println("Factorial is: "+ factorial);
		request.setAttribute("inputValue", inputValueInInteger); //(sending_value_name, sending_value)
		request.setAttribute("sendingValue", factorial); //(sending_value_name, sending_value)
		request.getRequestDispatcher("FactorialResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
