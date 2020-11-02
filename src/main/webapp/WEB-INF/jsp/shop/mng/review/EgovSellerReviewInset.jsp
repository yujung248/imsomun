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
<title>판매자 리뷰작성</title>
</head>
<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<c:if test="${sessionScope.status == 0 }"><!-- 운영자 -->
	<form action="/shop/user/review/insertSellerReview2.do" name="frm2" method="post" enctype="multipart/form-data">
		<div class="container text-center">
			<div class="row justify-content-center">
			<h2>판매자 리뷰작성페이지입니다.</h2>
					<input type="hidden" id="s_id" name="s_id" value="${dealUserVO.s_id}">
					<input type="hidden" id="p_idx" name="p_idx" value="${dealUserVO.p_idx }">
					<input type="hidden" id="r_div" name="r_div" value="0">		<!-- 판매자 -->
						<textarea rows="3" cols="80" name="r_content" id="r_content"></textarea>
					<input type="file" name="file" id="file">
				<div class="custom-control custom-radio custom-control-inline">
					<input type="radio" name="sns_score" id="customRadio1" value="1"><p>1점</p>
					<input type="radio" name="sns_score" id="customRadio1" value="2"><p>2점</p>
					<input type="radio" name="sns_score" id="customRadio1" value="3"><p>3점</p>
					<input type="radio" name="sns_score" id="customRadio1" value="4"><p>4점</p>
					<input type="radio" name="sns_score" id="customRadio1" value="5"><p>5점</p>
				</div>
					<input type="submit" value="저장" class="btn btn-primary">
			</div>
		</div>
	</form>
</c:if>

<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>