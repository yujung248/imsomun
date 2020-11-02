<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
<%-- <%@ include file="./inc/EgovShopTop.jsp" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-language" content="ko">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%@ include file="./inc/EgovShopHeader.jsp" %> --%>
	<c:forEach items="${list}" var="result">
		<a>아이디 : ${result.s_id }</a>
		<p>
		<a>닉네임 : ${result.s_nickname }</a>
		<p>
		<a>이메일 : ${result.s_email }</a>
		<p>
		<a>사진 : ${result.s_photo }</a>
		<p>
		<a>전화번호: ${result.s_phone }</a>
		<p>
		<a>주소 : ${result.s_addr }</a>
		<p>
	</c:forEach>
</body>
</html>