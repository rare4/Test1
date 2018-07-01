package com.goodee.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.dao.BoardDAO;
import com.goodee.dto.BoardVO;
import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxManagement
 */
@WebServlet("/AjaxManagement")
public class AjaxManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("ajax에서 호출 성공");
		  System.out.println(request.getParameter("boardnum"));
		  System.out.println(request.getParameter("userid"));
		  System.out.println(request.getParameter("content"));
		  
		   
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		String userId = request.getParameter("userid");
		String content = request.getParameter("content");
	 
	 
	   List<BoardVO> list = new ArrayList<BoardVO>();
		BoardDAO dao = BoardDAO.getInstance();
		dao.addReply(boardnum, userId, content);
	
		list = dao.selectReply(boardnum);
		//컬렉션에 있는 데이터를 꺼내면서 xml,json으로 바꿔서 출력
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter w = response.getWriter();
	      Gson gson = new Gson();
	  	
		String json = gson.toJson(list);
	      w.println(json);
	
		
	      w.flush();
	      w.close();
	}

}
