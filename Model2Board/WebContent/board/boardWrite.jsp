<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>게시물 등록</h2>
	<form action="../list.do" method="post" name="frm" onsubmit="return check();">
		제목:<input type="text" name="title"><br>
		글쓴이:<input type="text" name="userId"><br>
		내용:
		<textarea rows="15" cols="70" name="content">
		</textarea><br>
		비밀번호:<input type="text" name="password"><br>
		<input type="hidden" name="command" value="board_write">
		<input type="submit" value="등록하기">
		<input type="reset" value="취소하기">
		<input type="button" value="목록으로" onclick="location.href='list.do?command=board_list'">
	</form>
	
</body>
</html>