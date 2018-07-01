<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2></h2>
	<form action="list.do?command=board_check_pass" method="post" name="frm">
		비밀번호를 입력하세요:<input type="password" name="password">
		<input type="hidden" name="num" value=${param.num } >
		<input type="submit" value="전송">
		
	</form>
	
</body>
</html>