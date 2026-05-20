package com.skfkfkvlrm.stockgame.servlet;

import com.skfkfkvlrm.stockgame.dao.jdbc.MemberDAOJdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class IdCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request) 
			throws ServletException, IOException {
		String studentId=request.getParameter("studentId");
		boolean result=new MemberDAOJdbc().getIdCheck(studentId);
		request.setAttribute("result", result);
		return "IdJsonResult.jsp";
	}

}
