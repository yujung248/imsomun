<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ page import="egovframework.let.shop.mng.product.service.impl.ProductMngVO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>운영자 상품 리스트 수정</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
function readURL(input) {
if (input.files && input.files[0]) {
var reader = new FileReader();
reader.onload = function (e) {
$('#blah').attr('src', e.target.result);
}
reader.readAsDataURL(input.files[0]);
}
}
</script>
<style type="text/css">
label {
  display: inline-block;
  padding: .5em .75em;
  color: #fff;
  font-size: inherit;
  line-height: normal;
  vertical-align: middle;
  background-color: #6c757d;
  cursor: pointer;
  border: 1px solid #6c757d;
  border-radius: .25em;
  -webkit-transition: background-color 0.2s;
  transition: background-color 0.2s;
}

label:hover {
  background-color: #5a5a5a;
}

label:active {
  background-color: #5a5a5a;
}

input[type="file"] {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  border: 0;
}
</style>
</head>
<script type="text/javascript">
	function upload(p_idx) {
		document.frm.action = "/shop/user/basket/insertBasketUserPro.do";
		document.frm.submit();
	}
</script>
<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<h3 style="text-align: center">수정 페이지</h3>

	<c:if test="${msg != null }">
	<p>${msg }</p>
	</c:if>
	<c:if test="${msg = null }">
	</c:if>
	
 <div class="container-fluid">

	    <div class="row">
			<form name="frm" class="mx-auto" action="/shop/mng/product/EgovMngProductUpdatePro.do" method="post" enctype="multipart/form-data">
	    			<input type="hidden" name="p_idx" value="${ProductMngVO.p_idx }" />
	    			<input type="hidden" name="preImage" value="${ProductMngVo.preImage }">
	    			<input type="hidden" name="pageIndex" value="${searchVO.pageIndex }">
	    			<input type="hidden" name="searchCnd" value="${searchVO.searchCnd }">
	    			<input type="hidden" name="searchWrd" value="${searchVO.searchWrd }">
					<table class="table" style="text-align: left">
					<tr>
						<th></th>
						<td height="200" style="">
						<img class="img-fluid" id="blah" src="<c:url value='/'/>file/${ProductMngVO.p_image}" alt="your image" width="200" height="200" /> </td> 
					</tr>
					<tr>
						<th>사진변경</th>	
							<td><label for="ex_file">업로드</label>
							<input type='file' name="file" id="ex_file" onchange="readURL(this);" /></td>    
					</tr>
					<tr>
						<th>상품명</th>
						<td><input type="text" name="p_name" value="${ProductMngVO.p_name }"/>
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="p_price" value="${ProductMngVO.p_price }"/></td>
					</tr>
					<tr>
						<th>제품 내용</th>
						<td>
						<textarea rows="5" cols="50" name="p_content" id="p_content">${ProductMngVO.p_content } </textarea></td>
					</tr>
					<tr>
						<th>해시태그</th>
						<td><input type="text" name="p_tage" value="${ProductMngVO.p_tage }"/></td>
					</tr>
					<tr>
						<th>재고 수량</th>
						<td><input type="text" name="p_q" value="${ProductMngVO.p_q }"/></td>
					</tr>
					<tr>
						<th>판매시작일</th>
						<td><input type="date" name="p_sdate" value="${ProductMngVO.p_sdate }"/></td>
					</tr>
					<tr>
						<th>판매종료일</th>
						<td><input type="date" name="p_edate" value="${ProductMngVO.p_edate }"/></td>
					</tr>
					<tr>
						<th>업데이트된 날짜</th>
						<td><input type="date" name="p_moddate" value="${ProductMngVO.p_moddate }"/></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center">
						<input type="submit" value="수정완료" class="btn btn-primary"> &nbsp;
						<input type="button" value="이전으로" class="btn btn-info" onclick="return1();"/>
					</tr>
				</table>
					<%-- <c:if test=""></c:if> --%>
				</form>			
			</div>
		</div>
	</div>
<script>
function return1(){
	document.forms["frm"].action = "/shop/mng/product/EgovMngProductlist.do";
	document.forms["frm"].submit();
	return true;
}
</script>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>