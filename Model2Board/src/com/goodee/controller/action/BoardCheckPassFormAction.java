package com.goodee.controller.action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class BoardCheckPassFormAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String url = "board/boardCheckPass.jsp";
		String num = request.getParameter("num");
		request.setAttribute("num", num);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}
