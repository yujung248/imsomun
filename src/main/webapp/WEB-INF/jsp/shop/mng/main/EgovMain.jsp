<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
  <h2>메인 화면 입니다.</h2>
  <!-- 테스트용 임시 링크 -->
	<div class="container text-center">
			<div class="row justify-content-center">
			<table border="1">
				<thead>
					<tr>
						<th><a href="/shop/mng/buyer/listMngBuyer.do">구매자 관리</a></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><a href="/shop/user/review/reviewList.do">리뷰 페이지</a></td>
					</tr>
					<tr>
					<td><a href="/shop/mng/basket/listMngBasket.do">장바구니 관리</a></td>
					</tr>
					<tr>
					<td><a href="/shop/user/snsprofile/loginUserSnsprofileTestForm.do">구매자 로그인 테스트</a></td>
					</tr>
					<tr>
					<td><a href="/shop/mng/seller/listMngSeller.do">판매자 관리</a></td>
					<td><a href="/shop/mng/admin/listMngAdminControl.do">운영자관리</a>
					</tr>
					<tr>
					<td><a href="/shop/mng/product/EgovMngProductlist.do">상품 관리</a></td>
					</tr>
					<tr>
					<td><a href="/shop/user/seller/sellerUserMain.do">판매자 페이지</a></td>
					</tr>
					<!-- <tr>
					<td><a href="#">### 관리</a></td>
					<td><a href="#">### 관리</a></td>
					<td><a href="#">### 관리</a></td>
					</tr> -->
				</tbody>
			</table>
		</div>
	</div>
  
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>