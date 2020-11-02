<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>유저용 상품 관리 페이지입니다</title>
<style type="text/css">

.product-image {
  width: 200px;
  height: 200px;
  background-position: center center;
  background-repeat: no-repeat;
  background-size: cover;
  cursor:pointer;
}

</style>
</head>

<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>

	<!-- result 값을 이용한 modal -->
	<c:if test="${result2 == 0 && result ==null}">
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
					<div class="modal-body">항목을 체크해주세요.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<!-- result 값을 이용한 modal -->
	<c:if test="${result1 == 1}">
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
					<div class="modal-body">등록되었습니다</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<!-- result 값을 이용한 modal -->
	<c:if test="${result3 == 1 }">
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
					<div class="modal-body">수정되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${msg != null}">
		<div class="container"
			style="text-align: center; margin-top: 140px; margin-bottom: 140px">
			<h1>${msg}</h1>
		</div>
	</c:if>


	<form name="frm" action="/shop/user/product/EgovUserProductDelete.do">
		<div align="center">
			<c:if test="${sessionScope.status == 2 }">
				<input type="button" value="등록"
					onclick="location.href='/shop/user/product/EgovUserProductInsertForm.do'"
					class="btn btn-primary"> &nbsp;&nbsp;
<input type="submit" value="삭제" class="btn btn-danger">
				<input type="hidden" name="p_idx">
				<input type="hidden" name="pageIndex" value="${searchVO.pageIndex }">
				<input type="hidden" name="searchCnd" value="${searchVO.searchCnd }">
				<input type="hidden" name="searchWrd" value="${searchVO.searchWrd }">
				<input type="hidden" name="p_status"
					value="${productuser_list.p_status }">
			</c:if>
		</div>

		<div class="container-fluid">
			<div class="container">
				<div class="row">
					<c:forEach var="productuser_list" items="${list}">
						<div class="col-3 mt-3">
							<div 	style="background-image: url('<c:url value='/'/>file/${productuser_list.p_image}');" 
									class="product-image"
									onclick="location.href='/shop/user/product/EgovBuyerProductForm.do?p_idx=${productuser_list.p_idx }'">
							</div>
							<p class="my-2">
								<c:if test="${sessionScope.status == 2 }">
									<input type="checkbox" name="check" id="check"
										value="${productuser_list.p_idx }">
								</c:if>
								<b>${productuser_list.p_name }</b>
							</p>
							<p class="my-2"><b>
								<fmt:formatNumber value="${productuser_list.p_price }"
									pattern="##,###"></fmt:formatNumber>
								원
							</b></p>
						</div>
						<c:if test="${sessionScope.status == 2 }">
							<input type="button" value="수정" class="btn btn-warning"
								onclick="return2(${productuser_list.p_idx });">
						</c:if>

					</c:forEach>
				</div>
			</div>
		</div>
	</form>
	<c:if test="${sessionScope.status == 2 }">
		<div class="row">
			<form name="frmPage" class="mx-auto"
				action="/shop/user/product/EgovUserProductlist.do">
				<div class="input-group mb-3">
					<input type="hidden" name="pageIndex" value="1" /> <select
						name="searchCnd">
						<option value="0">상품명</option>
					</select> <input type="text" class="form-control" placeholder="검색하세요"
						aria-label="Productusername" aria-describedby="basic-addon1"
						name="searchWrd" value="${searchVO.searchWrd }">
					<div class="input-group-append">
						<input class="btn btn-secondary" type="submit" value="검색" />
					</div>
				</div>

			</form>
		</div>
	</c:if>
	<div class="row">
		<div id="paging_div" class="mx-auto">
			<ul class="paging_align">
				<ui:pagination paginationInfo="${paginationInfo}" type="image"
					jsFunction="linkPage" />
			</ul>
		</div>
	</div>
	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
<script>
function return2(p_idx){
	document.forms["frm"].action = "/shop/user/product/EgovUserProductUpdateForm.do"
	document.forms["frm"]["p_idx"].value = p_idx;
	document.forms["frm"].submit();
	return true;
}
</script>
</html>