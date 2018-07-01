package com.goodee.controller;

import com.goodee.controller.action.Action;
import com.goodee.controller.action.BoardCheckPassAction;
import com.goodee.controller.action.BoardCheckPassFormAction;
import com.goodee.controller.action.BoardDeleteAction;
import com.goodee.controller.action.BoardListAction;
import com.goodee.controller.action.BoardReplyAction;
import com.goodee.controller.action.BoardReplyFormAction;
import com.goodee.controller.action.BoardUpdateAction;
import com.goodee.controller.action.BoardViewAction;
import com.goodee.controller.action.BoardWriteAction;
import com.goodee.controller.action.BoardWriteFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {
		
	}
	
	public static ActionFactory getInstance() {
		if(instance == null) {
			return new ActionFactory();
		}
		return instance;
	}
	
	
	
	//command를 받아와 command에 대
	public Action getAction(String command) {
		Action action = null;
		System.out.println("action factory :" + command);
		if(command.equals("board_list")) {
			action = new BoardListAction();
		} 
		if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
			
		}
		if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}
		if(command.equals("board_view")) {
			action = new BoardViewAction();
		}
		if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		}
		if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		}
		if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		}
		if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}
		if(command.equals("board_reply_form")) {
			action = new BoardReplyFormAction();
		}
		if(command.equals("board_reply")) {
			action = new BoardReplyAction();
		}
		
		
		return action;
	}
}
