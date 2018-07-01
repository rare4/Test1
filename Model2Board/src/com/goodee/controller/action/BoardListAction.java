package com.goodee.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.dao.BoardDAO;
import com.goodee.dto.BoardVO;

public class BoardListAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outputUrl = "board/boardList.jsp";
		
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardVO> list = bDao.selectAllBoard();
		request.setAttribute("boardList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher(outputUrl);
		rd.forward(request, response);
	}

}
