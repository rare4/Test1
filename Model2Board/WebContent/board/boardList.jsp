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
  <style>
  </style>
  <script>
  </script>
</head>
<body>
	<h2 style="text-align:center;">게시판 목록</h2>
	<a href="board/boardWrite.jsp" style="margin-left:100px; margin-right:100px">글쓰기</a>
	<table class="table table-striped" style="margin-left:100px; margin-right:100px;">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>ref,step,reforder</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td id="num">${board.num }</td>
				<td>
				<c:forEach var="i" begin="1" end="${board.step }">
					<c:choose>
						<c:when test="${board.step == i }">
							└>
						</c:when>
						<c:otherwise>
							&nbsp;&nbsp;&nbsp;&nbsp;
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
				<a href="list.do?command=board_view&num=${board.num }">${board.title }</a>
				
				</td>
				<td id="userid">${board.userId }</td>
				<td><fmt:formatDate value="${board.postDate }"/></td>
				<td>${board.readCount }</td>
				<!-- ref, step,reforder 출력 -->
				<td>ref=${board.ref }  step=${board.step } reforder=${board.reforder }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>