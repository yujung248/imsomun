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
function check() {
	location.href = "<c:url value='/shop/seller/sellerIdCheckFrom2.do'/>";
}
</script>
</head>
<body>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
</body>
<form id="fm" name="fm" action="/user2/help/pwInquiry.nhn?m=actionInputUserId" method="post">
		<div id="content" class="non_sign inquiry">
			<div class="content_header">
				<h2><img src="https://static.nid.naver.com/images/web/user/h_find_pw2.gif" width="84" height="16" alt="비밀번호 찾기"></h2>
				<ol class="process">
				<li class="on">01. 아이디 입력<span>&gt;</span></li>
				<li>02. 본인 확인<span>&gt;</span></li>
				<li>03. 비밀번호 재설정</li>
				</ol>
			</div>
			<p class="content_summary">비밀번호를 찾고자 하는 아이디를 입력해 주세요.</p>
			<div class="section section_find">
				<div class="box6">
					<div id="divUserId" class="input_box">	
						<label id="lbUserId" for="userId">네이버 아이디 또는 단체 아이디</label>			
						<input type="text" id="userId" name="userId" onFocus="convertDiv('lbUserId', 'divUserId', 'userId', 'none')" onBlur="convertDiv('lbUserId', 'divUserId', 'userId', 'block')" maxlength="40" value="" title="네이버 아이디 또는 단체 아이디" class="input_txt">
					</div>
				</div>
				<div class="btn_area">
					<a href="#" onclick="check();" class="btn_next2"><span class="blind">다음</span></a>
				</div>
			</div>
			 
		</div>
		<hr>
</form>	
</html>