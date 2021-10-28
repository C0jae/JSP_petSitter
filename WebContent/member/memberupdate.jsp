<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객 수정</title>
<link rel= "stylesheet" href="./css/mupdate.css?v=3">
</head>
<body>
<%@ include file="../top.jsp" %>

<section>
	<div >
		<form action="modify.do?idx=${dto.idx }" name="frmReg" method="post">
			<input type="hidden" name="idx" value="${dto.idx}" >  
			<!--브라우저에 출력은 안되고 파라미터로 필요한값은 type을 hidden으로 한다. -->
			<table >
				<tr>
				<td><label>회원 수정</label><td>
				</tr>  <!-- 이메일 , 지역 -->
				<tr>
					<td><label>이름</label></td>

					<td><input type="text" name="name" placeholder="이름 이력(필수)" value="${dto.name }"
						readonly></td>   	<!--  readonly : 읽기만.입력못합니다.-->
				</tr>
				<tr>
					<td><label>비밀번호</label></td>
					<td><input type="password" name="password" value="${dto.password }"></td>
				</tr>
				<tr>
					<td><label>전화번호</label></td>
					<td><input type="text" name="tel" value="${dto.tel }"></td>
				</tr>
				<tr>
					<td><label>기본주소</label></td>
					<td><input type="text" name="m_addr" min="10" max="99" value="${dto.m_addr }"></td>
				</tr>
				<tr>
					<td><label>상세주소</label></td>
					<td><input type="text" name="s_addr"min="10" max="99" value="${dto.s_addr }"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center">
					<input type="submit" value="수정하기"> 
					<input type="button" value="탈퇴하기" onclick="deleteOk()">
					<input type="button" value="돌아가기" onclick="location.href='list.do'"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="myModal" class="modal">
			<span class="close">&times;</span><br>
			<div style="padding: 0px 20px; color:red;" >
				<b>비밀번호</b><br>
				<br>
				<form action="delete.do" method="post" name="frmPassword"
						onsubmit="return deleteSet()">
					<input type="hidden" name="idx" value="${dto.idx }"> <!--삭제할 글번호-->
					<input type="password" name="password" size="10">
					<input type="submit" value="확인" style="padding: 5px 20px;">
					<br>
					<span style="color:red;font-size:0.8em;" id="err"></span>
				</form>
			</div>
	</div>
	<script>
	var modal = document.getElementById('myModal');
	var span = document.getElementsByClassName("close")[0];

	span.onclick = function() {   //span 요소의 onclick 속성값에 해당하는 함수를 설정합니다.
		modal.style.display = "none";   //modal 화면에 안보이기   닫기 기능 구현
	}

	function deleteSet() {
		const yn = confirm('[주의]등록된 고객에서 삭제하시겠습니까 ?');
		if(yn){
			//비밀번호 입력되었는지확인.
			if(document.frmPassword.password.value==""){
				document.getElementById('err').innerHTML = "비밀번호를 입력하세요.";
				return false;
			} else {  	return true; 	}
			
		}else {
			modal.style.display = "none"; 
			return false;
		}
	}
	function deleteOk(){
		document.getElementById('myModal').style.display='block';		
	}
</script>
</section>
</body>
</html>