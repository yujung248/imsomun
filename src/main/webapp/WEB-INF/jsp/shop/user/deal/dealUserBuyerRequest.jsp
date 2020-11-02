<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopTop.jsp"%>
	<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopHeader.jsp"%>

	<%
		String context = request.getContextPath();
	%>
	<div class="container">
		<h1>구매 요청</h1>
		<div class="row">
			<form class="mx-auto"
				action="/shop/user/deal/dealUserBuyerRequestPro.do">
				<!--                		  action="/shop/user/deal/dealUserBuyerRequestPro.do" method="post"> -->
				<input type="hidden" name="p_idx" value="${DealUserVO.p_idx }" /> <input
					type="hidden" name="s_id" value="${DealUserVO.s_id }" />

				<table class="table">
					<tr>
						<th>구매 수량</th>
						<td><input type="number" name="d_q" min="1"
							max="${DealUserVO.p_q}" value="1" /></td>
					</tr>
					<tr>
						<th>주소 및 배송 요청사항</th>
						<td>입금자 명, 환불 시 받을 계좌, 주소, 배송 요청사항<br> <textarea
								style="width: 100%" rows=5 name="d_request"
								placeholder="입금자 명, 환불 시 받을 계좌, 주소, 배송 요청사항 입력 바랍니다.">${DealUserVO.d_request}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;"><input
							class="btn btn-danger" type="reset" value="취소" /> <input
							class="btn btn-success" type="submit" value="확인" /></td>
					</tr>
				</table>
				<button type="button" class="btn btn-warning"
					style="text-align: center;"
					onclick="location.href='/shop/user/product/EgovBuyerProductForm.do?p_idx=${DealUserVO.p_idx}'">
					<i class="fa fa-bars">이전으로</i>
				</button>
			</form>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopBottom.jsp"%>
</body>
</html>