<%@page import="java.util.ArrayList"%>
<%@page import="com.goodee.dto.BoardVO"%>
<%@page import="com.goodee.dao.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
			  function save(){
			      var frmData = $('#frmData').serialize();
			     $.ajax({
			          type: 'post',
			          url : 'AjaxManagement',
			          data : frmData,
			          success:function (data){
			             console.log(data);
			             var reply = "";
			         	$('#replyList').html("");
			          	for(var i = 0; i < data.length; i++){
			          	
			          		$('#replyList').append("ID: " + data[i].title + ", Content: " + data[i].content + "<br>");
			          	
			          	}
			          }
			          ,error:function(req){
			             alert('통신실패,상태 : ' +req.responseText);
			          }
			       
			       }); 
			  }
 </script>

  </script>
</head>
<body>
		
	
	
		<h2>상세페이지</h2>
		
	
		
	
		
		
		<table border="1" class="table table-striped" style="margin:50px; width:70%">
			<tr>
				
				<th style="text-align:center;">제목: ${board.title }</th>
			</tr>
			<tr style="height:200px;">
				<td>${board.content }</td>
			</tr>
			<tr>
				<td>작성자: ${board.userId }</td>
			</tr>
		</table>
		<form id="frmData">
				ID : <input type="text" name="userid">
				댓글달기 : <input type="text" name="content">
				<input type="hidden" name="boardnum" value="${board.num }">
				<input type="button" value="댓글달기" onclick="save();">
				
				
		</form>
		<hr>
		
	
		<div id="replyList">
		<c:forEach var="i" items="${list }">
			
		ID=	${i.title }  , Content = ${i.content }<br>
		</c:forEach>
		</div>
		<input type="button" onclick="location.href='list.do?command=board_list'" value="목록으로 돌아가기">
		<input type="button" onclick="location.href='list.do?command=board_check_pass_form&num=${board.num}'" value="게시물 수정&삭제">
		<input type="button" value="댓글달기" onclick="location.href('list.do?command=board_reply_form&num=${board.num}&ref=${board.ref }&step=${board.step }&reforder=${board.reforder }&replycount=${board.replycount}')">
		
	</body>
</html>