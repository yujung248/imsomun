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
<title>상세페이지</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>
<script type="text/javascript">
	//삭제
	function delUserReview(idx){
		document.frm.r_idx.value=idx;
		document.frm.action="/shop/user/review/delUserReview.do";
		document.frm.submit();
	}
	//본인이쓴 id 만 수정 삭제할수있게 보여준다.
	function displayView(idx){
		var str="r_view"+idx;
		var str2="r_view2"+idx;
		document.getElementById(str).style.display="block";
		document.getElementById(str2).style.display="none";
	}
	//수정
	function updateUserReview(idx){
		var r_contentVal="r_contentVal"+idx;
		document.frm.r_content.value=document.getElementById(r_contentVal).value;
		document.frm.r_idx.value=idx;
		document.frm.action="updateUserReview.do";
		document.frm.submit();
	}
	//상품에 첫 후기작성
	
	//--------------------------
</script>
<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<h3 style="text-align: center">상품 상세 페이지</h3> 


 <div class="container text-center">
		<div class="row justify-content-center">
	    <div class="row"> 
			<form name="frm" action=""  enctype="multipart/form-data">
	    <input type="hidden" name="p_idx" value="${ProductUserVO.p_idx }" />
	    <input type="hidden" name="s_id" value="${ProductUserVO.s_id }" />
					<img class="img-fluid" src="<c:url value='/'/>file/${ProductUserVO.p_image}" width="200" height="200"/>
						<p>
					<table class="table" style="text-align: left">
					<tr>
						<th>상품명</th>
						<td>${ProductUserVO.p_name}
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>${ProductUserVO.p_price }</td>
					</tr>
					<tr>
						<th>해시태그</th>
						<td>${ProductUserVO.p_tage }</td>
					</tr>
					<tr>
						<th>재고 수량</th>
						<td>${ProductUserVO.p_q }</td>
					</tr>
					<tr>
						<th>판매시작일</th>
						<td>${ProductUserVO.p_sdate }</td>
					</tr>
					<tr>
						<th>판매종료일</th>
						<td>${ProductUserVO.p_edate }</td>
					</tr>
					<tr>
						<th>업데이트된 날짜</th>
						<td>${ProductUserVO.p_moddate }</td>
					</tr>
					<tr>
						<th>제품 내용</th>
						<td width="400px;">
						${ProductUserVO.p_content }</td>
					</tr>
				</table>
				
				<p/>
				<p/>
				<input type="button" value="장바구니" class="btn btn-primary" onclick="goBasket(); return false;"/>
				<input type="submit" value="찜하기" class="btn btn-primary" onclick="goLike(); return false;"/>
				<input type="button" value="바로구매" class="btn btn-primary" onclick="location.href='/shop/user/deal/dealUserBuyerRequest.do?p_idx=${ProductUserVO.p_idx}&s_id=${ProductUserVO.s_id }'"/>
				<p/>
				<input type="button" value="목록" class="btn btn-info" onclick="location.href='/shop/user/product/EgovUserProductlist.do'"/>
				</p>
				</form>				
			</div>
		</div>
		<div class="d-flex justify-content-center">
		<div class="row">
			<c:forEach var="result" items="${list }">
			<div class="col-12">
				<div class="p-2 border">
	         		<span class="float-left"><span class="font-weight-normal" style="color: red">구매자 이름 </span></span>	
	         			<span class="float-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;점수 :${result.sns_score}</span> 
	         			<span class="float-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${result.r_regdate}</span><br>
	         		<span class="float-left">${result.nickname}</span>&nbsp;<span class="font-weight-normal">
	         		</span>&nbsp;&nbsp;&nbsp;<p class="text-center">	${result.r_content }</p></div>
         		</div>
			</c:forEach>
         	</div>
		</div>
	</div>
<script type="text/javascript">
	function goBasket() {
		document.frm.action = "/shop/user/basket/insertBasketUserPro.do";
		document.frm.submit();
	}
	
	function goLike() {
		document.frm.action = "/shop/user/product/LikeUserInsert.do";
		document.frm.submit();
	}
</script>


<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>