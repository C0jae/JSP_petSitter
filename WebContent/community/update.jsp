<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>펫시터 사이트</title>
<script type="text/javascript">
function post_data() {
	frm1.submit();
}
</script>
<link rel="stylesheet" href="../css/temp.css?v=3">
</head>
<body>
<section>
<h3>q&a글 수정</h3>
<hr>
<form name="frm1" method="post" action="qnaModify.do?page=${page }&q_idx=${bean.q_idx}">
 <input type="hidden" name="q_idx" value="${bean.q_idx}">
 <input type="hidden" name="page" value="${page}">
 <table>
 	<tr><th width="35%">제목</th>
 		<td><input type="text" name="title" value="${bean.title}" size="50" required></td>
 	</tr>
 	<tr><th>닉네임</th>
 		<td><input type="text" name="nick" size="50" value="${bean.nick}" disabled></td>
 	</tr>
 	
 	<tr><th>내용</th>  <!-- textarea 의 크기 : rows="20" cols="80" -->
 		<td><textarea  rows="20" cols="80" name="content" required>${bean.content}</textarea></td>
 	</tr>
 	<tr><td colspan="2" align="center">
 	<input type="submit" value="저장" class="btn" >
 	<input type="reset"  value="다시쓰기" class="btn">
 	<input type="button" value="목록" class="btn" onclick="location.href='qnaList.do?page=${page}'">
 	</td></tr>
 </table>
 </form>
 </section>
</body>
</html>
