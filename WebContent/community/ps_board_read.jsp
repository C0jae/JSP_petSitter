<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫시터 게시글 보기</title>
<link rel= "stylesheet" href="../css/ps_board.css?v=3">
</head>
<body>
	<%@ include file="../top.jsp" %>
	<br><br><br><br><br>
	<div class="g_container">
			<div class="g_thumbnail">
				<img alt="gallery" src="/img/${ps_board.g_fname}" style="width: 800px; height: 350px;">
			</div><hr>
	</div>
	<div class="ps_board_main">
		<div style="margin-right: 50px;">
			<div class="box1">
				<div style="font-size: 15px; line-height: 22px;">
					<h3>${ps_board.m_addr} 펫시터 : ${petSitter.nick} 님</h3>
				</div>
				<div style="font-size: 25px; line-height: 37px;">
					<h2>${ps_board.title}</h2>
				</div>
				<div style="font-size: 14px; line-height: 21px;">
					${ps_board.comment}
				</div>
			</div>
			<div class="box2">
				<h4>${petSitter.nick} 펫시터님을 소개합니다.</h4>
			</div> <br>
			<div style="font-size: 17px;">${ps_board.content}</div> <br>
			<div class="box2">
				<h4>함께사는 반려동물</h4>
			</div>
			<div style="display: flex;">
				<c:forEach var="pet" items="${pet}">
					<div class="box3" style="height: 100px; width: 250px; margin-right: 15px;">
						<div style="font-size: 15px; text-align: left; font-weight: bold;">
							&nbsp&nbsp&nbsp&nbsp${pet.p_name}
						</div>
						<div style="font-size: 13px; text-align: center;">
							<c:if test="${pet.p_weight < 7}">
								소형
							</c:if>
							<c:if test="${pet.p_weight >= 7 && pet.p_weight < 15}">
								중형
							</c:if>
							<c:if test="${pet.p_weight >= 15}">
								대형
							</c:if>
							 / ${pet.p_gender} / ${pet.p_birth} 년생
						</div><br>
					</div>
				</c:forEach>
			</div>
			<div class="box2"><h4>자격증 및 교육수료</h4></div>
			<div class="box3" style="height: 50px; width: 300px; display: flex;">
				&nbsp&nbsp&nbsp&nbsp${petSitter.license}
			</div> <br>
			<div class="box2"><h4>펫시터 후기
				<c:if test="${rateCnt == null}"> 없음 </c:if> 
				<c:if test="${rateCnt != null}"> ${rateCnt}개 </c:if>
				<c:if test="${rateCnt != null}"> ${rate}점 </c:if>
			</h4></div>
			<div style="width: 70%;">
				<div>
					<c:forEach var="review" items="${review}">
						<div class="box3">
							<div class="reviewBox">
								<div style="display: flex; height: 30px;">
									<div style="width: 30%;"><h3>${review.nick} 님</h3></div>
									<div class="star" style="width: 70%; text-align: right;">
										<c:forEach var="i" begin="1" end="${rate}">★</c:forEach>
									</div>
								</div>
								<div style="text-align: right; height: 40px;"><h5>${review.r_date}</h5></div>
								<div style="font-size: bold;">${review.content}</div>
							</div>
						</div><br>
					</c:forEach>
				</div>
			</div>
		</div>
		<div>
			<form method="post" name="reserve" action="./ps_reserve.do">
				<c:if test="${user == null}">
					<input type="hidden" name="state" value="notLogin">
				</c:if>
				<c:if test="${user != null}">
					<input type="hidden" name="idx" value="${user.idx}">
				</c:if>
				<input type="hidden" name="ps_idx" value="${ps_idx}">
				<input type="hidden" name="psb_idx" value="${ps_board.psb_idx}">
				<div class="ps_board_sub" style="margin: 80px">
					<div class="box4">
						<div class="box2"><h4>기간</h4></div>
						<div class="box3" style="text-align: center; font-size: 15px; display: flex;">
							<div style="width: 45%; text-align: center;">
								<c:if test="${s_date == ''}">
									<input type="date" class="dateBox" name="s_date" min="${ps_board.ps_sdate}" max="${ps_board.ps_fdate}" onchange="sdate()" id="sdate">
								</c:if>
								<c:if test="${s_date != ''}">
									<input type="hidden" name="s_date" value="${s_date}">
									${s_date}
								</c:if>
							</div>
							<div style="width: 10%; text-align: center;">~</div>
							<div style="width: 45%; text-align: center;">
								<c:if test="${f_date == ''}">
									<input type="date" class="dateBox" name="f_date" min="${ps_board.ps_sdate}" max="${ps_board.ps_fdate}">
								</c:if>
								<c:if test="${f_date != ''}">
									<input type="hidden" name="f_date" value="${f_date}">
									${f_date}
								</c:if>
							</div>
						</div>
						<div class="box2"><h4>맡기시는 반려동물</h4></div>
						<div class="box3">
							<div style="display: flex; margin-left: 10px;">
								<div style="width: 50%;">
									소형견(7kg 미만) : 
								</div>
								<div>
									<c:if test="${p_size.contains('소형견')}">
										<input type="text" onchange="money()" id="small" name="small" placeholder="마릿수입력(숫자만)"> <br>
									</c:if>
									<c:if test="${!p_size.contains('소형견')}">
										<input type="text" onchange="money()" id="small" name="small" placeholder="선택불가" readonly> <br>
									</c:if>
								</div>
							</div>
							<div style="display: flex; margin-left: 10px;">
								<div style="width: 50%;">
									중형견(7kg 이상 15kg 미만) : 
								</div>
								<div>
									<c:if test="${p_size.contains('중형견')}">
										<input type="text" onchange="money()" id="middle"  name="middle" placeholder="마릿수입력(숫자만)"> <br>
									</c:if>
									<c:if test="${!p_size.contains('중형견')}">
										<input type="text" onchange="money()" id="middle" name="middle" placeholder="선택불가" readonly> <br>
									</c:if>
								</div>
							</div>
							<div style="display: flex; margin-left: 10px;">
								<div style="width: 50%;">
									대형견(15kg 이상) : 
								</div>
								<div>
									<c:if test="${p_size.contains('대형견')}">
										<input type="text" onchange="money()" id="big" name="big" placeholder="마릿수입력(숫자만)">
									</c:if>
									<c:if test="${!p_size.contains('대형견')}">
										<input type="text" onchange="money()" id="big" name="big" placeholder="선택불가" readonly> <br>
									</c:if>
								</div>
							</div>
						</div><br>
						<div style="text-align: center;">
							<div id="result" style="font-size: 15px; font-weight: bold;"></div><hr>
							<div id="result2" style="font-size: 13px;"></div>
							<div id="result3" style="font-size: 13px;"></div>
						</div><br>
						<div>
							<c:if test="${user.idx != petSitter.idx}">
								<input type="button" value="예약요청" class="rsvBtn" onclick="check()">
							</c:if>
						</div>
					</div>
				</div>
			</form>
			<div class="ps_board_sub" style="margin: 80px">
				<div class="box4">
					<div style="display: flex">
						<div class="box2" style="width: 230px"><h4>이용 요금</h4></div>
						<div style="text-align: right; width: 150px"><h5>1박기준</h5></div>
					</div>
					<div class="box3">
						<div style="display: flex; margin-left: 20px;">
							<div class="size1">소형견</div>
							<div class="size2">(7kg 미만)</div>
							<div class="size3">50,000원</div>
						</div>
						<div style="display: flex; margin-left: 20px;">
							<div class="size1">중형견</div>
							<div class="size2">(7kg 이상 15kg 미만)</div>
							<div class="size3">65,000원</div>
						</div>
						<div style="display: flex; margin-left: 20px;">
							<div class="size1">대형견</div>
							<div class="size2">(15kg 이상)</div>
							<div class="size3">80,000원</div>
						</div>
					</div>
				</div>
			</div>
			<div class="ps_board_sub" style="margin: 80px">
				<div class="box2" style="display: flex; margin-left: 20px; margin-right: 20px;">
					<div style="width: 35%;"><h4>${petSitter.nick} 님의 위치 :</h4></div>
					<div style="width: 65%; text-align: center;"><h5>${ps_board.m_addr}</h5></div>
					<input type="hidden" id="addr" value="${ps_board.m_addr}">
				</div>
				<div>
					<div id="map" style="width:100%;height:350px;"></div>

					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=86c0773d8189ca233acd039192c7bcd1&libraries=services"></script>
					<script>
					var addr = document.getElementById("addr").value;
					console.log(addr);
					
					var infowindow = new kakao.maps.InfoWindow({zIndex:1});
					
					var mapContainer = document.getElementById('map'),
					    mapOption = {
					        center: new kakao.maps.LatLng(37.566826, 126.9786567),
					        level: 3
					    };  
					
					var map = new kakao.maps.Map(mapContainer, mapOption); 
					
					var ps = new kakao.maps.services.Places(); 
					
					ps.keywordSearch(addr, placesSearchCB); 
					
					function placesSearchCB (data, status, pagination) {
					    if (status === kakao.maps.services.Status.OK) {
					
					        var bounds = new kakao.maps.LatLngBounds();
					
					        for (var i=0; i<data.length; i++) {
					            displayMarker(data[i]);    
					            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
					        }       
					
					        map.setBounds(bounds);
					    } 
					}
					
					function displayMarker(place) {
					}
					</script>
				</div>
			</div>
			<div>
				<c:if test="${user.nick == petSitter.nick || user.admin == '1'}">
					<div style="display: flex; margin-left: 160px;">
							<a class="btn" href="ps_boardUpdate.do?psb_idx=${ps_board.psb_idx}&nick=${petSitter.nick}">수정</a>
							<a class="btn" href="ps_boardDelete.do?psb_idx=${ps_board.psb_idx}" onclick="delCheck()">삭제</a>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function delCheck(){
			const yn = confirm('게시글을 삭제하시겠습니까?');
			if(yn) {
				document.reserve.submit();
			}
			else {
				modal.style.display = "none";
				return false;
			}
		}
		
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
		
		function sdate() {
			var sdate = 0;
			sdate = document.getElementById("sdate").value;
			document.getElementById("startDate").innerHTML = sdate;
		}
		
		
	</script>


</body>
</html>