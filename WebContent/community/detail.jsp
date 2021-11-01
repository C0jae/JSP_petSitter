<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
<link rel="stylesheet" href="../css/q_board.css?v=3">
</head>
<body>
  <%@ include file="../top.jsp" %>

<section>
	<!-- 문서가 생성될때 실행 -->
	<br><br>
	<h3>Q&A 게시판</h3>
	<hr><br>
	<div style="width: 80%; margin: auto;max-width: 700px;">
		<ul id="main">
			<li>
				<ul class="row">
					<li>제목</li>
					<li style="color: black;">${bean.title}</li>
					<li>조회수</li>
					<li>${bean.q_cnt}</li>
				</ul>
			</li>
			<li>
				<ul class="row">
					<li>닉네임</li>
					<li style="color: black;">${bean.nick}<span
				style="font-size: 70%; padding-left: 30px; color: black;">(${bean.ip})</span></li>
					<li>작성날짜</li>
					<li style="color: black;"><fmt:formatDate value="${bean.q_date }" type="both"/></li>
					<!-- pattern="yyyy-MM-dd HH:mm:ss , type= date,time,both -->
				</ul>
			</li>
			<li id="content">
				<ul>
					<li>내용</li>			
					
					<li>
						<pre>${bean.content}</pre>
					
					</li>				
				</ul>
			</li>
		</ul>
	<div style="text-align: center;margin-bottom: 10px;">
		<c:if test="${user.nick == bean.nick || user.admin == '1'}">
			<a class="button" href="qnaUpdate.do?q_idx=${bean.q_idx}&page=${page}">수정</a>
			<a class="button" href="qnaDelete.do?q_idx=${bean.q_idx}&page=${page}" onclick="deleteOk()">삭제</a>
		</c:if>
		<a class="button" href="qnaList.do?page=${page}">목록</a>
	</div>
	<!-- 메인글 출력 끝 -->
	<!-- 댓글 시작 -->
	<form action="comment.do?page=${page }" method="post" name="frmCmt">
	<input type="hidden" name="q_idx" value="${bean.q_idx }">
	<input type="hidden" name="a_idx" value="${user.idx }">
		<hr class="line">
		<div>
			<span style="color: black;">댓글</span>
			<span style="color: black;">[${qc_cnt}]</span>
			<span></span>
		</div>
		<hr class="line">
		<ul id="main">
			<c:if test="${user.admin == 1}">
				<li>
					<ul class="row">
						<li>작성자</li>
						<li><input type="text" name="a_nick" class="input" value="${user.nick}"></li>
					</ul>
				</li> 
				<li>
					<ul class="row-2">
						<li>
						<textarea rows="5"
							cols="80" name="qc_content" style="resize: none;"
							placeholder="댓글을 작성하세요." class="input" required></textarea>
						</li>
						<li>
							<input type="submit" value="저장" class="button small">
							<input type="reset" value="취소" class="button small">
						</li>
					</ul>
				</li>
			</c:if>
			<c:forEach var="cmt" items="${cmtlist }">
			<ul class="box">
				<li>
					<ul>
				  		<li style="float: left;">${cmt.nick }</li>
				  		<c:if test="${user.admin == 1}">
							<li style="float: right;"><a style="color: red; font-size: 0.8em;" href="javascript:deleteCmt('${cmt.qc_idx }','${bean.q_idx }','${page }')">삭제</a></li>
				  		</c:if>
					</ul>
				</li>
				<li>
					<pre>ㄴ ${cmt.qc_content }</pre>
				</li>
			</ul>
			</c:forEach>
		</ul>
	</form>
	
</div>
<!-- 처음에는 display가 none 이고 안보입니다. -->
<!-- modal : alert,confirm 메소드 사용 외에 추가적인 정보를 받을 때 사용자가 만드는 입력 상자...-->
	<div id="myModal" class="modal">
		<!-- Modal content : 모달 입력창-->
		<div class="modal-content">
			<span class="close">&times;</span><br>
			<div style="padding: 0px 20px;">
				<b>글비밀번호</b><br>
				<br>
				<form action="qnaDelete.do" method="post" name="frmPassword"
						onsubmit="return deleteOk()">
					<input type="hidden" name="q_idx" value="${bean.q_idx }"> <!--삭제할 글번호-->
					<input type="hidden" name="page" value="${page }">
					<input type="password" name="password">
					<input type="submit" value="확인" style="padding: 5px 20px;">
					<br>
					<span style="color:red;font-size:0.8em;" id="err"></span>
				</form>
			</div>
		</div>
	</div>
</section>	
<%@ include file="../bottom.jsp" %>
<!-- 모달 끝 -->
<script type="text/javascript">
	var modal = document.getElementById('myModal');
	var span = document.getElementsByClassName("close")[0];
	
	span.onclick = function() {   //span 요소의 onclick 속성값에 해당하는 함수를 설정합니다.
		modal.style.display = "none";   //modal 화면에 안보이기   닫기 기능 구현
	}
	
	function deleteOk(){
		const yn = confirm('글을 삭제하시겠습니까?');
		if(yn){
/* 			if(document.frmPassword.password.value=="") {
				document.getElementById('err').innerHTML = "비밀번호를 입력하세요."
				return false;
			}
			else if(document.frmPassword.password.value != document.getElementById("password")) {
				document.getElementById('err').innerHTML = "비밀번호가 틀렸습니다."
				return false;
			}
			else {
				return true;
			} */
			return true;
		}
		else {
			modal.style.display = "none";
			return false;
		}
	
	}
	function deleteSet(){
		document.getElementById('myModal').style.display='block';		
	}
	
	function deleteCmt(qc_idx,q_idx,page){
		console.log(qc_idx);console.log(q_idx);
		const yn = confirm('댓글 삭제하시겠습니까?');
		if(yn){
			location.href='comment.do?del=&qc_idx=' + qc_idx + "&q_idx=" + q_idx + "&page="+page;
		}else {
			alert('댓글 삭제를 취소합니다.');
		}
	}
</script>
	

</body>
</html>
