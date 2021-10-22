<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫시터 게시글 보기</title>
</head>
<body>
	<%@ include file="../top.jsp" %>
	<br><br><br><br><hr>
	<div class="g_container">
			<div class="g_thumbnail">
				<img alt="gallery" src="/img/${ps_board.g_fname}">
			</div>
	</div>
	<hr>
	<div class="ps_baord_main" style="display: flex; align-content: ">
		<div>
			<div>
				<div><h3>${ps_board.m_addr} 펫시터 : ${petSitter.nick} 님</h3></div>
				<div><h2>${ps_board.title}</h2></div>
				<div>${ps_board.comment}</div>
			</div>
			<div><h4>${petSitter.nick} 펫시터님을 소개합니다.</h4></div> <br>
			<div>${ps_board.content}</div> <br>
			<div><h4>함께사는 반려동물</h4></div>
			<c:forEach var="pet" items="${pet}">
				<div>${pet.p_name}</div>
				<div>
					<c:if test="${pet.p_weight < 7}">
						소형
					</c:if>
					<c:if test="${pet.p_weight >= 7 && pet.p_weight < 15}">
						중형
					</c:if>
					<c:if test="${pet.p_weight > 15}">
						대형
					</c:if>
					 / ${pet.p_gender} / ${pet.p_birth} 년생
				</div><br>
			</c:forEach>
			<div><h4>자격증 및 교육수료</h4></div>
			<div>${petSitter.license}</div> <br>
			<div><h4>펫시터 후기
				<c:if test="${rateCnt == null}"> 없음 </c:if> 
				<c:if test="${rateCnt != null}"> ${rateCnt}개 </c:if>
				<c:if test="${rateCnt != null}"> ${rate}점 </c:if>
			</h4></div>
			<div>후기 게시판</div>
		</div>
		<div>
			<form method="post" name="reserve" action="./ps_reserve.do">
				<input type="hidden" name="idx" value="${user.idx}">
				<input type="hidden" name="ps_idx" value="${ps_idx}">
				<input type="hidden" name="s_date" value="${s_date}">
				<input type="hidden" name="f_date" value="${f_date}">
				<div class="ps_board_sub" style="margin: 80px">
					<div><h4>기간</h4></div>
					<div>${s_date} ~ ${f_date}</div>
					<div><h4>맡기시는 반려동물</h4></div>
					<div>
						소형견(7kg 미만) : 
						<c:if test="${p_size.contains('소형견')}">
							<input type="text" onchange="money()" id="small" name="small" placeholder="마릿수입력(숫자만)"> <br>
						</c:if>
						<c:if test="${!p_size.contains('소형견')}">
							<input type="text" onchange="money()" id="small" name="small" placeholder="선택불가" readonly> <br>
						</c:if>
						중형견(7kg 이상 15kg 미만) : 
						<c:if test="${p_size.contains('중형견')}">
							<input type="text" onchange="money()" id="middle"  name="middle" placeholder="마릿수입력(숫자만)"> <br>
						</c:if>
						<c:if test="${!p_size.contains('중형견')}">
							<input type="text" onchange="money()" id="middle" name="middle" placeholder="선택불가" readonly> <br>
						</c:if>
						대형견(15kg 이상) : 
						<c:if test="${p_size.contains('대형견')}">
							<input type="text" onchange="money()" id="big" name="big" placeholder="마릿수입력(숫자만)">
						</c:if>
						<c:if test="${!p_size.contains('대형견')}">
							<input type="text" onchange="money()" id="big" name="big" placeholder="선택불가" readonly> <br>
						</c:if>
						
					</div>
					<div id="result"></div>
					<div id="result2"></div>
					<div id="result3"></div>
					
					<div><input type="button" value="예약요청" class="rsvBtn" onclick="check()"></div>
				</div>
			</form>
			<br>
			<div class="ps_board_sub" style="margin: 80px">
				<div style="display: flex">
					<div><h4>이용 요금(1박기준)</h4></div>
				</div>
				<div style="display: flex">
					<div>소형견</div>
					<div>7kg 미만</div>
					<div>50,000원</div>
				</div>
				<div style="display: flex">
					<div>중형견</div>
					<div>7kg 이상 15kg 미만</div>
					<div>65,000원</div>
				</div>
				<div style="display: flex">
					<div>대형견</div>
					<div>15kg 이상</div>
					<div>80,000원</div>
				</div>
			</div>
			<div class="ps_board_sub" style="margin: 80px">
				<div style="display: flex">
					<div><h4>${petSitter.nick} 님의 위치 :</h4></div>
					<div><h4>${ps_board.m_addr}</h4></div>
				</div>
				<div>
					<div id="map" style="width:500px;height:400px;"></div>
					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=86c0773d8189ca233acd039192c7bcd1"></script>
					<script>
						var container = document.getElementById('map');
						var options = {
							center: new kakao.maps.LatLng(33.450701, 126.570667),
							level: 3
						};
				
						var map = new kakao.maps.Map(container, options);
						
						
				/* 		var geocoder = new kakao.maps.services.Geocoder();
		
						var callback = function(result, status) {
						    if (status === kakao.maps.services.Status.OK) {
						        console.log(result);
						    }
						};
		
						geocoder.addressSearch('해남군 송지면', callback); */
					</script>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function check() {
			const yn = confirm('예약하시겠습니까? 해당금액만큼 포인트가 차감됩니다.');
			if (yn) {
				document.reserve.submit();
			}
			else {
				modal.style.display = "none";
				return false;
			}
		}
		
		function money() {
			var small = 0;
		    var middle = 0;
		    var big = 0;

			if(document.getElementById("small").value != null) {
		    	small = document.getElementById("small").value;
		    }
		    if(document.getElementById("middle").value != null) {
		    	middle = document.getElementById("middle").value;
		    }
		    if(document.getElementById("big").value != null) {
		    	big = document.getElementById("big").value;
		    }
		   
		    small = Number(small);
		    middle = Number(middle);
		    big = Number(big);
		    
		    var money = 0;
		    var vat = 0;
		    var pay = 0;
		    money = Number(money);
		    vat = Number(vat);
		    pay = Number(pay);
		    
		    money = (small * 50000) + (middle * 65000) + (big * 80000);
		    vat = money / 10;
		    pay = money + vat;
		    
			/* document.reserve.pay.value = pay; */
		    
		    document.getElementById("result").innerHTML = "합계금액 : " + pay + "원 (1박기준)";
		    document.getElementById("result2").innerHTML = "비용 : " + money + "원";
		    document.getElementById("result3").innerHTML = "부가세(10%) : " + vat + "원";
		    
		}
		
		
	</script>


</body>
</html>