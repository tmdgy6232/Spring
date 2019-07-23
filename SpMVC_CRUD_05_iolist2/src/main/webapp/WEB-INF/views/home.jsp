<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/main2.css?ver=201907278">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/list.css?ver=20190720">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/button.css?ver=20190723">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/input.css?ver=20190719">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/view.css?ver=20190719">
<link rel="stylesheet" type="text/css"
	href="${rootPath}/resources/css/login.css?ver=20190719">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<script src ="${rootPath}/resources/js/iolist_input.js?ver=20191919">

</script>	

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	section.main-section {
	display: flex;
}
	article.body-box {
		flex : 1 1 33%;
		
		overflow:auto;
	}
	
</style>
<script>
	$(function() {
		$.ajax({
			url : '${rootPath}/iolist/list',
			method : 'GET'
		})
		.done(function(result) {
			$("#iolist_view").html(result)
		})
	})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<section class="main-section">
	
		<article id="comp" class="body-box">
		<%@ include file="/WEB-INF/views/ajax_body/comp/body.jspf"%>
		</article>
		<article id="iolist" class="body-box">
			<%@ include file="/WEB-INF/views/ajax_body/iolist/input.jspf"%>
			<div id="iolist_view"></div>
		</article>
		
		<article id="product" class="body-box">
		
			<%@ include file="/WEB-INF/views/ajax_body/product/body.jspf"%>
		</article>
	</section>
</body>
</html>