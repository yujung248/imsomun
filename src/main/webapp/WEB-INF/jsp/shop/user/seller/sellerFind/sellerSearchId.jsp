<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	// 취소
	$("#cencle").on("click", function(){
	$("form").attr("action", "/shop/user/EgovUserLoginForm.do");
	})
	
	$("#submit").on("click", function(){
	
	});
})
</script>
</head>

<body>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
<c:if test="${msg != null }">

	</c:if>
	<c:if test="${msg = null }">
	</c:if>
<form action="/shop/user/seller/sellerSearchIdPro.do">
	<div class="container" style="margin-top: 20px">
		<div class="box6" >
			아이디를 입력하시요.<br><br>
			<input class="form-control" type="text" name=s_id><br>
			<input class="btn btn-secondary" type="submit" value="다음">
			<input class="btn btn-secondary" type="submit" id="cencle" value="취소">
		</div><br>
	</div>
</form>
 
<%@ include file="../../../inc/EgovShopBottom.jsp" %>
</body>
</html>