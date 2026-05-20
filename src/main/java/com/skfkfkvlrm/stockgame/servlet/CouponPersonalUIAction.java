package com.skfkfkvlrm.stockgame.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.skfkfkvlrm.stockgame.dao.jdbc.CouponDAOJdbc;
import com.skfkfkvlrm.stockgame.vo.CouponPurchaseVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class CouponPersonalUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) 
			throws ServletException, IOException {
		String url="CouponPersonal.jsp";
		Map<String, Object> studentInfo = (Map<String, Object>) request.getSession().getAttribute("info");

		
		CouponDAOJdbc dao = new CouponDAOJdbc();
		List<CouponPurchaseVO> list = dao.getMyCouponList((String) studentInfo.get("studentId"));
		request.setAttribute("couponlist", list);

		
		
		return url;
	}

}
