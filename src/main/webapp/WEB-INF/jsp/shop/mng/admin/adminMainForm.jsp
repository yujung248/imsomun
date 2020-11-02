<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">
</head>
<style>
	.material-icons{
		font-size: 140px;
		font-family: Nanum Gothic Coding', monospace;
		text-align: center;
	}

</style>
<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>	
		<h2 class="text-center">
				<strong>Admin Page</strong>
			</h2>
			<p><p>
			<div class="container">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/mng/product/EgovMngProductlist.do">			
					<i class="material-icons" >card_giftcard</i>
					</a>
					</div>
					<b>상품 관리</b>
			</div>
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/mng/basket/listMngBasket.do">			
					<i class="material-icons" >shopping_cart</i>
					</a>
					</div>
					<b>장바구니 관리</b>
			</div>
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/mng/buyer/listMngBuyer.do">			
					<i class="material-icons" >directions_run</i>
					</a>
					</div>
					<b>구매자 관리</b>
			</div>
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/mng/seller/listMngSeller.do">			
					<i class="material-icons" >directions_walk</i>
					</a>
					</div>
					<b>판매자 관리</b>
			</div>
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/mng/admin/adminControl/listMngAdminControl.do">	
					<i class="material-icons" >transfer_within_a_station</i>
					</a>
					</div>
					<b>운영자 관리</b>
			</div>
			</div>
			<div class="row">
			<div class="col-1"></div>
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/mng/log/EgovMngLogList.do"> 		
					<i class="material-icons" >insert_drive_file</i>
					</a>
					</div>
					<b>로그 페이지</b>
			</div>
			
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/user/review/reviewList.do">		
					<i class="material-icons" >thumbs_up_down</i>
					</a>
					</div>
					<b>리뷰 페이지</b>
			</div>
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/mng/review.do">			
					<i class="material-icons" >person_search</i>
					</a>
					</div>
					<b>관리자 리뷰 페이지</b>
			</div>
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/mng/notice/listMngNotice.do"> 			
					<i class="material-icons" >notifications_active</i>
					</a>
					</div>
					<b>공지사항 관리</b>
			</div>
			<div class="col-2 text-center"> 
					<div class="">
					<a href="/shop/mng/deal/dealMngList.do"> 		
					<i class="material-icons" >store</i>
					</a>
					</div>
					<b>거래 관리</b>
			</div>
			</div>
			</div>
	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>
