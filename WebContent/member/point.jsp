<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>point 충전</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<c:if test="${alert!=null }">
	<script type="text/javascript">
		alert('포인트가 충전되었습니다.');
	</script>
</c:if>
 	<div style="width: 70%; margin: auto;">
                <h3>포인트 충전</h3>
                <form action="charge.do?idx=${dto.idx }" name="frmReg" method="post" onsubmit="return validCheck()">
				<input type="hidden" name="idx" value="${dto.idx}" >  
				<table style="width: 100%">
					<ul>
					<li>보유 포인트 : ${dto.point }</li> 
					</ul>
				<tr>
				<td><label>충전 금액</label>
               	<input type="radio" name="point" value="5000"><span>5,000원</span>
               	<input type="radio" name="point" value="10000"><span>10,000원</span>
               	<input type="radio" name="point" value="15000"><span>15,000원</span>
                <input type="radio" name="point" value="20000"><span>20,000원</span>
                <input type="radio" name="point" value="25000"><span>25,000원</span>
                <input type="radio" name="point" value="30000"><span>30,000원</span>
                <input type="radio" name="point" value="35000"><span>35,000원</span>
                <input type="radio" name="point" value="40000"><span>40,000원</span>
                <input type="radio" name="point" value="50000"><span>50,000원</span>
                <p  style="color: #ac2925; margin-top: 30px">충전금액은 5,000원이며 <br/>최대 충전금액은 50,000원 입니다.</p>		
               	</td> 
                <tr>
                	<td colspan="2" style="text-align: center">
                	<input type="submit" value="결제하기" >
                	</td>
                </tr>
                </table>
     		 </form>
 </div>
</body>
</html>