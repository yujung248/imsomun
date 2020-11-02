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
	location.href = "<c:url value='/shop/seller/EgovsellerFindId.do'/>";
}
</script>
</head>
<body>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>

<div class="container"	style="text-align:center;">
	<div class="container" style="text-align:left;margin-left: 300px">
		<p class="dsc">본인확인 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.</p>	
		<dl>
			<dt><label for="emailNm" class="label_txt">이름</label></dt>
			<dd><input type="text" id="emailNm" name="emailNm" maxlength="40" class="input_txt" style="width:217px"></dd>
			<dt><label for="email" class="label_txt">이메일 주소</label></dt>
			<dd>
				<input type="text" id="email" name="email" maxlength="100" class="input_txt" style="width:217px">
				<a href="#" id="btnEmailAuthNo" name="btnEmailAuthNo" onClick="sendAuthNoForEmailAuth();clickcr(this,'eml.code','','',event);" class="btn_ct"><span class="blind">인증번호 받기</span></a>
			</dd>
			<dt><label for="t_ct1" class="blind">인증번호 입력</label></dt>
			<dd class="ct">
				<span class="input_box2">
				<span id="span_emailAuthNo" class="phold" style="">인증번호 6자리 숫자 입력</span>
				<input type="text" id="emailAuthNo" name="emailAuthNo" maxlength="6" onkeydown="check_num('emailAuthNo', '1')" onClick="hiddenObj('span_emailAuthNo')" class="input_txt" style="width:217px" disabled>
				</span>								
			</dd>	
		</dl>
	</div>
	<button class="btn btn-secondary" type="submit" onclick="check();">다음</button>		
</div>
</body>
</html>