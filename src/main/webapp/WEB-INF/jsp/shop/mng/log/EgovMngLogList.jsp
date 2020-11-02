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
<title>회원 로그 페이지</title>
<script type="text/javascript"
	src="https://developers.kakao.com/sdk/js/kakao.min.js">
	
</script>
</head>
<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
	<form action="/shop/mng/log/EgovMngLogList.do">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="아이디"
				aria-label="Username" aria-describedby="basic-addon1"
				name="searchWrd">
			<div class="input-group-append">
				<input class="btn btn-secondary" type="submit" value="검색" />
			</div>
		</div>
		<select name="searchCnd">
			<option value="0">판매자</option>
			<option value="1">구매자</option>			
		</select>
	</form>
	<form action="/shop/mng/log/EgovMngLogList.do">
		<table border="soild">
			<tr>
				<th>등록 번호</th>
				<th>판매자 아이디</th>
				<th>구매자 아이디</th>
				<th>닉네임</th>
				<th>활동 내역</th>
				<th>활동 페이지</th>
				<th>IP 주소</th>
				<th>등록일</th>
			</tr>
			<c:forEach items="${list }" var="mlog_list" varStatus="status">
				<tr>
					<td>${mlog_list.log_idx }</td>
					<td>${mlog_list.s_id }</td>
					<td>${mlog_list.sns_idx }</td>
					<td>${mlog_list.nickname }</td>
					<td>${mlog_list.ac_page }</td>
					<td>${mlog_list.ac_spec }</td>
					<td>${mlog_list.log_ip }</td>
					<td>${mlog_list.log_date }</td>
				</tr>
			</c:forEach>
		</table>
	</form>

	<div id="paging_div">
		<form name="frmPage" id="frmPage" action="/shop/mng/log/EgovMngLogList.do">
			<ul class="paging_align">	
				<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage" />
			</ul>
			<input type="hidden" name="searchWrd" value="${searchVO.searchWrd }" />
		</form>
	</div>
		<input type="button" value="입력" onclick="location.href='/shop/mng/log/insertMngLogForm.do'">
		
	
	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>