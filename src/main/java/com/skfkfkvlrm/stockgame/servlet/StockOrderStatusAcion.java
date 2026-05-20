package com.skfkfkvlrm.stockgame.servlet;

import com.google.gson.Gson;
import com.skfkfkvlrm.stockgame.dao.StockDetailDAOInterface;
import com.skfkfkvlrm.stockgame.dao.mybatis.StockDetailDAOMybatis;
import com.skfkfkvlrm.stockgame.vo.OrderVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class StockOrderStatusAcion implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String studentId = (String) session.getAttribute("studentId");
		//세션 체크
		if(studentId == null){
			return "controller?cmd=LoginUI";
		}
		
		StockDetailDAOInterface stockDetailDAO = new StockDetailDAOMybatis();
		List<OrderVO> list = null;
		
		int stockNo = Integer.parseInt(request.getParameter("stockNo"));
		if(request.getParameter("type").equals("sell")){
			list = stockDetailDAO.getTotalSellOrder(stockNo);
		}else{
			list = stockDetailDAO.getTotalBuyOrder(stockNo);
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		request.setAttribute("jsonData", json);
		return null;
	}

}
