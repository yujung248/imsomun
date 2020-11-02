<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
	<script type="text/javascript">
	
function updateUserBasketQty(index){
	document.forms["frm"+index].submit();
}

</script>

	<!-- result 값을 이용한 modal -->
	<c:if test="${result == 1 }">
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
					<div class="modal-body">수량이 수정되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<input type="hidden" name="pageIndex" value="${searchVO.pageIndex }">
	<div class="container">
		<div class="row">
			<table class="table mx-auto">
				<tr>
					<th>상품번호</th>
					<th>상품이름</th>
					<th>상품가격</th>
					<th>상품수량</th>
					<th>수정</th>
					<th>삭제</th>
					<th>구매</th>

				</tr>
				<c:forEach items="${list }" var="basketList" varStatus="status">
					<script type="text/javascript">
						console.log("pageIndex => " + ${basketList.pageIndex} );
					</script>
					<tr>
						<td>${basketList.p_idx }</td>
						<td>${basketList.p_name }</td>
						<td>${basketList.p_price }</td>
						<td><input class="form-control form-control-sm"
							id="ba_q${status.index }" type="text" form="frm${status.index }"
							name="ba_q" value="${basketList.ba_q }" /></td>
						<td><input class="btn btn-secondary" type="button" value="수정"
							form="frm${status.index }"
							onclick="updateUserBasketQty(${status.index })" /></td>
						<td><input class="btn btn-danger" type="button" value="삭제"
							form="frm${status.index }"
							onclick="location.href='/shop/user/basket/deleteBasketUser.do?ba_idx=${basketList.ba_idx}'" /></td>
						<td><input class="btn btn-primary" type="button" value="구매"
							form="frm${status.index }"
							onclick="location.href='/shop/user/deal/dealUserBuyerRequest.do?p_idx=${basketList.p_idx}&s_id=${basketList.s_id }'" /></td>
					</tr>
					<form action="/shop/user/basket/updateBasketUserQty.do"
						name="frm${status.index }" id="frm${status.index }">
						<input type="hidden" id="ba_idx${status.index }" name="ba_idx"
							value="${basketList.ba_idx }" />
					</form>
				</c:forEach>
			</table>
			<div class="mx-auto" id="paging_div">
				<form name="frmPage" id="frmPage"
					action="/shop/user/basket/listBasketUser.do">
					<ul class="paging_align">
						<ui:pagination paginationInfo="${paginationInfo}" type="text"
							jsFunction="linkPage" />
					</ul>
					<input type="hidden" name="searchCnd" value="0" /> <input
						id="pageIndex" type="hidden" name="pageIndex" value= /> <input
						type="hidden" name="searchWrd" value="${searchVO.searchWrd }" />
				</form>
			</div>

		</div>
	</div>
	<script>
		function linkPage(pageNo){
			document.forms["frmPage"].submit();
		}
		
	</script>
	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>