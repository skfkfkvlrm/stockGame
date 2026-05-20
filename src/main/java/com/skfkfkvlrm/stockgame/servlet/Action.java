package com.skfkfkvlrm.stockgame.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;



public interface Action{
	String execute(HttpServletRequest request) throws ServletException, IOException;
}