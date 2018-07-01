package com.goodee.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.goodee.dao.BoardDAO;
import com.goodee.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String num = request.getParameter("num");
		String outputUrl = "board/checkSuccess.jsp";
		String outputUrl1 = "index,jsp";
		String password = request.getParameter("password");
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO vv = bDao.checkPassword(num, password);
		
		if(vv != null) {
		
		
		request.setAttribute("board", vv);
		
		RequestDispatcher rd = request.getRequestDispatcher(outputUrl);
		rd.forward(request, response);
		}else {
			pw.println("<script>");
			pw.println("alert('password')");
			pw.println("location.href('list.do?command=board_check_pass_form&num=" + num + "')");
			pw.println("</script>");
		}
	}

}
