<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="<%=request.getContextPath() %>/resources/images/android.jpg">
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){alert("성공")});
</script>

<h1>로그인폼</h1>

<!--  JSP가 JSP를 직접 호출하지 않음 - DispatcherServlet을 반드시 거쳐야 함! : MVC 구조 -->
<form action="<%=request.getContextPath() %>/login" method=post>
	아이디 <input type=text name="id"><br>
	암호 <input type=password name="pw"><br>
	나이 <input type=number name="age">
	<input type="submit" value="로그인">
</form>

======================================================
<h1> ${all } </h1>

</body>
</html>