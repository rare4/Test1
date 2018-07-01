<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>게시판 글</div>
	<table border='1' style="width:500px; height:300px;">
		
	</table>
	<div>
		<%
			int currentpage = 0;
			
			if(request.getParameter("page") == null){
				currentpage=1;
			} else{
				currentpage = Integer.parseInt(request.getParameter("page"));
			}
			int prevpage = currentpage-1;
			int nextpage = currentpage+1;
			
			int total = 304; //전체 글 갯수
			int pageView = 10; // 1페이지당 출력할 개수
			int pageCount = total / pageView;
			
			
			int pageBlock = 10; //페이지 출력갯수
			double totalBlock = Math.ceil((double)pageCount / pageBlock);
			out.print("총 블럭:" + totalBlock +"<br>");
			double curPageBlock = Math.ceil((double)currentpage / pageBlock);
			out.print("현재페이지는 :" + curPageBlock );
			int startpage = (int)((curPageBlock * pageBlock) - (pageBlock-1));
			int endpage = (int)(curPageBlock * pageBlock);
			if(pageCount <= endpage){
				endpage = currentpage;
			}
			//---------------페이지 블럭처리---------------
			//현재 페이지가 4페이지라면(1~10까지)
			//currentpage / pageBlock ;
			// 4 / 10 = 0.4; (1페이지)
			// 0.4에 1을 더하고 
			
			
			
			
			if(total % pageView >0){
				pageCount++;
			}
			if(nextpage > pageCount){
				nextpage = pageCount;
			}
			
			if(prevpage==0){
				prevpage=1;
			}
			
				out.print("<a href='pagingTest.jsp?page=1;'>◀◀맨 앞</a>&nbsp;&nbsp;&nbsp;");
				out.print("<a href='pagingTest.jsp?page=" + prevpage +"'>◀이전</a>&nbsp;&nbsp;&nbsp;");
			for(int i = startpage; i<=endpage ; i++){
				
				out.print("<a href='pagingTest.jsp?page=" + i + "'> " + i +  "</a>&nbsp;&nbsp;&nbsp;");
			}
			out.print("<a href='pagingTest.jsp?page=" + nextpage +"'>다음▶</a>&nbsp;&nbsp;&nbsp;");
			out.print("<a href='pagingTest.jsp?page=" + pageCount + "'>맨 뒤▶▶</a>&nbsp;&nbsp;&nbsp;");
			
			
			
			
			
		%>
		
		
	</div>

</body>
</html>