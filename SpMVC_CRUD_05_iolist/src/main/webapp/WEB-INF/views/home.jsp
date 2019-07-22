<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/main2.css?ver=201907277">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/list.css?ver=20190719">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/button.css?ver=20190719">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/input.css?ver=20190719">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/view.css?ver=20190719">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/login.css?ver=20190719">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<section class="main-section">
		<article id="product" class="body-box">
		
			<%@ include file="/WEB-INF/views/ajax_body/product/body.jspf"%>
		</article>
		<article id="iolist" class="body-box">
			<%@ include file="/WEB-INF/views/ajax_body/iolist/input.jspf"%>
		</article>
		<article id="comp" class="body-box">
			<h5>거래처정보</h5>
		</article>
	</section>
</body>
</html>