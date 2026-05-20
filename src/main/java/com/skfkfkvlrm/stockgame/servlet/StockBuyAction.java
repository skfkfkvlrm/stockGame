package com.skfkfkvlrm.stockgame.servlet;

import com.skfkfkvlrm.stockgame.dao.StockDetailDAOInterface;
import com.skfkfkvlrm.stockgame.dao.mybatis.StockDetailDAOMybatis;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

public class StockBuyAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
			StockDetailDAOInterface stockDetailDAO = new StockDetailDAOMybatis();
			HttpSession session = request.getSession();
			Map<String, Object> studentInfo = (Map<String, Object>) session.getAttribute("info");
			
			
			String studentId = (String) session.getAttribute("studentId");
			
			//세션 체크
			if(studentId == null){
				return "controller?cmd=LoginUI";
			}
			
			int buyPrice = Integer.parseInt(request.getParameter("buyPrice"));
			int buyAmount = Integer.parseInt(request.getParameter("buyAmount"));
			int stockNo = Integer.parseInt(request.getParameter("stockNo"));
			
			session.setAttribute("info", studentInfo);
			session.setAttribute("Message", stockDetailDAO.setBuyOrder(studentId, buyPrice, buyAmount, stockNo));
			
			studentInfo.put("totalPoint", stockDetailDAO.getStudentPoint(studentId));
			session.setAttribute("info", studentInfo);
			
		return "controller?cmd=StockDetailUI&no=" + stockNo;
	}

}
