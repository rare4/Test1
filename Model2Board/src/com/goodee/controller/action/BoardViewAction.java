package com.goodee.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.dao.BoardDAO;
import com.goodee.dto.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//REQUEST에 있는 num을 dao에 selectoneboard로 호출하고 받아온 boardvo를 boardview.jsp에 출력
		String num = request.getParameter("num");
		BoardDAO bb = BoardDAO.getInstance();
		BoardVO VV = bb.selectOneBoard(num);
			List<BoardVO> list = new ArrayList<BoardVO>();
			list = bb.selectReply(Integer.parseInt(num));
			
		if(VV != null) {
		bb.readCountUp(num);
		}
		request.setAttribute("board", VV);
		request.setAttribute("list", list);
		
		System.out.println(VV.getContent());
		System.out.println(list.toString());
		RequestDispatcher rd = request.getRequestDispatcher("board/boardView.jsp");
		rd.forward(request, response);
	}

}
