package com.skfkfkvlrm.stockgame.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("/controller")
public class FrontControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String path = ActionFactory.getAction(request.getParameter("cmd")).execute(request);
		
		if(path == null){
			String jsonData = (String) request.getAttribute("jsonData");
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(jsonData);
		}else if(path.contains("controller?cmd=")) {
            // 다른 액션으로 넘겨야 할 때 (로그인 성공 시 등)
            response.sendRedirect(path);
        }else
			request.getRequestDispatcher("/view/" + path).forward(request, response);
	}
	
}