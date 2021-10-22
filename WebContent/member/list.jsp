<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 리스트</title>
</head>
<body>
<section>
<h3> 고객 리스트 WELCOME!!!</h3>
<hr>
<div style="margin:auto;">
	<c:forEach var="dto" items="${list}"> 
	<li>
	<ul >
		<li>${dto.idx }</li>
		<li id="name"><a href="detail.do?idx=${dto.idx}">${dto.name }</a> 님</li>
		<li id="nick">${dto.nick}></li>
		<li>${dto.point }</li>
		<li>${dto.m_addr}</li>
	</ul>
	</li>
 	</c:forEach>
</div>
</section>
</body>
</html>

