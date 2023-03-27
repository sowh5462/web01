<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="home.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
.menu a{
		text-decoration : none;
		margin-left : 15px;
		color: gray;
		font-size : 1.2rem;
	}
</style>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="menu">
	<a href="/">home</a>
	<a href ="/posts">게시글</a>
	<a href ="/users">사용자목록</a>
	<a href="/login">로그인</a>
	</div>
	<hr/>
	<jsp:include page="${ pageName }"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>