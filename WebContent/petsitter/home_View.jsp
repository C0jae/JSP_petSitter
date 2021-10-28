<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫시터 검색 페이지</title>
<script>
	function validCheck() {
		//1. 패스워드는 8글자 이상이어야 한다.
		const frm = document.frmReg;
		//1. 패스워드는 8글자 이상이어야 한다.
		if (frm.value.length <= 2 ){
		alert('주소를 세글자 이상 입력해주세요(xx시)');
		frm.m_addr.focus();				// 포커스(커서) 이동 
		return false;						//함수가 종료.
		}
	}
</script>
<!--<link rel="stylesheet" href="../web.css?v=1"> -->
<style>
.div1{
	text-align:center;
	width:100%;
	margin-top:20px;
	margin-bottom:20px;
	border-top: 1px solid black;
	border-bottom: 1px solid black;
}
.box1{
	margin-top:20px;
	margin-bottom:10px;
}
.box2{
	margin-top:20px;
	margin-bottom:10px;
}
.box3{
	margin-top:10px;
	margin-bottom:10px;
}
.box4{
	margin-top:10px;
	margin-bottom:10px;
}
.box5{
	margin-top:10px;
	margin-bottom:10px;
	text-align:center;
}

.box6{
	margin-top:10px;
	margin-bottom:10px;
	text-align:center;
}
input[type=text]{
	cursor: pointer;
	width:200px;
	height:18px;
}
input[type=checkbox], input[type=date]{
	cursor: pointer;
	
}
input[type=submit], input[type=reset], input[type=button]{
	padding: 7px 15px;
	margin: 7px 5px;
	cursor: pointer;
	font-size: 1.1em;
	border-radius: 30px;
	border: none;
	background-color: black;
	color: white;
}
h2{
	padding:20px 20px 5px;
}
ul.mylist , ol.mylist  {
    display: inline-block;
    padding: 10px;
    margin-bottom: 5px;
    border: 1px solid #efefef;
    font-size: 12px;
    list-style:none;
}

.Main_container{
	width: 100%;
    height: 100%;
}

.thumbnail { padding:10px 20px 10px; border:none; width:400px; text-align:center; margin-left: 53px;}
.thumbnail img{ width:100%;;height: 300px; object-fit:cover; margin-bottom: 10px; border-radius: 20%;}
.container {width:30%;  padding:10px; border: none; float:left; }
</style>
</head>
<body>
<%@ include file="../top.jsp" %>
<br><br><br><br>
<div class ="Main_container">
	<form action="../Select_PetSitter.do" name="frmReg" method="post" id="frm" onsubmit="return validCheck()" >
		<div class = "div1">
			<div class = "box1">
				<label>주소 :</label>
				<input type="text" name="m_addr" placeholder="주소를 입력해주세요(ex)서울시)">&nbsp;&nbsp;
				<label>날짜 :</label> 
				<input type="date" name="wdate_start" value="s_date">&nbsp;~
				<input type="date" name="wdate_final" value="f_date">
			</div>
			<div class="box2">
				<div>
				<input type="checkbox" name="terms" value="반려동물없음">반려동물없음 
				<input type="checkbox" name="terms" value="픽업가능">픽업가능 
				<input type="checkbox" name="terms" value="대형견가능">대형견가능 
				<input type="checkbox" name="terms" value="마당있음">마당있음
				<input type="checkbox" name="terms" value="노견케어">노견케어
				</div>
			</div>
			<div class="box3">
				 <input type="submit" value="찾기"> 
				 <input type="reset" value="다시쓰기" >
			</div>
		</div>
		<div style="margin:auto;">
		 	<a class="button" href="${pageContext.request.contextPath }">홈으로 돌아가기 ${pageContext.request.contextPath }
		 	</a>&nbsp;&nbsp;&nbsp;"${pageDto.m_addr}" 로 검색한 지원자 : ${pageDto.totalCount } 명입니다.
		</div>
		<div class="box4">
			<div class="box6">
				<h2>★펫시터 목록★</h2>
				<c:if test="${pageDto.totalCount == null || pageDto.totalCount ==0}">
						<img src = "/img/select_empty.png" >
						<h3>펫시터를 조회해주시거나 다시 조회해주세요. </h3>
				</c:if>
			</div>
	  		 <c:forEach var="cmt" items="${cmtlist }">
				<div class = "container">
					<div class = "thumbnail">
						<a href = "ps_board_read.do?idx=${cmt.idx}&psb_idx=${cmt.psb_idx}&s_date=${s_date}&f_date=${f_date}"><img alt = "gallery" src = "/img/${cmt.g_fname}"></a>
						<!-- /img/는 url 경로와 c:\upload 매핑이 필욯ㅂ니다 -->
						<strong>${cmt.title}</strong>			
					</div>
					<div class = "box5">
						<ul class="mylist">
							<%-- <li>idx값 :  ${cmt.m_addr}</li> --%>
							<li>글제목 : ${cmt.title}</li>
							<li>주소 : ${cmt.m_addr}</li>
							<li>가능한 날짜 : ${cmt.ps_sdate} ~ ${cmt.ps_fdate }</li>
							<li>준비 : ${cmt.terms}</li><br>
							<li>펫시터 멘트 : ${cmt.comment}</li>		
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>
	</form> 
	<p style=clear:both;></p>
	<c:if test="${pageDto.totalCount != null && pageDto.totalCount !=0}">
	<div class="box6">
		<hr>
   		 <a class="pagenum" href="?page=1&m_addr=${pageDto.m_addr}&wdate_start=${pageDto.wdate_start}&wdate_final=${pageDto.wdate_final}&terms=${pageDto.terms}">&lt;&lt;</a>
   	  <c:if test="${pageDto.currentPage !=1 }">
   
         <a class="pagenum" href="?page=${pageDto.currentPage-1}&m_addr=${pageDto.m_addr}&wdate_start=${pageDto.wdate_start}&wdate_final=${pageDto.wdate_final}&terms=${pageDto.terms}">&lt;</a>
      </c:if>
      	<c:forEach var="i" begin="${pageDto.startPage}" end="${pageDto.endPage}">
         <a class="pagenum" href="?page=${i}&m_addr=${pageDto.m_addr}&wdate_start=${pageDto.wdate_start}&wdate_final=${pageDto.wdate_final}&terms=${pageDto.terms}">${i }</a>
      	</c:forEach>
      <c:if test="${pageDto.currentPage !=pageDto.endPage }">
  	     <a class="pagenum" href="?page=${pageDto.currentPage+1}&m_addr=${pageDto.m_addr}&wdate_start=${pageDto.wdate_start}&wdate_final=${pageDto.wdate_final}&terms=${pageDto.terms}">&gt;</a>
  	     <a class="pagenum" href="?page=${pageDto.endPage}&m_addr=${pageDto.m_addr}&wdate_start=${pageDto.wdate_start}&wdate_final=${pageDto.wdate_final}&terms=${pageDto.terms}">&gt;&gt;</a>
   	  </c:if>
	</div>
	</c:if>
</div>
</body>
 
</html>