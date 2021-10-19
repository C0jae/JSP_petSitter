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

<h3>펫시터 게시글 작성</h3>
<hr>
<form method="post" action="ps_board_save.do" enctype="multipart/form-data">
	<table>
		<tr>
			<th width="25%">제목</th>
			<td><input type="text" name="title" width="100%" required="required"></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nick" width="100%" required="required"<%-- readonly value="${nick}" --%>></td>
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
			 	<input type="button" value="목록" onclick="location.href='index.do'" class="btn">
		 	</td>
		</tr>
		
	</table>
</form>

</body>
</html>