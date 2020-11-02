<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>


	<c:if test="${msg != null }">
		<script type="text/javascript">
			$(document).ready(function() {
				$("#updateModal").modal('show')

			})
		</script>
		<!-- Modal -->
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">개인 정보가 수정되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${msg = null }">
	</c:if>
	<div class="container">
		<div class="row">
			<form class="mx-auto" action="/shop/mng/buyer/updateMngBuyerPro.do"
				method="post">
				<input type="hidden" name="sns_idx" value="${BuyerVO.sns_idx }" />
				<table class="table">
					<tr>
						<th>회원번호</th>
						<td>${BuyerVO.sns_idx }</td>
					</tr>
					<tr>
						<th>회원아이디</th>
						<td><input type="text" name="userid"
							value="${BuyerVO.userid }" /></td>
					</tr>
					<tr>
						<th>SNS 코드</th>
						<td><input type="text" name="snscode"
							value="${BuyerVO.snscode }" /></td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td><input type="text" name="nickname"
							value="${BuyerVO.nickname }" /></td>
					</tr>
					<tr>
						<th>이메일 주소</th>
						<td><input type="text" name="email" value="${BuyerVO.email }" /></td>
					</tr>
					<tr>
						<th>가입일</th>
						<td>${BuyerVO.reg_date }</td>
					</tr>
					<tr>
						<th>상태</th>
						<td><input type="text" name="del_yn"
							value="${BuyerVO.del_yn }" /></td>
					</tr>
					<tr>
						<td colspan="2"><input class="btn btn-info" type="submit"
							value="수정" /> <input class="btn btn-secondary" type="button"
							value="목록으로"
							onclick="location.href='/shop/mng/buyer/listMngBuyer.do'" /> <input
							class="btn btn-secondary" type="button" value="강제 로그인"
							onclick="location.href='/shop/user/snsprofile/loginUserSnsprofileTestPro.do?sns_idx=${BuyerVO.sns_idx}'" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>