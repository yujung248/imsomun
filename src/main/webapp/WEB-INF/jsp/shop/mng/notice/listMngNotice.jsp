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

</head>

<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
		<h2 class="text-center">
				<strong>NOTICE</strong>
			</h2>
	<div class="container">
			<div class="float-right mt3">
		 <input type="button"  class="btn btn-outline-danger" value="공지등록" onclick="location.href='/shop/mng/notice/insertMngNoticeForm.do'"> 
		</div>
	<form action="/shop/mng/notice/listMngNotice.do">
		<table class="table mx-auto">
			<tr>
				<th>공지번호</th>
				<th>구분</th>
				<th>제목</th>
				<th>내용</th>
				<th>등록일</th>
				<th>운영자 ID</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${list }" var="notice_list" varStatus="status">
				<tr>
					<td>${notice_list.n_idx }</td>
					<td>${notice_list.n_div }</td>
					<td>${notice_list.n_sub }</td>
					<td>${notice_list.n_content }</td>
					<td>${notice_list.n_date }</td>
					<td>${notice_list.a_id }</td>
					<td><input class="btn btn-secondary" type="button" value="수정"  onclick="location.href='/shop/mng/notice/updateMngNoticeForm.do?n_idx=${notice_list.n_idx}'"></td>				
					<td><input class="btn btn-danger" type="button" value="삭제"  onclick="location.href='/shop/mng/notice/deleteMngNotice.do?n_idx=${notice_list.n_idx}'"></td>				
				</tr>
			</c:forEach>
		</table>
	</form>
		</div>
	
			<div class="mx-auto" id="paging_div">
		<form name="frmPage" id="frmPage" action="/shop/mng/notice/listMngNotice.do">
			<ul class="paging_align">	
				<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage" />
			</ul>
			<input type="hidden" name="searchWrd" value="${searchVO.searchWrd }" />
		</form>
	</div>
	
	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
<script>

</script>
</html>