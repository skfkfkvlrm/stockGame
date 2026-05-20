package com.skfkfkvlrm.stockgame.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if(session !=null){
//			session.removeAttribute("loginOK"); //1
			session.invalidate();//2
		}		
		return "index.jsp";
	}

}
