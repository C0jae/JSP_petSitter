<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이용자 후기 게시판</title>

<link rel="stylesheet" href="../css/rbboardlist.css?v=3">
<link rel="stylesheet" href="css/flexbox2.css?v=3">

</head>
<body>
	<%@ include file="../top.jsp"%>
	<section>
		<h2><img alt="" src="img/thumbsup.png" name="img" style="margin-top: 20px">
		이용자 후기 게시판</h2>
		<div style="margin: auto;">
			<ul id="main">
				<li>
					<ul class="mainrow">
						<li>제목</li>
						<li>작성자</li>
						<li>펫시터</li>
						<li>평점</li>
						<li>조회수</li>
						<li>작성일</li>
					</ul>
				</li>
				<c:set var="pno" value="${pageDto.currentPage}" />
				<c:forEach var="rb" items="${list}">
					<li>
						<ul class="row">
							<li><a href="rbdetail.do?r_idx=${rb.r_idx}&page=${pno}"
								class="title" >${rb.title }<input type="hidden" value="idx?=${idx }"></a> </li>
							<li>${rb.nick }</li>
							<li>${rb.ps_nick }</li>
							<li><c:forEach var="i" begin="1" end="${rb.rate }">★</c:forEach></li>
							<li>${rb.r_cnt}</li>
							<li><fmt:formatDate value="${rb.r_date }"
									pattern="yyyy-MM-dd" var="r_date" /> <c:if
									test='${r_date == today}'>
									<fmt:formatDate value="${rb.r_date }" type="time" />
								</c:if> <c:if test='${rb.r_date != today}'>
									<fmt:formatDate value="${rb.r_date }" pattern="yyyy-MM-dd " />
								</c:if></li>
							

						</ul>
					</li>
				</c:forEach>
			</ul>
			</div>
<div style="margin:auto;">
	<div style="text-align: right">
 	<a class="button" href="rbinsert.do?">글쓰기</a>&nbsp;&nbsp;
 	<a class="button" href="/index.do">홈 </a>
 	</div>
		</div>
		<div style="text-align: center;">
			<!--  href="listAction.jsp?page=1"  요청 url 현재와 같을때 생략하고 ? 뒤에 파라미터값만 변경합니다. -->
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
	<%-- <%@ include file="../bottom.jsp"%> --%>
</body>
</html>