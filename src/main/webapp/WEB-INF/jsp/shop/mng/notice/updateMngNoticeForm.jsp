<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<%@ page import="egovframework.let.shop.mng.notice.service.impl.NoticeMngVO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>

<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
			<h2 class="text-center">
				<strong>NOTICE</strong>
			</h2>
	
	<div class="container">
		<div class="row">
	<form name="frm" class="mx-auto" action="/shop/mng/notice/updateMngNoticePro.do?n_idx=${NoticeMngVO.n_idx }" method="post">
		
		<table class="table">
			<tr>
				<th>공지번호</th>
				<td>${NoticeMngVO.n_idx }</td>
			</tr>
			<tr>
				<th>구분</th>
				<td><input type="text" name="n_div" value="${NoticeMngVO.n_div }"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="n_sub" value="${NoticeMngVO.n_sub }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" name="n_content">${NoticeMngVO.n_content }</textarea>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${NoticeMngVO.n_date }</td>
			</tr>		
			<tr>
				<th>운영자 ID</th>
				<td>${NoticeMngVO.a_id }</td>
			</tr>	
				<th></th>
				<td><input type="submit"  class="btn btn-primary"   value="수정" /> 
					<input type="button"  class="btn btn-secondary" value="목록으로" onclick="location.href='/shop/mng/notice/listMngNotice.do'" >
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>