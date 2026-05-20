package com.skfkfkvlrm.stockgame.servlet;

import java.io.IOException;
import java.util.List;

import com.skfkfkvlrm.stockgame.dao.jdbc.CouponDAOJdbc;
import com.skfkfkvlrm.stockgame.vo.CouponVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class CouponMarketUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		CouponDAOJdbc dao = new CouponDAOJdbc();
		List<CouponVO> list = dao.getCouponList();
		
		request.setAttribute("couponList", list);
		
		return "CouponMarket.jsp";
	}

}
