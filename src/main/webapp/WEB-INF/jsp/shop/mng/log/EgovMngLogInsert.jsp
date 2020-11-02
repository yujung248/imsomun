<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>
<body>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<div class="container">
		<div class="row">
			<form class="mx-auto" action="/shop/mng/log/insertMngLogPro.do" method="post" >
				<table class="table">		
					<tr> 
						<th>판매자 아이디</th>
						<td><input type="text" id="s_id" 	name="s_id"></td>
					</tr>
					<tr> 
						<th>구매자 아이디</th>
						<td><input type="text" id="sns_idx" name="sns_idx"></td>
					</tr>
					<tr> 
						<th>활동 페이지</th>
						<td><input type="text" id="ac_page" name="ac_page"></td>
					</tr>
					<tr>
						<th>활동 내역</th>
						<td><input type="text" id="ac_spec" name="ac_spec"></td>
					</tr>
					<tr>
						<th>IP 주소</th>
						<td><input type="text" id="log_ip" name="log_ip"></td>
					</tr>				
					<tr>
						<th>등록일</th>
						<td><!-- <input type="date" id="log_date" name="log_date"> --></td>
					</tr>
				</table>
				<input type="submit" id="submitButton" value="등록" /> 
				<input type="button" value="목록으로" onclick="location.href='/shop/mng/log/EgovMngLogList.do'" />
			</form>
		</div>
	</div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>