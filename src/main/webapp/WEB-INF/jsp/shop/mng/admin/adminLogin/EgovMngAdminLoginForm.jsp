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
<c:if test="${chk == 0}">
		<script type="text/javascript">
			$(document).ready(function(){
				$("#updateModal").modal('show')
			
			})
		</script>
		<!-- Modal -->
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">로그인 실패.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
<form action="<c:url value='/shop/mng/admin/EgovMngAdminLoginPro.do'/>">
	<div class="container" style="text-align:center; margin-top: 20px">
		<h2>관리자 로그인</h2>
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
</body>
</html>