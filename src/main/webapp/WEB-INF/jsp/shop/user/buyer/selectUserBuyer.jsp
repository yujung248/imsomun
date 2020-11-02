<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<style type="text/css">

	.myList {
	border: 1px solid #cd3c3c;
	border-radius : 10px;
	}


</style>
</head>

<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="mx-auto p-2">
				<button class="btn btn-outline-danger"
					onclick="location.href='/shop/user/buyer/updateUserBuyerForm.do'">
					정보수정</button>
				<button class="btn btn-outline-danger"
					onclick="location.href='/shop/user/basket/listBasketUser.do'">
					장바구니</button>
				<button class="btn btn-outline-danger"
					onclick="location.href='/shop/user/deal/dealUserBuyerList.do'">
					내 거래 보기</button>
				<button class="btn btn-outline-danger"
					onclick="location.href='/shop/user/like/LikeUserList.do'">찜한상품</button>
			</div>
		</div>
		<div class="row px-md-5">
			<div class="mx-auto">
				<h3 class="m-3">
					<b> ${BuyerVO.nickname } 님 안녕하세요! </b>
				</h3>
				<p class="m-3">${BuyerVO.nickname }님은 ${BuyerVO.snscode } 계정으로
					로그인 중이십니다.</p>
			</div>
		</div>
		<div class="row m-3">
			<div class="col-lg-3 col-md-2 col-sm-1"></div>
			<div class="col-lg-6 col-md-8 col-sm-10 my-1 myList">
				<h4><b>장바구니 : </b></h4>
				<ol>
					<c:forEach var="basket" items="${myBasket }">
						<li class="m-2">
						<b>${basket.p_name }, </b>
						${basket.ba_q }개, 
						<fmt:formatNumber value="${basket.ba_q * basket.p_price }" pattern="#,###" />원
						</li>
					</c:forEach>
				</ol>
					<c:if test="${fn:length(myBasket) == 0 }">
						장바구니가 비었습니다.
					</c:if>
					<button class="float-right m-3 btn btn-outline-danger"
							onclick="location.href='/shop/user/basket/listBasketUser.do'">더 보기...</button>
			</div>
			<div class="col-lg-3 col-md-2 col-sm-1"></div>
		</div>
		<div class="row m-3">
			<div class="col-lg-3 col-md-2 col-sm-1"></div>
			<div class="col-lg-6 col-md-8 col-sm-10 myList">
				<h4><b>거래 : </b></h4>
				<ol>
					<c:forEach var="deal" items="${myDeal }">
						<li class="m-2">
						<b>${deal.p_name }, </b>
						${deal.d_ing }, 
						${deal.d_regdate }</li>
					</c:forEach>
				</ol>
					<c:if test="${fn:length(myDeal) == 0 }">
						<p class = "m-3">거래가 존재하지 않습니다.</p>
					</c:if>
					<button class="float-right m-3 btn btn-outline-danger"
							onclick="location.href='/shop/user/deal/dealUserBuyerList.do'">더 보기...</button>
			</div>
			<div class="col-lg-3 col-md-2 col-sm-1"></div>
		</div>
		<div class="row m-3">
			<div class="col-lg-3 col-md-2 col-sm-1"></div>
			<div class="col-lg-6 col-md-8 col-sm-10 myList">
				<h4><b>찜한 상품 : </b></h4>
				<ol>
					<c:forEach var="like" items="${myLike }">
						<li class="m-2">
						<b>${like.p_name }, </b>
						${like.l_regdate }
						</li>
					</c:forEach>
				</ol>
					<c:if test="${fn:length(myLike) == 0 }">
						찜한 상품이 없습니다.
					</c:if>
					<button class="float-right m-3 btn btn-outline-danger"
							onclick="location.href='/shop/user/like/LikeUserList.do'">더 보기...</button>
			</div>
			<div class="col-lg-3 col-md-2 col-sm-1"></div>
		</div>
	</div>

	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>