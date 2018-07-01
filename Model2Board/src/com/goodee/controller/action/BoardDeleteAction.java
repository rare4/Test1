package com.goodee.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.dao.BoardDAO;
import com.goodee.dto.BoardVO;

public class BoardDeleteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dd = BoardDAO.getInstance();
		BoardVO vv = new BoardVO(num);
		
		dd.deleteBoard(num);
		String url = "list.do?command=board_list";
		
		PrintWriter pw = response.getWriter();
		pw.println("<script>");
		pw.println("alert('삭제가 완료되었습니다.')");
		pw.println("location.href('list.do?command=board_list')");
		pw.println("</script>");
	}

}
