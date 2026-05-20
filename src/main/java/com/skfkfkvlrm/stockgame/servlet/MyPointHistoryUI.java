package com.skfkfkvlrm.stockgame.servlet;

import com.skfkfkvlrm.stockgame.dao.jdbc.MyPointHistoryDAOJdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MyPointHistoryUI implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
			MyPointHistoryDAOJdbc dao = new MyPointHistoryDAOJdbc();
			HttpSession session = request.getSession();

	        String studentId = (String) session.getAttribute("studentId");

	        if (studentId == null) {
	            studentId = "abc";
	        }
	        List<Map<String, Object>> historyList = dao.getMyPointHistoryList(studentId);
		
	        request.setAttribute("historyList", historyList);
	        
		return "MyPointHistory.jsp";
	}

}


