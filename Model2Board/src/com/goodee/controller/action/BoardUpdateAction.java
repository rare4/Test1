package com.goodee.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.dao.BoardDAO;
import com.goodee.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDAO dd = BoardDAO.getInstance();
		BoardVO vv = new BoardVO(num,title,content);
		
		dd.updateBoard(vv);
		String url = "list.do?command=board_list";
		
		PrintWriter pw = response.getWriter();
		pw.println("<script>");
		pw.println("alert('수정이 완료되었습니다.')");
		pw.println("location.href('list.do?command=board_list')");
		pw.println("</script>");
	}

}
