<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫시터 선택</title>
<link rel="stylesheet" href="css/boardlist.css?v=3">
<link rel="stylesheet" href="css/pslist.css?v=3">
</head>
<script type="text/javascript">
function closePop(){
	opener.document.frm1.ps_nick.value= document.frm.ps_nick.value;
	self.close();
}

</script>
<body>
<section>
	
	<form name="frm" method="post" action='rbinsert.do' target="_serf">
		<table>
			<tr>
				<th>펫시터 닉네임</th>
				<td>
				<input type="text" size="22" id="ps_nick" readonly>
				<input type="button" size="8" onclick="closePop()" value="선택">
				</td>
			</tr>
		</table>
		</form>
		<form name="frm2" method="post" action="searchps.do">
		<table>
			<tr>
			<th>닉네임으로 검색</th>
				<td>
				<input type="text" size="22" name="nick">
				<input type="submit" size="8" value="검색">
				</td>
			</tr>
		</table>
	</form>
	<span ></span>
	
		<hr>
		<div style="margin:auto;">
		<ul id="main">
			<li>
				<ul class="row">
					<li>펫시터 닉네임</li>
					<li>펫시터 주소</li>
				</ul>
			</li>
		<c:forEach var="pl" items="${result }">
			<li>
				<ul class="row">
					<li><a href="#" onclick="document.getElementById('ps_nick').value='${pl.nick}'">${pl.nick }		<input type="hidden" name="idx" value="${pl.idx }"></a></li>

					<li>${pl.m_addr }</li>
				</ul>
			
	
			</c:forEach>

			
		</ul>
		
	</div>
	<hr>
		</section>
</body>
</html>