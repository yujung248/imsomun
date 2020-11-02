<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<style type="text/css">
div.button input {
	padding: 9px;
	margin-left: 30px;
	text-align: center;
}

div.button {
	text-align: center;
	margin-bottom: 20px;
}

p {
	font-size: 2em;
}
</style>
</head>
<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>

	<!-- result 값을 이용한 modal -->
	<c:if test="${result == 1}">
		<script type="text/javascript">
			$(document)
					.ready(function() {
						$("#updateModal").modal('show')

					})
		</script>
		<!-- Modal -->
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">수정되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<div class="container">
		<div class="row">
			<div class="card" style="border: 1px solid #fff; padding-left: 30px;">
				<div class="row no-gutters">
					<div class="col-2">
						<img src="<c:url value='/'/>file/${SellerVO.s_photo}"
							class="card-img" style="border-radius: 50%;" />
					</div>
					<div class="col-8">
						<div class="card-body">
							<p class="card-text">
							<h6 class="text-center">입소문넷 회원 ${SellerVO.s_nickname}님
								안녕하세요!</h6>
							<p>
							<div class="button" style="border-top-width: 20px">
								<input type="button" class="btn btn-outline-danger"
									onclick="location.href='/shop/user/seller/updateUserSellerForm.do?s_id=${SellerVO.s_id}'"
									value="정보수정"> <input type="button"
									class="btn btn-outline-danger"
									onclick="location.href='/shop/user/product/EgovUserProductlist.do?s_id=${SellerVO.s_id}'"
									value="내 상품보기"><input type="button"
									class="btn btn-outline-danger"
									onclick="location.href='/shop/user/deal/dealUserSellerList.do'"
									value="내 거래내역보기"> <input type="button"
									class="btn btn-outline-danger"
									onclick="location.href='/shop/user/review/EgovUserSellerListForm.do?s_id=${SellerVO.s_id}'"
									value="리뷰관리"> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<p>
		<div class="text-dark"
			style="border: 1px solid #cd3c3c; padding-left: 50px; border-radius: 10px;">
			<p class="text-left m-3">내 상품보기</p>
			<p>
			<p>
			<p>
			<p>
			<p>
				<c:forEach var="product_list" items="${list}" varStatus="status"
					begin="0" end="4">
					<div class="mt-3">
						<li><img src="<c:url value='/'/>file/${product_list.p_image}"
							width="30" height="30" class="rounded" /> 
							<span class="font-weight-bold">
							"${product_list.p_name }"</span>
							 <span class="font-weight-normal" style="color: red"> 
							<span class="font-weight-normal" style="color: #59a3d9;"> (${product_list.s_id }) </span> 
							 <fmt:formatNumber value="${product_list.p_price }" pattern="##,###"></fmt:formatNumber>원</span>
					</div>
				</c:forEach>
			<div class="m-3"
				style="text-align: right; color: #275291; border-right-width: 5px;">
				<a href="/shop/user/product/EgovUserProductlist.do?s_id=${SellerVO.s_id}">자세히...</a>
			</div>
		</div>

		<p>
		<div class="text-dark"
			style="border: 1px solid #cd3c3c; padding-left: 50px; border-radius: 10px;">
			<p class="text-left m-3">내 거래내역 보기</p>
			<p>
			<p>
			<p>
			<p>
			<p>
				<c:forEach items="${dealUserlist }" var="list" varStatus="status"
					begin="0" end="4">
					<div class="mt-3">
							<li><span class="font-weight-bold">"${list.p_name}"</span>
							${list.d_q }개
							 <span class="font-weight-normal" style="color: red">${list.p_price * list.d_q  }</span>
							<span class="font-weight-normal" style="color: #59a3d9;">(${list.nickname })</span>
							<span class="font-weight-normal" style="color: gray; font-style: oblique;">
						<c:choose>
							<c:when test="${list.d_ing eq '1'}"> 신청 </c:when>
							<c:when test="${list.d_ing eq '2'}"> 수락 </c:when>
							<c:when test="${list.d_ing eq '3'}"> 배송시작 </c:when>
							<c:when test="${list.d_ing eq '4'}"> 구매 확정 </c:when>
							<c:when test="${list.d_ing eq '5'}"> 구매자 거래 취소 </c:when>
							<c:when test="${list.d_ing eq '6'}"> 판매자 거래 취소 </c:when>
						</c:choose>
							</span>
							${list.d_regdate }
					</div>
				</c:forEach>
			<div class="m-3"
				style="text-align: right; color: #275291; border-right-width: 5px;">
				<a href="/shop/user/deal/dealUserSellerList.do">자세히...</a>
			</div>
		</div>

		<p>
		<div class="text-dark"
			style="border: 1px solid #cd3c3c; padding-left: 50px; border-radius: 10px;">
			<p class="text-left m-3">내가 쓴 리뷰 보기</p>
			<p>
			<p>
			<p>
			<p>
			<p></p>
			<c:forEach items="${list1}" var="result" begin="0" end="2">
				<li>
				<c:choose>
					<c:when test="${result.r_div eq '1'}">
						<span class="font-weight-normal" style="color: #59a3d9;">구매자</span>
                            <span class="font-weight-normal" style="color: #59a3d9;">(${result.s_id})</span>
                            <span class="font-weight-normal" style="color: red">구매자 점수 : ${result.sns_score}</span>
                            <span class="font-weight-normal">${result.r_regdate}</span>
					</c:when>
					<c:otherwise>
						<span class="font-weight-normal" style="color: #59a3d9;">판매자</span>
                            <span class="font-weight-normal" style="color: #59a3d9;">(${result.s_id})</span>
							<span class="font-weight-normal" style="color: red">판매자 점수 : ${result.seller_score}</span>
                            <span class="font-weight-normal">${result.r_regdate}</span>
					</c:otherwise>
				</c:choose>
				<div id="r_view${result.r_idx}" style="display: none;">
					<textarea id="r_contentVal${result.r_idx}"
						name="r_contentVal${result.r_idx}" rows="5" cols="70">${result.r_content }</textarea>
					<a href="javascript:updateUserReview('${result.r_idx}');">저장</a>
				</div>
				<div id="r_view2${result.r_idx}" style="display: block;">
					<span class="font-weight-bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"${result.r_content}"</span>
				</div>
			</c:forEach>
			<div class="m-3" style="text-align: right; color: #275291;">
				<a href="/shop/user/review/EgovUserSellerListForm.do?s_id=${SellerVO.s_id}">자세히...</a>
			</div>
		</div>
	</div>
	<div id="div_bottom" style="padding-top: 50px;">
		<%@ include file="../../inc/EgovShopBottom.jsp"%>
	</div>
</body>
</html>