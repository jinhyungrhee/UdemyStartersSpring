<%@page import="springmvc.ListDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>컨트롤러부터 받은 메시지</h1>
<%
ListDTO dto = (ListDTO)request.getAttribute("model");
%>

<h3>자바스크립트태그 = <%= dto.getList() %></h3>
<h3>el = ${model.list} </h3>
</body>
</html>