<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<script type="text/javascript">
	$("#btnUpdate").click(function(){
		var title = $("#title").val();
		
	})
</script>
</head>
<body>
<%@ include file="./inc/EgovShopHeader.jsp" %>
<h2>상품 상세</h2>
<form action="" name="product" method="post" enctype="multipart.#######">
	<div>
		작성일자: <fmt:formatDate value="${list.p_regdate }" pattern="yyyy-mm-dd a HH:mm:ss"/>
	</div>
	<div>
		작성자
		<input type="text" name="sellerName" id="sellerName" value="${list.s_id }">
	</div>
	<div>
		제목
		<input type="text" name="title" id="title" size="80" value="${list.p_name }">
	</div>
	<div>
		내용 
		<input type="text" name="content" id="content" rows="4" cols="80" value="${list.p_content }">
	</div>
	<div>
		사진
		<input type="file" name="picture" id="picture">
	</div>
	<div>
		상태
		<input name="status" id="status" value="${list.p_status }">
	</div>
	<button type="button" id="btnUpdate">수정</button>
	<!-- <button type="button" id="btnDelete">삭제</button> -->
</form>
	
</body>
</html>