package com.skfkfkvlrm.stockgame.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class LoginUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) 
			throws ServletException, IOException {
		
		return "Login.jsp";
	}

}
