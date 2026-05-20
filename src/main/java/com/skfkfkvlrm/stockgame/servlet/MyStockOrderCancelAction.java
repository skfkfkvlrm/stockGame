package com.skfkfkvlrm.stockgame.servlet;

import com.skfkfkvlrm.stockgame.dao.jdbc.StockDetailDAOJdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

public class MyStockOrderCancelAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		StockDetailDAOJdbc stockDetailDAO = new StockDetailDAOJdbc();
		HttpSession session = request.getSession();
		Map<String, Object> studentInfo = (Map<String, Object>) session.getAttribute("info");
		
		
		String studentId = (String) session.getAttribute("studentId");
		
		//세션 체크
		if(studentId == null){
			return "controller?cmd=LoginUI";
		}
		
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		int stockNo = Integer.parseInt(request.getParameter("stockNo"));
		
		stockDetailDAO.setOrderStateCancel(orderNo);
		
		return "controller?cmd=StockDetailUI&no=" + stockNo;
	}

}
