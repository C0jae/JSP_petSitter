<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보</title>
<style>
</style>
<script type="text/javascript">
function post_data() {
	/* 유효성 검사 */
	frm1.submit();
}
</script>
<link rel="stylesheet" href="css/mup.css?v=3">
</head>
<body>
<%@ include file="../top.jsp" %>
<c:if test="${sessionScope.user==null }">
	<script type="text/javascript">
	</script>
</c:if> 
<div style="max-width: 1000px;">
	<input type="hidden" name="idx" value="${sessionScope.user.idx}" >  
	<div class="topbar"></div>
	<table style="width: 100%">
	<tr>
		<td class="name" id="name">이름 : ${sessionScope.user.name }님</td>
		<td class="nick">닉네임 : ${sessionScope.user.nick}</td>
		<td class="tel">전화번호 : ${sessionScope.user.tel}</td>
		<c:if test="${user.idx != 1}">
			<td class="poin">보유포인트 : ${sessionScope.user.point }</td>
		</c:if>
		<c:if test="${user.idx == 1}">
			<td class="poin">총 수익 : ${income}원</td>
		</c:if>
	</tr>
	</table>
 	<a class="mup" href="update.do?idx=${sessionScope.user.idx}">정보 수정</a>
 	<a class="mupo" href="./">돌아가기</a>
</div>
</body>
</html>