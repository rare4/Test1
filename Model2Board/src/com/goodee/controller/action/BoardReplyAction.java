package com.goodee.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.dao.BoardDAO;
import com.goodee.dto.BoardVO;

public class BoardReplyAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "list.do?command=board_list";
		String title = request.getParameter("title");
		String userId = request.getParameter("userId");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		int num1 = Integer.parseInt(request.getParameter("num"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		int step = Integer.parseInt(request.getParameter("step"));
		int reforder = Integer.parseInt(request.getParameter("reforder"));
		int replycount = Integer.parseInt(request.getParameter("replycount"));
		if(num1 == ref) {
			step = step + 1;
			reforder = replycount + 1;
		}else {
			step = step + 1;
		}
		
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO(title,userId,content,password,ref,step,reforder);
	
		content.replace("\r\n", "<br>");
		vo.setContent(content.replace("\r\n,","<br>").replace("&", "&amp;"));
		
		bDao.replyInsert(vo);
		bDao.countup(num1);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
