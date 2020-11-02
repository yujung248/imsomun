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
</script>
</head>
<body>
<%@ include file="./inc/EgovShopHeader.jsp" %>
<c:forEach items="${list}" var="result">
	${result.m_id2 }
	${result.s_email}
	${result.m_phone }
</c:forEach>
	<div id="paging_div">
		<ul class="paging_align">
			<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_productList" />
		</ul>
	</div>
</body>
</html>