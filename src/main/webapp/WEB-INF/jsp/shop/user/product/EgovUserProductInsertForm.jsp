<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>판매자 등록 페이지</title>
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

<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>

<h3 style="text-align: center">등록 페이지</h3> 

  <div class="container-fluid">
	<div class="container text-center" style="padding-top: 20px;">
	    <div class="row">
			<form class="mx-auto" action="/shop/user/product/EgovUserProductInsertPro.do" method="post" enctype="multipart/form-data">
						<p>
					<input type="hidden" name="s_id" id="s_id">
					<input type="hidden" name="p_status" value="Y">
					<table class="table" style="text-align: left">
					<tr>
						<th></th>
						<td height="200" style=""><img class="img-fluid" id="blah" src="#" alt="your image" width="200" height="200" /></td>    				
						</tr>
						<tr>
					 <tr>
					 <tr>
						<th>파일업로드</th>	
						<td><label for="ex_file">업로드</label>
							<input type='file' name="file" id="ex_file" onchange="readURL(this);" /></td>    
					</tr>
						<th>상품명</th>
						<td>
						<input type="text" name="p_name" id="p_name"/>
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>
						<input type="text" name="p_price" id="p_price"/>
						</td>
					</tr>
					<tr>
						<th>제품 내용</th>
						<td>
						<textarea rows="7" cols="50" name="p_content" id="p_content"></textarea>
						</td>
					</tr>
					<tr>
						<th>해시태그</th>
						<td>
						<input type="text" name="p_tage" id="p_tage" />
						</td>
					</tr>
					<tr>
						<th>판매시작일</th>
						<td>
						<input type="date" name="p_sdate" id="p_sdate" />
						</td>
					</tr>
					<tr>
						<th>판매종료일</th>
						<td>
						<input type="date" name="p_edate" id="p_edate" />
						</td>
					</tr>
					<tr>
						<th>재고 수량</th>
						<td>
						<input type="text" name="p_q" id="p_q"/>
						</td>
					</tr>  
					<tr> 
						<td colspan="2" style="text-align: center"><br/>
						<input type="submit" value="등록완료" class="btn btn-primary" /> &nbsp;	
						<input type="button" value="이전으로" class="btn btn-info" onclick="location.href='/shop/user/product/EgovUserProductlist.do'"/>		
						</td>
					</tr>
				</table>
					<%-- <c:if test=""></c:if> --%>
				</form>				
			</div>
		</div>
	</div>

<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>