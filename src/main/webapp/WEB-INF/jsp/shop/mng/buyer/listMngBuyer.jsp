<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
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
					<th>로그인</th>
				</tr>
				<c:forEach items="${list }" var="sns_list" varStatus="status">
					<tr>
						<td><a
							href="/shop/mng/buyer/updateMngBuyerForm.do?sns_idx=${sns_list.sns_idx }">${sns_list.sns_idx }</a></td>
						<td>${sns_list.userid }</td>
						<td>${sns_list.snscode }</td>
						<td>${sns_list.nickname }</td>
						<td>${sns_list.email }</td>
						<fmt:formatDate var="dateTempFmt" value="${sns_list.reg_date }" pattern="yyyy.MM.dd. HH:mm:ss"/>
						<td><c:out value="${dateTempFmt}"></c:out></td>
						<td>${sns_list.del_yn }</td>
						<td><input class="btn btn-danger" type="submit" value="전환"
							form="frm${status.index }" /></td>
						<td><input class="btn btn-secondary" type="button" value="로그인" onclick="location.href='/shop/mng/snsprofile/loginMngSnsprofilePro.do?sns_idx=${sns_list.sns_idx}'" /></td>
					</tr>
				</c:forEach>
			</table>
			<c:forEach items="${list }" var="sns_list" varStatus="status">
				<form id="frm${status.index }" action="updateMngBuyerStateChange.do">
					<input type="hidden" name="sns_idx" value="${sns_list.sns_idx }">
					<input type="hidden" name="pageIndex"
						value="${paginationInfo.currentPageNo }">
				</form>
			</c:forEach>
			<form name="frmPage" action="/shop/mng/buyer/listMngBuyer.do">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<select class="form-control bg-white text-dark" name="searchCnd">
							<option value="0">아이디</option>
							<option value="1">닉네임</option>
							<option value="2">이메일</option>
						</select>
					</div>
					<input type="text" class="form-control" placeholder="검색어"
						aria-label="Username" aria-describedby="basic-addon1"
						name="searchWrd" value="${searchVO.searchWrd }"> 
					<div class="input-group-append">
						<input class="btn btn-secondary" type="submit" value="검색" />
					</div>
				</div>
			 <input type="hidden" name="pageIndex" value="1" />
		
			</form>
			<div id="paging_div">
				<ul class="paging_align">
					<ui:pagination paginationInfo="${paginationInfo}" type="image"
						jsFunction="linkPage" />
				</ul>
			</div>
		</div>
	</div>

<script>
function linkPage(pageIndex){
	document.forms["frmPage"]["pageIndex"].value=pageIndex;
	document.forms["frmPage"].submit();
	return true;
}
</script>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>