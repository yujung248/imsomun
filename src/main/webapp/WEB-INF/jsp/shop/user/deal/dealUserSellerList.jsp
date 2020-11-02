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
<style type="text/css">
.dropdown-item:hover {
	cursor: pointer;
}
table {
	table-layout:fixed; 
	word-break:break-all;
	text-align: center;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopTop.jsp"%>
	<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopHeader.jsp"%>

	<%
		String context = request.getContextPath();
	%>


	<script type="text/javascript">
		function onOrder(order) {
			document.frm.sortD_regdate.value = order;
			document.frm.pageIndex.value = 1;
			document.frm.submit();
		}

		function onD_ing(order) {
			document.frm.sortD_ing.value = order;
			document.frm.pageIndex.value = 1;
			document.frm.submit();
		}
		function fn_egov_select_dealList(pageNo) {
			document.frm.pageIndex.value = pageNo;
			document.frm.action = "<c:url value='/shop/user/deal/dealUserSellerList.do'/>";
			document.frm.submit();
		}
		function searchChd(){
			document.frm.pageIndex.value = 1;
			document.frm.action="/shop/user/deal/dealUserSellerList.do";
			document.frm.submit();
		}

		function productChange(p_idx){
			 if(confirm(" 거래 취소된 항목입니다. \n 해당 상품 상세 페이지로 이동 하시려면 예를 누르시고\n 취소 하시려면 아니오를 눌러주세요")){
				 document.frm.p_idx.value = p_idx;
				 document.frm.action="/shop/user/product/EgovSellerProductForm.do";
				 document.frm.submit();
			 }
			 else{
			 alert('아니오를 누르셨습니다');
			 }
		}
	</script>
	<br>
	<form method="post" name="frm">
	<!-- <form name="frm"> -->
		<input type="hidden" name="pageIndex" value="${searchVO.pageIndex }">
		<input type="hidden" name="searchCnd" value="0" />
		<input type="hidden" name="sortD_regdate" value="${vo.sortD_regdate}" /> 
		<input type="hidden" name="sortD_ing" value="${vo.sortD_ing}"/> 
		
		
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="상품이름, 구매자"
							aria-label="Username" aria-describedby="basic-addon1"
							name="searchWrd" value="${searchVO.searchWrd }"/>
						<div class="input-group-append">
							<input class="btn btn-secondary" type="button" value="검색" onclick="searchChd();"/>
						</div>
						<div class="input-group-append">
							<button type="button" class="btn btn-secondary"
								onclick="location.href='/shop/user/deal/dealUserSellerList.do'">
								<i class="fa fa-bars">목록으로</i>
							</button>
						</div>
					</div>
				</div>
				<div id="paging_div">
					<ul class="paging_align">
						<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_dealList"/>
					</ul>
				</div>
			</div>

			<table class="table table-hover">
				<tr>
					<th width="20%" style="text-align: left;">상품이름</th>
					<th width="14%">구매자</th>
					<th width="10%">상품수량</th>
					<th width="10%">가격</th>
					<th width="14%">
						<button type="button"
							class="btn btn-outline-dark btn-sm dropdown-toggle dropdown-toggle m-1"
							data-toggle="dropdown">
							<Strong>거래 등록 일시</Strong>
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" onclick="onOrder(1)">과거 순</a> <a
								class="dropdown-item" onclick="onOrder(2)">최신 순 </a>

						</div>
					</th>
					<th width="18%">
						<button type="button"
							class="btn btn-outline-dark btn-sm dropdown-toggle dropdown-toggle m-1"
							data-toggle="dropdown">
							<Strong>거래상태</Strong>
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" onclick="onD_ing(0)">전체</a> <a
								class="dropdown-item" onclick="onD_ing(1)">구매자 신청</a> <a
								class="dropdown-item" onclick="onD_ing(2)">판매자 수락</a> <a
								class="dropdown-item" onclick="onD_ing(3)">배송 시작</a> <a
								class="dropdown-item" onclick="onD_ing(4)">거래 완료</a> <a
								class="dropdown-item" onclick="onD_ing(5)">구매자 거래 취소</a> <a
								class="dropdown-item" onclick="onD_ing(6)">판매자 거래 취소 
							</a>
						</div>
					</th>
					<th width="14%">거래 완료 일시</th>
				</tr>
				
				<c:forEach items="${dealUserlist }" var="list" varStatus="status">
					
					<c:choose>
						<c:when test="${list.d_ing eq '5' || list.d_ing eq '6' }">
						<tr onclick="productChange(${list.p_idx })" style="cursor: pointer;">
							<input type="hidden" name="p_idx" value="${list.p_idx }"/>
						</c:when>
				      <c:otherwise>
					<tr onclick="location.href='/shop/user/deal/dealUserSellerDetail.do?d_idx=${list.d_idx}'"
						style="cursor: pointer;">
				      </c:otherwise> 
				</c:choose> 			
							<td width="20%" style="text-align: left;">${list.p_name }</td>
							<td width="14%">${list.nickname }</td>
							<td width="10%">${list.d_q }개</td>
							<td width="10%"><fmt:formatNumber type="number" maxFractionDigits="3" value="${list.p_price * list.d_q}"/>원</td>
							<td width="14%">${list.d_regdate }</td>
							<td width="18%"><c:choose>
									<c:when test="${list.d_ing eq '1'}"> 구매자 신청 </c:when>
									<c:when test="${list.d_ing eq '2'}"> 판매자 수락 </c:when>
									<c:when test="${list.d_ing eq '3'}"> 배송 시작 </c:when>
									<c:when test="${list.d_ing eq '4'}"> 거래 완료 </c:when>
									<c:when test="${list.d_ing eq '5'}"> 구매자 거래 취소 </c:when>
									<c:when test="${list.d_ing eq '6'}"> 판매자 거래 취소 </c:when>
								</c:choose></td>
							<td width="14%">${list.d_edate }<br>
							</td>
				</c:forEach>
					</tr>
			</table>
		</div>
	</form>
		<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopBottom.jsp"%>
</body>
</html>