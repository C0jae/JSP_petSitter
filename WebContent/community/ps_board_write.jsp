<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫시터 게시글 작성</title>
</head>
<body>
<%@ include file="../top.jsp" %>
<br><br><br><br><hr>
<h3>펫시터 게시글 작성</h3>
<hr>
<form method="post" action="./ps_board_save.do" enctype="multipart/form-data">
	<input type="hidden" name="idx" value="${user.idx}">
	<table>
		<tr>
			<th width="25%">제목</th>
			<td><input type="text" name="title" width="100%" required="required"></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nick" width="100%" required="required" readonly value="${petsitter.nick}"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="m_addr" width="100%" required="required" readonly value="${petsitter.m_addr}"></td>
		</tr>
		<tr>
			<th width="25%">시작일</th>
			<td><input type="date" name="ps_sdate" width="25%" required="required"></td>
		</tr>
		<tr>
			<th width="25%">종료일</th>
			<td><input type="date" name="ps_fdate" width="25%" required="required"></td>
		</tr>
		<tr>
			<th>견종</th>
			<td width="20%">
				<input type="checkbox" name="size" value="소형견">
				<label for="small">소형견</label> (7kg 미만)
				<input type="checkbox" name="size" value="중형견">
				<label for="middle">중형견</label> (7kg 이상 15kg 미만)
				<input type="checkbox" name="size" value="대형견">
				<label for="big">대형견</label> (15kg 이상)
			</td>
		</tr>
		<tr>
			<th>조건체크</th>
			<td width="20%">
				<label><input type="checkbox" name="terms" value="반려동물없음">반려동물 없음</label>
				<label><input type="checkbox" name="terms" value="픽업가능">픽업 가능</label>
				<label><input type="checkbox" name="terms" value="대형견가능">대형견 가능</label>
				<label><input type="checkbox" name="terms" value="마당있음">마당 있음</label>
				<label><input type="checkbox" name="terms" value="노견케어">노견 케어</label>
			</td>
		</tr>
		<tr>
			<th>코멘트</th>
			<td><textarea rows="2" cols="80" name="comment" required="required" placeholder="ex) #아파트 #테라스보유 #산책로있어요"></textarea></td>
		</tr>
		<tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="20" cols="80" name="content" required="required"></textarea></td>
		</tr>
		<tr>
			<th>사진</th>
			<td>
				<input type="file" name="pic" accept="image/*" multiple>
			</td>
		</tr>
		<tr height="200">
		 	<td colspan="2" align="center">
			 	<input type="submit" value="저장" class="btn" >
			 	<input type="reset"  value="다시쓰기" class="btn">
			 	<input type="button" value="돌아가기" onclick="location.href='index.do'" class="btn">
		 	</td>
		</tr>
		
	</table>
</form>

</body>
</html>