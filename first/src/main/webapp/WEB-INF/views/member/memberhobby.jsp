<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="member" method="post">
아이디 <br>
암호 <br>
나이 <br>
취미(다중선택) : <br> 
<input type=checkbox name="hobby" value="음악"> 음악감상 <br>
<input type=checkbox name="hobby" value="영화"> 영화감상 <br>
<input type=checkbox name="hobby" value="game"> 게임 <br>
<input type=checkbox name="hobby" value="study"> 공부 <br>
<input type=submit value="내정보입력" > 

</form>

</body>
</html>