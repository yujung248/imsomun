<%--
  Class Name : EgovMainView.jsp
  Description : 메인화면
  Modification Information

      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2011.08.31   JJY       경량환경 버전 생성

    author   : 실행환경개발팀 JJY
    since    : 2011.08.31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
<%@ include file="./inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript">
<!--
	function fn_egov_select_productList(pageNo) {
		document.frm.pageIndex.value = pageNo;
		document.frm.action = "<c:url value='/shop/product/EgovMngMain.do'/>";
		document.frm.submit();
	}
	
//-->
$(document).ready(function(){
		$("#btnUpdate").click(function(){	
			location.href = "/shop/user/EgovProductListUpdate.do";
		});
	});
/* $(document).ready(function(){
	$("#btnInsert").click(function(){	
		location.href = "##insert";
	});
}); */
</script>
</head>
<body>
<%@ include file="./inc/EgovShopHeader.jsp" %>
<div class="container text-center">
	<h2>마켓 컬리</h2>
		<c:forEach items="${list}" var="result">
			<a>순번 : ${result.p_idx }</a> <p>
			<a>판매자 아이디 : ${result.s_id }</a> <p>
			<a>상품 이름 : ${result.p_name }</a> <p>
			<a>상품 가격 : ${result.p_price }</a> <p>
			
		</c:forEach>
	<div>
		<button id="btnUpdate" class="btn btn-primary">수정</button>
		<button id="btnInsert" class="btn btn-danger">작성</button>
	</div>
</div>
	<div class="container">
		<div id="paging_div">
			<ul class="paging_align">
				<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_productList" />
			</ul>
		</div>
	</div>

<%-- <%@ include file="./inc/EgovShopReview.jsp" %> --%>


	<!-- 테스트용 임시 링크 -->
	<div class="container text-center">
			<div class="row justify-content-center">
			<table border="1">
				<thead>
					<tr>
						<th><a href="/shop/buyer/listMngBuyer.do">구매자 관리</a></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><a href="/shop/user/review/reviewList.do">리뷰 페이지</a></td>
					</tr>
					<tr>
					<td><a href="/shop/mng/basket/basketList.do">장바구니 관리</a></td>
					</tr>
					<tr>
					<td><a href="/shop/user/snsprofile/loginUserSnsprofileTestForm.do">구매자 로그인 테스트</a></td>
					</tr>

					<!-- <tr>
					<td><a href="#">### 관리</a></td>
					<td><a href="#">### 관리</a></td>
					<td><a href="#">### 관리</a></td>
					</tr> -->
				</tbody>
			</table>
		</div>
	</div>
	<!-- <a href="/shop/mng/buyer/listMngBuyer.do">구매자 관리</a><br/>
	<a href="/shop/mng/basket/listMngBasket.do">장바구니 관리</a><br/>
	<a href="/shop/mng/review/reviewList.do">리뷰 페이지</a> -->
</body>
</html>