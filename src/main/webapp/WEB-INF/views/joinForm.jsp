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
    
    
    fieldset{
    margin-top: 15px
    
    }
    h2{
    text-align: center;}
	
</style>
</head>
<body>
	<h2>JOIN</h2>
   	<hr/>
	<form action="/join" method="post" style="text-align: center;">	<!-- controller의 mapping url과 action url이 같아야함. -->
		<table>
			<tr>
				<th>ID</th>
				<th>
					<input type="text" name="username" value="" placeholder="아이디를 입력 하세요"/>
				</th>
				<th rowspan="3">
					<input type="submit" value="Join"/>
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
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="role" id="inlineRadio1" value="ROLE_ADMIN">
					  <label class="form-check-label" for="inlineRadio1">Admin</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="role" id="inlineRadio2" value="ROLE_MANAGER">
					  <label class="form-check-label" for="inlineRadio2">Manager</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="role" id="inlineRadio3" value="ROLE_MEMBER">
					  <label class="form-check-label" for="inlineRadio3">Member</label>
					</div>
				</th>    
			</tr>
		</table>
	</form>					
</body>
</html>