<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
</head>
<body>
	<%@ include file="../../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../../inc/EgovShopHeader.jsp"%>
	<div class="container">
		<div class="row">
			<h2 class="mx-auto">운영자 등록</h2> 
		</div>
		
		<c:if test="${msg != null}">
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
					<div class="modal-body">${msg }</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
		
		
		<div class="row">
			<form class="mx-auto"
				action="/shop/mng/admin/adminControl/insertMngAdminControlPro.do"
				name="frm2" method="post">
				<table class="table">
					<tr>
						<th>아이디</th>
						<td><input class="form-control" type="text" name="a_id"
							value="${AdminVO.a_id }"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input class="form-control" type="text" name="a_pass"
							value="${AdminVO.a_pass }"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input class="form-control" type="text" name="a_email"
							value="${AdminVO.a_email }"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input class="form-control" type="text" name="a_name"
							value="${AdminVO.a_name }"></td>
					</tr>
					<tr></tr>
					<tr>
						<th></th>
						<td><input class="btn btn-primary" type="submit" value="확인" onclick=""> 
						<input class="btn btn-info" type="button" value="목록으로" onclick="location.href='/shop/mng/admin/adminControl/listMngAdminControl.do'">
						</td>
					</tr>
				</table>

			</form>
		</div>
	</div>





</body>
</html>