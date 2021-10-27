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
		/* var nick = document.getElementById("nick");
		window.returnValue=nick; */
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
	
		<hr>
		<div style="margin:auto;">
		<ul id="main">
			<li>
				<ul class="row">
					<li>펫시터 닉네임</li>
					<li>펫시터 주소</li>
				</ul>
			</li>
		<c:set var="pno" value="${pageDto.currentPage}" />
		<c:forEach var="pl" items="${pslist }">
			<li>
				<ul class="row">
					<li><a href="#" onclick="document.getElementById('ps_nick').value='${pl.nick}'">${pl.nick }		<input type="hidden" name="idx" value="${pl.idx }"></a></li>

					<li>${pl.m_addr }</li>
				</ul>
		</c:forEach>
			
		</ul>
		<script type="text/javascript">


</script>
	</div>
	
	<div style="text-align: center;">
			<hr>
		
			<c:if test="${pageDto.startPage !=1 }">
				<a class="pagenum" href="?page=1">&lt;&lt;</a>
				<a class="pagenum" href="?page=${pageDto.startPage-1}">&lt;</a>
				<!-- 현재페이지를 startPage값에서 -1 로 변경하면 요청이 변경되면서 자동계산. -->
			</c:if>

			<c:forEach var="i" begin="${pageDto.startPage }"
				end="${pageDto.endPage }">
				<a
					class="pagenum  
			<c:if test="${pageDto.currentPage == i }">current</c:if>
		"
					href="?page=${i }">${i }</a>
			</c:forEach>

			<c:if test="${pageDto.endPage !=pageDto.totalPage }">
				<a class="pagenum" href="?page=${pageDto.endPage+1}">&gt;</a>


				<a class="pagenum" href="?page=${pageDto.totalPage }">&gt;&gt;</a>

			</c:if>
		</div>
		</section>
</body>
</html>