<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>동아리 커뮤니티</title>
<script type="text/javascript">
function post_data() {
	frm1.submit();
}
</script>
<link rel="stylesheet" href="../css/join.css?v=3">
<link rel="stylesheet" href="../css/rate.css?v=3">
</head>
<body>
<section>
<%@ include file="../top.jsp" %>
<!-- <h3>동아리 커뮤니티 글 수정</h3> -->
<!-- <hr> -->
<form name="frm1" method="post" action="rbmodify.do?page=${page }">
 <input type="hidden" name="r_idx" value="${bean.r_idx}">
 <table>
 	<tr><th width="35%">제목</th>
 		<td><input type="text" name="title" value="${bean.title}" size="50" required></td>
 	</tr>
 	<tr><th>작성자</th>
 		<td><input type="text" name="name" size="50" value="${bean.nick}" disabled></td>
 	</tr>
 	<tr><th>평점</th>
 	<td> <div class="star-rating">
	<input type="radio" id="5-stars" name="rate" value="5" checked="checked" />
  	<label for="5-stars" class="star">&#9733;</label>
  	<input type="radio" id="4-stars" name="rate" value="4" />
  	<label for="4-stars" class="star">&#9733;</label>
  	<input type="radio" id="3-stars" name="rate" value="3" />
  	<label for="3-stars" class="star">&#9733;</label>
  	<input type="radio" id="2-stars" name="rate" value="2" />
  	<label for="2-stars" class="star">&#9733;</label>
  	<input type="radio" id="1-star" name="rate" value="1" />
  	<label for="1-star" class="star">&#9733;</label>
  	</div>
 	<tr><th>내용</th>  <!-- textarea 의 크기 : rows="20" cols="80" -->
 		<td><textarea  rows="20" cols="80" name="content" required>${bean.content}</textarea></td>
 	</tr>
 	<tr><td colspan="2" align="center">
 	<input type="submit" value="저장" class="btn">
 	<input type="reset"  value="다시쓰기" class="btn">
 	<input type="button" value="목록" class="btn" onclick="location.href='rblist.do?page=${page}'">
 	</td></tr>
 </table>
 </form>
 </section>
</body>
</html>