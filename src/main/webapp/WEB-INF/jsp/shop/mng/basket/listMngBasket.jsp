<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>

<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>

<%
	String context = request.getContextPath();
%>

<script type="text/javascript">


	/* BasketMngController */
	function updateMngBasketQty(index){
		console.log("index =>" + index);
		var vba_idx = document.getElementById("ba_idx"+index).value;
		var vba_q = document.getElementById("ba_q"+index).value;
		var jsonData = {
				ba_idx : vba_idx,
				ba_q : vba_q
		}
		console.log(JSON.stringify(jsonData))
		console.log("updateMngBasketQty()")
 		$.ajax({
			url:"<%=context%>/shop/mng/basket/updateMngBasketQty.do",
			data:jsonData,
			dataType:'text',
			success:function(data){
				console.log("result => "+ data)		
				if(data==1){
					$("#updateModal").modal('show')
				}
			}
		})
	
	} 
	
	/* linkPage */
	function linkPage(pageIndex){
		document.forms["frmPage"]["pageIndex"].value=pageIndex;
		document.forms["frmPage"].submit();
		return true;
	}
</script>
<script type="text/javascript">
	
function updateUserBasketQty(index){
	document.forms["frm"+index].submit();
}

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


<div class="container">
	<div class="row">

	<table class="table mx-auto">
			<tr>
				<th>장바구니 번호</th>
				<th>고객번호</th>
				<th>고객 아이디</th>
				<th>고객 SNS</th>
				<th>상품번호</th>
				<th>판매자 아이디</th>
				<th>상품 수량</th>
				<th>수정</th>
				<th>장바구니 등록일</th>
				<th>삭제</th>
				
			</tr>
		<c:forEach items="${list }" var="basketList" varStatus="status">
		<script type="text/javascript">
			console.log("pageIndex => " + ${basketList.pageIndex });
		</script>
			<tr>
				<td>${basketList.ba_idx }</td>
				<td>${basketList.sns_idx }</td>
				<td>${basketList.userid }</td>
				<td>${basketList.snscode }</td>
				<td>${basketList.p_idx }</td>
				<td>${basketList.s_id }</td>
				<td><input class="form-control form-control-sm" id="ba_q${status.index }" type="text" form="frm${status.index }" name="ba_q" value="${basketList.ba_q }"/></td>
				<td><input class="btn btn-secondary" type="button" value="수정" form="frm${status.index }" onclick="updateMngBasketQty(${status.index })" /></td>
				<fmt:formatDate var="dateTempFmt" value="${basketList.ba_reg_date }" pattern="yyyy.MM.dd"/>
				<td><c:out value="${dateTempFmt}"></c:out></td>
				<td><input class="btn btn-danger" type="button" value="삭제" form="frm${status.index }" onclick="location.href='/shop/mng/basket/deleteMngBasket.do?ba_idx=${basketList.ba_idx}'" /></td>
			</tr>
			<form name="frm${status.index }" id="frm${status.index }">
				<input type="hidden" id="ba_idx${status.index }" name="ba_idx" value="${basketList.ba_idx }" />

			
			</form>
		</c:forEach>
	</table>
	<form action="/shop/mng/basket/listMngBasket.do">
		<input type="hidden" name="searchCnd" value="0"/>
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="검색어"
					aria-label="Username" aria-describedby="basic-addon1"
					name="searchWrd" value="${searchVO.searchWrd }"> 
			<div class="input-group-append">
				<input class="btn btn-secondary" type="submit" value="검색" />
			</div>
		</div>
	</form>
		<div id="paging_div">
		<form name="frmPage" id="frmPage" action="/shop/mng/basket/listMngBasket.do">
			<ul class="paging_align">	
				<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage" />
			</ul>
			<input type="hidden" name="searchCnd" value="0"/>
			<input type="hidden" name="pageIndex" />
			<input type="hidden" name="searchWrd" value="${searchVO.searchWrd }" />
		</form>
	</div>
	
		</div>
</div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>