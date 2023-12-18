<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style >
    h2{
    text-align: center;}
	a{
	color: black;
	/*text-decoration:none;*/
	}
</style>
</head>
<body>
	<h2>Info page</h2>
	<hr>
		<h3>UserName : ${info.username}</h3>
		<h3>Password : ${info.password}</h3>
		<h3>MemberRole : ${info.role}</h3>
		<a href="../">뒤로가기</a><br>
</body>
</html>