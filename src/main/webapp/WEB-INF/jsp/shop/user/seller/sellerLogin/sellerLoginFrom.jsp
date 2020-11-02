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
<%@ include file="../../../inc/EgovShopTop.jsp" %>
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
</script>
</head>
<body>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
<form action="<c:url value='/shop/user/seller/EgovsellerLoginPro.do'/>">
	<div class="container" style="text-align:center; margin-top: 20px">
		<h2>로그인</h2>
	    <div>
	      <!-- <label>아이디</label><p> -->
	      <input class="form-control" name="id" id="id" type="text" placeholder="아이디" />
	    </div><br>
	    <div>
	     <!--  <label>비밀번호</label><p> -->
	      <input class="form-control" name="passwd" id="passwd" type="password" placeholder="비밀번호" />
	    </div><br>
	    <button class="btn btn-secondary" type="submit" style="width: 100%">로그인</button>
	 </div><br>
</form>
<div class="container" style="text-align:center;">
	<div class="find_info align_center">
		<a target="_blank" id="idinquiry" href="<c:url value='/shop/user/seller/sellerIdAgreeFrom.do'/>">아이디 찾기</a> <span class="bar" aria-hidden="true">|</span> 
		<a target="_blank" id="pwinquiry" href="<c:url value='/shop/seller/sellerIdCheckFrom.do'/>">비밀번호 찾기</a> <span class="bar" aria-hidden="true">|</span> 
		<a target="_blank" id="join" href="<c:url value='/shop/user/seller/sellerinsert.do'/>">회원가입</a>
	</div>
</div>	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
<%-- <div class="container text-center">
	<h2>마켓 컬리</h2>
		<c:forEach items="${list}" var="result">
			<a>상품 : ${result.p_idx }</a> <p>
		</c:forEach>
</div>
	<div id="paging_div">
		<ul class="paging_align">
			<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_productList" />
		</ul>
	</div> --%>

</body>
</html>