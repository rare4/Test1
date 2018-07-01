package com.goodee.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.dao.BoardDAO;
import com.goodee.dto.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outputUrl = "index.jsp";
		String title = request.getParameter("title");
		String userId = request.getParameter("userId");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO(title,userId,content,password);
		boolean result = bDao.insertBoard(vo);
		
		//줄바꿈 처리를 위한 로직
		
		content.replace("\r\n", "<br>");
		vo.setContent(request.getParameter("content").replace("\r\n,","<br>").replace("&", "&amp;"));
		
		
		if(result == true) {
			//저장 잘 됨
			
			new BoardListAction().excute(request, response);
		}else {
			//저장 안됨
			
		}
		
	}

}
