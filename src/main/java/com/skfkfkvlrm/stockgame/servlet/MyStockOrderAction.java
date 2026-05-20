package com.skfkfkvlrm.stockgame.servlet;

import com.google.gson.Gson;
import com.skfkfkvlrm.stockgame.dao.jdbc.StockDetailDAOJdbc;
import com.skfkfkvlrm.stockgame.vo.OrderVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class MyStockOrderAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int stockNo = Integer.parseInt(request.getParameter("no"));
		String studentId = (String) session.getAttribute("studentId");
		
		StockDetailDAOJdbc stockDetailDAO = new StockDetailDAOJdbc();
	
		List<OrderVO> list = stockDetailDAO.getTotalMyOrder(stockNo, studentId);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
	
		request.setAttribute("jsonData", json);
		
		return null;
	}

}
