<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>

	<div class="container">
		<div class="row">


			<table class="table mx-auto">
				<tr>
					<th>SNS 번호</th>
					<th>유저 아이디</th>
					<th>SNS 코드</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>등록일자</th>
					<th>상태</th>
					<th>상태 변경</th>
				</tr>
				<c:forEach items="${list }" var="sns_list" varStatus="status">
					<tr>
						<td><a
							href="/shop/mng/buyer/updateMngBuyerForm.do?sns_idx=${sns_list.sns_idx }">${sns_list.sns_idx }</a></td>
						<td>${sns_list.userid }</td>
						<td>${sns_list.snscode }</td>
						<td>${sns_list.nickname }</td>
						<td>${sns_list.email }</td>
						<td>${sns_list.reg_date }</td>
						<td>${sns_list.del_yn }</td>
						<td><input type="submit" value="전환"
							form="frm${status.index }" /></td>
					</tr>
				</c:forEach>
			</table>
			<c:forEach items="${list }" var="sns_list" varStatus="status">
				<form id="frm${status.index }" action="updateSellerStateChange.do">
					<input type="hidden" name="sns_idx" value="${sns_list.sns_idx }">
					<input type="hidden" name="pageIndex"
						value="${paginationInfo.currentPageNo }">
				</form>
			</c:forEach>
			
			<div id="paging_div">
				<ul class="paging_align">
					<ui:pagination paginationInfo="${paginationInfo}" type="image"
						jsFunction="fn_egov_select_productList" />
				</ul>
			</div>
		</div>
	</div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>