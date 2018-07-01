package com.goodee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goodee.dto.BoardVO;

import util.DBManagement;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
			
		}
		
		return instance;
	}
	
	// 전체 글 리스트 목록 페이지를 위한 메소드
	// select num, title,userid,postdate,readcount from boardtable order by num desc
	
	public List<BoardVO> selectAllBoard(){
		String query = "select * from board.boardtable order by ref desc, reforder asc;";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = util.DBManagement.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardVO(
						rs.getInt("num"),
						rs.getString("title"),
						rs.getString("userId"),
						rs.getTimestamp("postdate"),
						rs.getString("content"),
						rs.getInt("readcount"),
						rs.getString("password"),
						rs.getInt("ref"),
						rs.getInt("step"),
						rs.getInt("reforder"),
						rs.getInt("replycount")
						));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
		DBManagement.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	public int getmaxnum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query1 = "select max(num) as num from boardtable";
		int result = 0;
		try {
		con = util.DBManagement.getConnection();
		pstmt = con.prepareStatement(query1);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			result = rs.getInt("num");
		}
		
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManagement.close(pstmt, con);
		}
		
		return result;
		
	}
	
	
	//게시 글 저장 메소드
	//insert into boardtable(title,userid,content,password) values('안녕','안녕1','안녕2','4444')
	public boolean insertBoard(BoardVO bvo) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int ref = getmaxnum() + 1;
		System.out.println(ref);
		String query = "insert into board.boardtable(title,userId,content,password,ref) values(?,?,?,?,?)";
		try {
		con = util.DBManagement.getConnection();
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, bvo.getTitle());
		pstmt.setString(2, bvo.getUserId());
		pstmt.setString(3, bvo.getContent());
		pstmt.setString(4, bvo.getPassword());
		pstmt.setInt(5, ref);
		
		if(pstmt.executeUpdate() == 1) {
			result = true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManagement.close(pstmt, con);
		}
		
		return result;
		
	}
	
	//게시글 조회하는  메소드
	//select num, title, userid, postdate, readcount from boardtable order by num desc;
	public BoardVO selectOneBoard(String num) {
		BoardVO vv = new BoardVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from board.boardtable where num=?";
		try {
		con = util.DBManagement.getConnection();
		
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, num);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			vv.setNum(rs.getInt("num"));
			vv.setTitle(rs.getString("title"));
			vv.setUserId(rs.getString("userId"));
			vv.setPostDate(rs.getTimestamp("postdate"));
			vv.setContent(rs.getString("content"));
			vv.setReadCount(rs.getInt("readcount"));
			vv.setPassword(rs.getString("password"));
			vv.setRef(rs.getInt("ref"));
			vv.setStep(rs.getInt("step"));
			vv.setReforder(rs.getInt("reforder"));
			vv.setReplycount(rs.getInt("replycount"));
		
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManagement.close(pstmt, con);
		}
		
		return vv;
	}
	
	
	//-----------조회수 증가 메소드
	public void readCountUp(String num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		String query = "update board.boardtable set readcount=readcount+1 where num=?";
		try {
			con = util.DBManagement.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBManagement.close(pstmt, con);
			}
	}
	
	//---------------게시글 수정/삭제시 필요한 암호체크 메소드
	//인자:글번호, 유저가 입력한 패스워드
	//반환값; 글번호와 패스워드가 같으면 글을 반환,아니면 널인 boardvo반환
	//select * from boardtable where num=3 && password="404";
	public BoardVO checkPassword(String num, String userPassword) {
		String query = "select * from board.boardtable where num=? && password=?";
		
		BoardVO bvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = util.DBManagement.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			pstmt.setString(2, userPassword);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bvo = new BoardVO(
						rs.getInt("num"),
						rs.getString("title"),
						rs.getString("userId"),
						rs.getTimestamp("postdate"),
						rs.getString("content"),
						rs.getInt("readcount"),
						rs.getString("password")
						);
			}
			
			System.out.println(bvo);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBManagement.close(pstmt, con);
			}
		return bvo;
	}
	
	
	//--------------글 수정 메소드
	//
	
	public void updateBoard(BoardVO bvo) {
		String query = "update board.boardtable set content = ?, title = ? where num= ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = util.DBManagement.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bvo.getContent());
			pstmt.setString(2, bvo.getTitle());
			pstmt.setInt(3, bvo.getNum());
			pstmt.executeUpdate();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBManagement.close(rs, pstmt, con);
			}
	}

	
	//-----------------글 삭제 메소드
	
	public void deleteBoard(int num) {
		String query = "delete from board.boardtable where num=?";
				Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = util.DBManagement.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBManagement.close(pstmt, con);
			}
	}
	
	public void replyInsert(BoardVO bvo) {
	boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
	
		
		String query = "insert into board.boardtable(title,userId,content,password,ref,step,reforder,replycount) values(?,?,?,?,?,?,?,?)";
		try {
		con = util.DBManagement.getConnection();
		
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, bvo.getTitle());
		pstmt.setString(2, bvo.getUserId());
		pstmt.setString(3, bvo.getContent());
		pstmt.setString(4, bvo.getPassword());
		pstmt.setInt(5, bvo.getRef());
		pstmt.setInt(6, bvo.getStep());
		pstmt.setInt(7, bvo.getReforder());
		pstmt.setInt(8, bvo.getReplycount());
		pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManagement.close(pstmt, con);
		}
	
	}
	
	public void countup(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
	
		
		String query = "update board.boardtable set replycount= replycount + 1 where num=?";
		try {
		con = util.DBManagement.getConnection();
		
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, num);
		
		pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManagement.close(pstmt, con);
		}
	
	}
	
	public void addReply(int boardnum, String userid, String content ) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into board.replytable(boardnum, userid, content) values(?,?,?)";
		try {
			con = util.DBManagement.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardnum);
			pstmt.setString(2, userid);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBManagement.close(pstmt, con);
			}
		
	}
	
	public List<BoardVO> selectReply(int boardnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
	
		String query = "select * from board.replytable where boardnum=?";
		
	
		try {
			con = util.DBManagement.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add( new BoardVO(
						rs.getInt("boardnum"),
						rs.getString("userid"),
						rs.getString("content")
				));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		
		
	}
}