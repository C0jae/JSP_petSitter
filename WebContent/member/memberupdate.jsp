<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Day4[]- 고객 수정</title>
<style  type="text/css">
div {
	font-family: 'Gugi', cursive;
	width: 200px;
	height: 200px;
	color: #aabb97;
	padding: 120px;
	margin: 100px auto;
}
input{ 	padding: 5px;
		margin: 20px auto; 
}
input[type=submit], input[type=button], input[type=reset] {
	background:	#aabb99;
	color: white;
	left : 30px;
}
</style>
<script>
	function validCheck() {
		
	}
	
	function deletOk() {
		const yn = confirm('[주의]등록된 고객에서 삭제하시겠습니까 ?');
		if(yn){
			alert(`고객 idx ${dto.idx} 를 삭제합니다.)`)
			location.href=`delete.do?idx=${dto.idx}`;
		}else{
			alert('고객 삭제를 취소했습니다.');
		}
		
	}
</script>
</head>
<body>
<c:if test="${alert!=null }">
	<script type="text/javascript">
		alert('고객 정보가 수정되었습니다.!');
	</script>
</c:if>
	<div style="width: 30%; margin: auto;">
		<h3>회원 수정</h3>  <!-- 이메일 , 지역 -->
		<form action="modify.do?idx=${dto.idx }" name="frmReg" method="post"
			onsubmit="return validCheck()">
			<input type="hidden" name="idx" value="${dto.idx}" >  
			<!--브라우저에 출력은 안되고 파라미터로 필요한값은 type을 hidden으로 한다. -->
			<table style="width: 100%">
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
					<input type="button" value="탈퇴하기" onclick="deletOk()">
					<input type="button" value="고객목록" onclick="location.href='list.do'"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>