<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<style type="text/css">
div {
	font-family: 'Gugi', cursive;
	width: 200px;
	height: 200px;
	color: #aabb97;
	padding: 120px;
	margin: 100px auto;
}
input{ 	padding: 5px;
		margin: 10px auto; 
}
input[type=submit], input[type=button], input[type=reset] {
	background:	#aabb99;
	color: white;
}
</style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/addressapi.js"></script>
<script>
	function validCheck() {
		const frm = document.frmReg;
		//1. 패스워드는 8글자 이상이어야 한다.
		if (frm.password.value.length < 8){
			alert('패스워드는 8글자 이상으로 하세요.');
			frm.password.focus();				// 포커스(커서) 이동 
			return false;						//함수가 종료.
		}
	}
</script>
</head>
<body>

	<div  style="width: 70%; margin: auto;">
		<form action="save.do" name="frmReg" method="post"
			onsubmit="return validCheck()" onclick="idCheck()" onclick="execPostCode()">
			<table style="width: 100%">
				<tr><th>이름</th>
		 			<td> <input type="text" name="name" ></td>
			 	</tr>
			 	<tr>
					<th>아이디</th>
			 		<td> <input type="text" name="id" onkeydown="inputIdChk()"> 
			 		    <input type="button" value="중복확인" onclick="openIdChk()">    
                        <input type="hidden" name="idDuplication" value="idUncheck" ></td>
				</tr>

			 	<tr><th>비밀번호</th>
			 		<td><input type="password" name="password">(8자리 이상 입력해주세요)</td>
			 	</tr>
			 	<tr><th>닉네임</th> 
			 		<td><input type="text"  name="nick"></td>
			 	</tr>
				 <tr>
					<th>성별</th>
					<td><input type="radio" value="남자" name="gender">남자
						<input type="radio" value="여자" name="gender">여자</td>
				</tr>
			 	<tr><th>생년월일</th>
					<td><input type="date" name="birth"></td>
				</tr>
				<tr><th>전화번호</th>
					<td><input type="tel" name="tel">(ㅡ 없이 입력해주세요)</td>
				</tr>
				<tr><th>기본주소</th>
					<td> <input class="form-control" style="top: 5px;" name="m_addr" id="m_addr" type="text">( 예)00시 00구)</td>
				</tr>
				<tr><th>상세주소</th>
					<td><input type="text" name="s_addr">( 예)00로 00길 00-0 )</td>
				</tr>
				<tr><th>포인트</th>
					<td><input type="number" value="0" name="point" readonly ></td>
				</tr>
				<tr><th>팻시터 지원여부</th>
					<td><input type="radio" value="지원" name="p_auth">지원
						<input type="radio" value="미지원" name="p_auth" checked>미지원</td>
				</tr>
				<tr><th>자격증 여부</th>
						<td><input type="radio" value="o"  name="license">있음
						<input type="radio" value="x" name="license" checked>없음</td>
				</tr>
				<tr><th>근무가능 일수(펫시터 지원시 입력)</th>
					<td><input type="number" value=0 name="work_date"></td>
				</tr>
				<tr><th>거주형태(펫시터 지원시 입력)</th>
					<td><select name="home" id="home_select">
							<option value="">선택없음</option>
							<option value="빌라">빌라</option>
							<option value="아파트">아파트</option>
							<option value="단독주택">단독주택</option>
							<option value="기타">기타</option>
					</select> 
					<span id="home_id">
					<input type="text" name="home_etc" disabled="disabled" 
							placeholder="기타" >
					</span></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" value="가입하기"> <!-- submit : 서버에게 데이터를 제출 (form action 속성값에 설정된 url 로 데이터 전달.)
						action 이 .html 은 데이터 전송확인은 못합니다. url 이동만 확인!!--> <input
						type="reset" value="다시쓰기"></td>
				</tr>
			</table>		
		</form>
	</div>
	<script type="text/javascript">
	document.getElementById("home_select").addEventListener("change",function(){
		if(this.value=="기타"){ 
			document.frmReg.home_etc.disabled=false;
		}else {
			document.frmReg.home_etc.disabled=true;
		}
		
	});
	</script>
</body>
</html>