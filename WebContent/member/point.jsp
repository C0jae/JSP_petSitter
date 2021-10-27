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
<link rel="stylesheet" href="css/join.css?v=3">
<%@ include file="../top.jsp" %>
<body>
<c:if test="${alert!=null }">
	<script type="text/javascript">
		alert('포인트가 충전되었습니다.');
	</script>
</c:if>
 	<div style="width: 70%; margin: auto;">
				<table style="width: 100%">
                <td>포인트 충전</td>
                <form action="charge.do?idx=${dto.idx }" name="frmReg" method="post" onsubmit="return validCheck()">
				<input type="hidden" name="idx" value="${dto.idx}" >  
					<tr>
					<td>보유 포인트 : ${dto.point }</td> 
					</tr>
				<tr>
				<td><label>충전 금액 : </label>
               	<input type="radio" name="point" value="5000"><span>5,000원</span>
               	<input type="radio" name="point" value="10000"><span>10,000원</span>
               	<input type="radio" name="point" value="15000"><span>15,000원</span>
                <input type="radio" name="point" value="20000"><span>20,000원</span>
                <input type="radio" name="point" value="25000"><span>25,000원</span>
                <input type="radio" name="point" value="30000"><span>30,000원</span>
                <input type="radio" name="point" value="35000"><span>35,000원</span>
                <input type="radio" name="point" value="40000"><span>40,000원</span>
                <input type="radio" name="point" value="45000"><span>45,000원</span>
                <input type="radio" name="point" value="50000"><span>50,000원</span>
                <input type="radio" name="point" value="55000"><span>55,000원</span>
                <input type="radio" name="point" value="60000"><span>60,000원</span>
                <input type="radio" name="point" value="65000"><span>65,000원</span>
                <input type="radio" name="point" value="70000"><span>70,000원</span>
                <p  style="color: #ac2925; margin-top: 30px">최소 충전금액은 5,000원이며 <br/>최대 충전금액은 70,000원 입니다.</p>		
               	</td> 
                <tr>
                	<td colspan="2" style="text-align: center">
                	<input type="submit" value="결제하기" >
                	</td>
                </tr>
     			 </form>
                </table>
 </div>
</body>
</html>