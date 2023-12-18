<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 5px 10px;
        margin: 0 auto;
    }
    
    input[type="submit"]{
       height: 50px;
    }  
      
    a{
	color: black;
	text-decoration:none;
	}
    
    fieldset{
    margin-top: 15px
    
    }
    h2{
    text-align: center;}
	
</style>
</head>
<body>
	<h2>LOGIN</h2>
   	<hr/>
	<form action="/login" method="post" style="text-align: center;">	<!-- controller의 mapping url과 action url이 같아야함. -->
		<table>
			<tr>
				<th>ID</th>
				<th>
					<input type="text" name="username" value="" placeholder="아이디를 입력 하세요"/>
				</th>
				<th rowspan="2">
					<input type="submit" value="login"/>
				</th>
			</tr>    
		    <tr>
				<th>PW</th>
		        <th>
					<input type="password" name="password" value="" placeholder="비밀번호를 입력 하세요"/>
				</th>                
			</tr>
		   	<tr>
				<th colspan="3">
					<button> <a href="../joinForm">회원가입</a></button>
		           <!--  <input type="button" value="아이디/비번 찾기"/> -->
				</th>    
			</tr>
		</table>
	</form>					
</body>
</html>