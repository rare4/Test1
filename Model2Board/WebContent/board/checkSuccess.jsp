<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function check(){
	result = null;
	var title = document.frm.title.value;
	var userId = document.frm.userId.value;
	var content = document.frm.content.value;
	if(title.length > 0 && userId.length > 0 && content.length > 0){
		result = true;
	}else{	
		result = false;
	}
	
	if(title.length ==0 ){
		alert('제목을 적어주세요');
		result = false;
	}
	if(userId.length == 0){
		alert('작성자를 적어주세요')
		result = false;
	}
	if(content.length == null){
		alert('내용을 적어주세요')
		result = false;
	}
	
	return result;
}

 	
</script>
</head>
<body>
		<h2>수정/삭제 페이지</h2>
	
		<form action="list.do" method="post" style="width:500px;" onsubmit="return check();">
			글번호:${board.num }<br>
			<input type="hidden" name="num" value='${board.num }'>
			<input type="hidden"  name="command" value="board_update">
			제목<input type="text" name="title" value='${board.title }'><br>
			내용<input type="text" name="content" value='${board.content }' style="height:300px; width:500px;"><br>
			글쓴이<input type="text" name="userId" value=${board.userId }><br>
			<input type="submit"  value="게시물수정하기">
			
		</form>
		<input type="button" value="게시물삭제하기" onclick="location.href('list.do?command=board_delete&num=${board.num}')">
		
</body>
</html>