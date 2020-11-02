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
function login() {
	location.href = "<c:url value='/shop/user/EgovUserLoginForm.do'/>";
}
function passwd() {
	location.href = "<c:url value='/shop/user/seller/sellerFindPass.do?s_id=${s_id}'/>";
}
</script>
</head>
<body>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
<form>
<div class="container" style="text-align:center; margin-top: 20px">
		<div class="box6" >
			가입한 아이디는 : 
			<span id="s_id" name="s_id"> ${s_id }</span>
			입니다.
		</div><br>
		<!-- 버튼 영역 -->
		<div class="btn_area">
			
			<a href="#" type="button" onclick="login();" class="btn btn-secondary" ><span class="blind">로그인하기</span></a>
			<a href="#" onclick="passwd();" class="btn btn-secondary"><span class="blind">비밀번호 찾기</span></a>
		</div>
</div>
</form>
<%@ include file="../../../inc/EgovShopBottom.jsp"%>
</body>
</html>