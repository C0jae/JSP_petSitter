<%@page import="dto.Member"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>

<script language='javascript'>
function noEvent() {
    if (event.keyCode == 116) {
        event.keyCode= 2;
        return false;
    }
    else if(event.ctrlKey && (event.keyCode==78 || event.keyCode == 82))
    {
        return false;
    }
}
document.onkeydown = noEvent;
</script>
<link rel="stylesheet" href="css/mup.css?v=3">
</head>
<body>
<%@ include file="../top.jsp" %>
<hr>
	<div style="max-width: 1000px;">
	<input type="hidden" name="idx" value="${dto.idx}" >
	<table style="width: 100%">
	<tr >
		<td id="name">이름 : ${dto.name }님</td>
		<td>닉네임 : ${dto.nick}</td>
		<td>보유포인트 : ${dto.point }</td>
	</tr>
 		</table>
 		<a href="update.do?idx=${dto.idx}">정보 수정</a>
		</div>
</body>
</html>