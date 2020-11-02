<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%-- <%@ page import ="egovframework.com.cmm.LoginVO" %> --%>
<%@ page import="egovframework.let.shop.mng.review.service.ReviewMngVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<%@ include file="../../inc/EgovShopHeader.jsp"%>
<p class="h-25"/>
<div class="container text-center">
	<div class="row justify-content-center">
	<h1>후기관리</h1> 
		<table class="table table-hover">
				<tr>
					<!-- <th><a href="/shop/mng/review/miniGame.do">미니게임</a></th>
					<th><a href="/shop/mng/review/daumMap.do">다음 지도</a></th> -->
				</tr>
				<tr>
					<td><a href="/shop/mng/review/MngSelect.do"><p class="font-weight-bold"><span style="color: black;">판매자 리뷰</span></p> <i class="fas fa-wallet" style="font-size: 250px;"></i></a></td>
					<td></td><td></td>
					<td><a href="/shop/mng/review/MngUserSelect.do"><p class="font-weight-bold"><span style="color: black;">구매자 리뷰</span></p><i class="fas fa-shopping-cart" style="font-size: 250px;"></i></a></td>
				</tr>
		</table>
	</div>
</div>
</body>
</html>