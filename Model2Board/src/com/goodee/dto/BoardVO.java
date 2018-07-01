package com.goodee.dto;

import java.sql.Timestamp;

public class BoardVO {
	private int num;
	private String title;
	private String userId;
	private Timestamp postDate;
	private String content;
	private int readCount;
	private String password;
	private int ref;
	private int step;
	private int reforder;
	private int replycount;
	
	
	public int getReplycount() {
		return replycount;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	public BoardVO(String title, String userId, String content, String password, int ref, int step, int reforder) {
		
		this.title = title;
		this.userId = userId;
		this.content = content;
		this.password = password;
		this.ref = ref;
		this.step = step;
		this.reforder = reforder;
	}

	public BoardVO(String title, String userId, String content, String password, int ref) {
	
		this.title = title;
		this.userId = userId;
		this.content = content;
		this.password = password;
		this.ref = ref;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getReforder() {
		return reforder;
	}

	public void setReforder(int reforder) {
		this.reforder = reforder;
	}

	public BoardVO(int num, String title, String userId, Timestamp postDate, String content, int readCount,
			String password, int ref, int step, int reforder,int replycount) {
	
		this.num = num;
		this.title = title;
		this.userId = userId;
		this.postDate = postDate;
		this.content = content;
		this.readCount = readCount;
		this.password = password;
		this.ref = ref;
		this.step = step;
		this.reforder = reforder;
		this.replycount = replycount;
	}

	public BoardVO() {
		
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public BoardVO(int num, String title, String content) {
		
		this.num = num;
		this.title = title;
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BoardVO(String title, String userId, String content, String password) {
		
		this.title = title;
		this.userId = userId;
		this.content = content;
		this.password = password;
	}

	public BoardVO(int num, String title, String userId, Timestamp postDate, String content, int readCount,
			String password) {
	
		this.num = num;
		this.title = title;
		this.userId = userId;
		this.postDate = postDate;
		this.content = content;
		this.readCount = readCount;
		this.password = password;
	}
	
	public BoardVO(int num, String title, String userId, Timestamp postDate, int readCount) {
	
		this.num = num;
		this.title = title;
		this.userId = userId;
		this.postDate = postDate;

		this.readCount = readCount;

	}
	
	
	public BoardVO(int num) {
		this.num = num;
	}
}
