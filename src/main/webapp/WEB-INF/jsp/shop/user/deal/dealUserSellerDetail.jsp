<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<style type="text/css">
td {
	text-align: left;
}
</style>

<script type="text/javascript">
	function dealUserSellerAccept() {
		if (confirm(" 거래 수락 하시려면 예를 누르시고\n거래 수락 하지 않으시려면 아니오를 눌러주세요")) {
			location.href = "/shop/user/deal/dealUserSellerAccept.do?d_idx=${dealUserVO.d_idx}";
		} else {
			alert('아니오를 누르셨습니다');
		}
	}

	function dealUserSellerCancel() {
		if (confirm(" 거래 취소 하시려면 예를 누르시고\n거래 취소 하지 않으시려면 아니오를 눌러주세요")) {
			location.href = "/shop/user/deal/dealUserSellerCancel.do?d_idx=${dealUserVO.d_idx}";
		} else {
			alert('아니오를 누르셨습니다');
		}
	}

	function dealUserSellerDeliver() {
		if (confirm(" 배송 시작 하시려면 예를 누르시고\n배송 시작을 하지 않으시려면 아니오를 눌러주세요")) {
			location.href = "/shop/user/deal/dealUserSellerDeliver.do?d_idx=${dealUserVO.d_idx}";
		} else {
			alert('아니오를 누르셨습니다');
		}
	}

	function dealUserSellerReview() {
		if (confirm(" 후기 작성 하시려면 예를 누르시고\n후기 작성 하지 않으시려면 아니오를 눌러주세요")) {
			location.href = "/shop/user/review/EgovBuyerInsertForm.do?p_idx=${dealUserVO.p_idx}"; 
		} else {
			alert('아니오를 누르셨습니다');
		}
	}
</script>

</head>
<body>
	<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopTop.jsp"%>
	<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopHeader.jsp"%>
	<div class="container text-center">
		<div class="row justify-content-center">
			<h3>판매 거래 상세 페이지</h3>
		</div>
	</div>
	<div class="container text-center">
		<div class="row justify-content-center">
			<div class="row">
				<p>
				<table class="table">
					<tr>
						<th style="text-align: right">거래상태</th>
						<td><c:choose>
								<c:when test="${dealUserVO.d_ing eq '1'}"> 구매자 신청 </c:when>
								<c:when test="${dealUserVO.d_ing eq '2'}"> 판매자 수락 </c:when>
								<c:when test="${dealUserVO.d_ing eq '3'}"> 배송 시작 </c:when>
								<c:when test="${dealUserVO.d_ing eq '4'}"> 거래 완료 </c:when>
								<c:when test="${dealUserVO.d_ing eq '5'}"> 구매자 거래 취소 </c:when>
								<c:when test="${dealUserVO.d_ing eq '6'}"> 판매자 거래 취소 </c:when>
							</c:choose></td>
					</tr>
					<tr>
						<th style="text-align: right">구매자</th>
						<td>${dealUserVO.nickname}</td>
					</tr>
					<tr>
						<th style="text-align: right">상품명</th>
						<td>${dealUserVO.p_name }</td>
					</tr>
					<tr>
						<th style="text-align: right">상품 수량</th>
						<td>${dealUserVO.d_q }개</td>
					</tr>
					<tr>
						<th style="text-align: right">가격</th>
						<td><fmt:formatNumber type="number" maxFractionDigits="3"
								value="${dealUserVO.p_price * dealUserVO.d_q}" />원</td>
					</tr>
					<tr>
						<th style="text-align: right">내용</th>
						<td>설명</td>
					</tr>
					<tr>
						<th style="text-align: right">주소 및 배송 요청사항</th>
						<td><textarea style="width: 100%" rows=8 readonly="readonly">${dealUserVO.d_request}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div style="text-align: right;">

								<c:choose>
									<c:when
										test="${dealUserVO.d_ing eq '1' || dealUserVO.d_ing eq '2' || dealUserVO.d_ing eq '3'}">
										<button type="button" class="btn btn-danger"
											onclick="dealUserSellerCancel()">거래 취소</button>
									</c:when>
								</c:choose>

								<c:choose>
									<c:when
										test="${dealUserVO.d_ing eq '1'}">
										<button type="button" class="btn btn-success"
											onclick="dealUserSellerAccept()">거래 수락</button>
									</c:when>
								</c:choose>

								<c:choose>
									<c:when test="${dealUserVO.d_ing == '2'}">
										<button type="button" class="btn btn-success"
											onclick="dealUserSellerDeliver()">배송 시작</button>
									</c:when>
								</c:choose>

								<c:choose>
									<c:when test="${dealUserVO.d_ing == '4'}">
										<button type="button" class="btn btn-info"
											onclick="dealUserSellerReview()">후기 작성</button>
									</c:when>
								</c:choose>
							</div><p>

							<div style="text-align: center;">
								<button type="button" class="btn btn-warning"
									onclick="location.href='/shop/user/deal/dealUserSellerList.do'">
									<i class="fa fa-bars">목록</i>
								</button>
							</div>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopBottom.jsp"%>
</body>
</html>