<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//1.controller에서 body라는 변수를 선언해서 보내주더냐 ?
		// 그 값을 브라우져에 보여봐라
	%>
		<h1>${BODY}</h1>
		
		<%
		//1. Controller에서 BODY라는 객체를 선언, 초기화해서 보내주더냐?
		//2. 그럼 그 객체에 AA라는 속성, 필드가 있느냐?
		//3. 없으면 오류발생
		// 있으면 값을 보이기
		//<h1>${BODY.aa}</h1>
		%>
		
<%
		// 1. 컨트롤러에서 BODY라는 변수를 선언햇냐.
		// 2. 그럼 BODY변수에 M1이라는 문자열이 담겨있냐?
		%>
		
	<c:choose>
		
		
		<c:when test="${BODY=='M1' }">
			<h1>BODY에 M1이 담겨있다.</h1>
		</c:when>
		<c:when test="${BODY=='M2' }">
			<H1> BODY에 M2가 담겨있다.</H1>
		</c:when>
		
		<c:otherwise>
			<p> 바디변수가 없거나, 담겨있는 값이
			 M1, M2, M3중 하나가 아닌경우
		</c:otherwise>
		
	</c:choose>
</body>
</html>