<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style >
	a{
	color: black;
	/*text-decoration:none;*/
	}
</style>
</head>
<body>
<h1>접근 권한이 없습니다.</h1>
<!-- <a href="../">뒤로가기</a><br> -->
<a href="${pageContext.request.contextPath}/">뒤로가기</a><br>
<a href="../logout">로그아웃</a>
</body>
</html>