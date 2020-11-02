<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import="egovframework.let.shop.mng.review.service.ReviewMngVO"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>리뷰 관리 페이지</title>
</head>
<script type="text/javascript">
	function delReview() {
		/* alert(document.frm.chk.length); */
		document.frm.action="/shop/mng/review/delMngReview.do";
		document.frm.submit();
	}
	function reReview() {
		document.frm.action="/shop/mng/review/reMngReview.do";
		document.frm.submit();
	}
</script>
<body>
<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
			<div class="row" style="padding-left: 35%;">
				<form class="form-inline" action="/shop/mng/review/MngSelect.do">
					  <input type="hidden" id="searchCnd" name="searchCnd" value="0">
					  <input class="form-control mr-sm-2" id="searchWrd" name="searchWrd" type="text" placeholder="Search" style="width:400px">
					  <button class="btn btn-success" type="submit">Search</button>&nbsp;
				</form>
			</div>
	<div class="container text-center">
		<div class="row justify-content-center">
			<h1>판매자 리뷰관리</h1>
					<form method="post" name="frm">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>리뷰 번호</th>
									<th>상품 이름</th>
									<th>판매자 닉네임</th>
									<th>판매자 리뷰</th>
									<th>판매자리뷰 등록일자</th>
									<th>리뷰 삭제 여부</th>
									<th>리뷰 삭제 하기</th>
									<th>리뷰 복구 하기</th>
								</tr>
							</thead> 
						<c:forEach var="result" items="${list }" varStatus="i">
						<c:choose>
							<c:when test="${result.r_div eq 1}">
							<tbody>
								<tr>
									<td>${result.r_idx }</td>
									<td>${result.p_name }</td>
									<td>${result.nickname }</td>
									<td>${result.r_content }</td>
									<td>${result.r_regdate }</td>
									<td>${result.r_delyn }</td>
									<td><input type="checkbox" name="chk" id="chk" value="${result.r_idx }"></td>
									<td><input type="checkbox" name="rechk" id="rechk" value="${result.r_idx }"></td>
								</tr>
							</tbody>
							</c:when>
								<c:otherwise>
									
								</c:otherwise>
							</c:choose>	
						</c:forEach>
								<tr>
									<td colspan="6"></td>
									<td><input type="button" value="삭제" onclick="delReview();"></td>
									<td><input type="button" value="복구" onclick="reReview();"></td>
								</tr>
					</table>
				</form>
				<div id="paging_div">
				<ul class="paging_align">
					<ui:pagination paginationInfo="${paginationInfo}" type="image"
						jsFunction="linkPage" />
				</ul>
			</div>
			
	</div>
</div>
<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>