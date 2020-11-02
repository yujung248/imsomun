<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
<%@ include file="../inc/EgovShopHeader.jsp" %>


<div class="container-fluid">
		<div class="container text-center">
			<h3>${keyword} 검색 결과 </h3>
			<div class="row">
				<c:forEach var="productuser_list" items="${list2}">
					<div class="col-3">
						<a href="/shop/user/product/EgovBuyerProductForm.do?p_idx=${productuser_list.p_idx }">
						<img src="<c:url value='/'/>file/${productuser_list.p_image}" width="270" height="270" class="rounded"/> </a>
						<input type="hidden" value="${productuser_list.p_idx }">
							<br/> <span>${productuser_list.p_name }</span> 
							<br/> <span><fmt:formatNumber value="${productuser_list.p_price }" pattern="##,###"></fmt:formatNumber></span>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
<%@ include file="../inc/EgovShopBottom.jsp" %>
</body>
</html>