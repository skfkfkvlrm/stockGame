package com.skfkfkvlrm.stockgame.servlet;

import com.skfkfkvlrm.stockgame.dao.jdbc.NewsDAOJdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class NewsUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		NewsDAOJdbc dao = new NewsDAOJdbc();
		request.setAttribute("newsList", dao.getNewsList());
		return "NewsList.jsp";
	}

}
