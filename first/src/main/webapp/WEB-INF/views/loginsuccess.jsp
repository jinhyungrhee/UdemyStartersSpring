<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 입력했던 아이디는 ${loginresult.id }이고,</h1> <!-- el은 getter메서드를 호출하지 않음 getId() == .id -->
<h1> 입력했던 비밀번호는 ${loginresult.pw }입니다 </h1>

========================================================================

<h1>${all }</h1>
</body>
</html>