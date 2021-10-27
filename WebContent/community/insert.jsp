<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>day7 글쓰기</title>
<script type="text/javascript">
function post_data() {
	/* 유효성 검사 */
	frm1.submit();
}
</script>
<link rel="stylesheet" href="../css/join.css?v=3">
</head>
<body>
<%@ include file="../top.jsp" %>
<section>
<c:if test="${sessionScope.user == null }">
	<script type="text/javascript">
		alert('글쓰기는 로그인을 해야합니다.');
		location.href='login.do';   //community 폴더 위로 이동한 위치의 loginView.jsp
	</script>
</c:if> 
<form name="frm1" method="post" action="qnaSave.do">
	<input type="hidden" name="idx" value="${user.idx}">
 <table>
 	<tr><th>제목</th>
 		<td><input type="text" name="title" size="50" required></td>
 	</tr>
 	<tr>
		<th>작성자</th>
 		<td><!-- <input type="text" name="name" size="50" required> -->
 		<input type="text" name="nick" size="50" readonly value="${sessionScope.user.nick }">
 		</td>  <!-- "" 문자열길이 0 -->
 	</tr>
 	
 	<tr><th>내용</th>  <!-- textarea 의 크기 : rows="20" cols="80" -->
 		<td><textarea  rows="20" cols="60" name="content" required></textarea>
 		<!--textarea 는 multi line 입력이 됩니다.  --></td>
 	</tr>
 	<tr><td colspan="2" align="center">
 	<input type="submit" value="저장" class="btn" >
 	<input type="reset"  value="다시쓰기" class="btn">
 	<input type="button" value="목록" onclick="location.href='/qnaList.do'" class="btn">
 	</td></tr>
 </table>
 </form>
</section> 
</body>
</html>