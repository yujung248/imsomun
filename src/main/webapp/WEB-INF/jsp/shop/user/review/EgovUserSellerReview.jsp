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
<title>Insert title here</title>
</head>
<script type="text/javascript">
	//삭제
	function delUserReview(idx){
		document.frm.r_idx.value=idx;
		document.frm.action="/shop/user/review/delUserReview.do?s_id=${s_id}";
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
		document.frm.action="updateUserReview.do?s_id=${s_id}";
		document.frm.submit();
	}
</script>
<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<div class="container text-center">
	<div class="row justify-content-center">
		<h1>판매자가 작성한 리뷰 페이지</h1>
	</div>
</div>
<div class="container text-center">
	<div class="row justify-content-center">
		<form name="frm" method="post">
		 	<input type="hidden" name="r_idx" value=""/>
		 	<input type="hidden" name="r_content" value=""/>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>판매자 아이디</th>
							<th>상품 이름</th>
							<th>리뷰 내용</th>
							<th>사진</th>
							<th>등록일자</th>
							<th>판매자 점수</th>
							<th>수정  삭제 </th>				
						</tr>
					</thead>
						<c:forEach var="result" items="${list }">
							<c:if test="${result.r_delyn eq 'N' }">
								<tbody>
									<tr>
										<td>${result.s_id }</td>
										<td>${result.p_name }</td>
										<td>
											<div id="r_view${result.r_idx}" style="display: none;">
											<textarea id="r_contentVal${result.r_idx}" name="r_contentVal${result.r_idx}" rows="3" cols="45">${result.r_content }</textarea>
											<a href="javascript:updateUserReview('${result.r_idx}');"><button type="button" class="btn btn-outline-dark">저장</button></a> 
											</div>
											<div id="r_view2${result.r_idx}" style="display: block;">
											<pre>${result.r_content}</pre></div>
										</td>
										<td><!-- 사진 업로드 되는 경로 다시한번 확인하고. 사진 가져올수 있도록 하기. -->
											<c:if test="${result.original_file_name ne ' ' }">
												<img class="img-fluid" src="<c:url value='/'/>file/${result.original_file_name }" width="200" height="200" alt="리뷰사진" class="rounded"/>
											</c:if>
											<c:if test="${result.original_file_name eq ' ' && result.original_file_name eq null }">
												<span style="color: gray;">사진이없습니다.</span>
											</c:if>
										</td>
										<td>${result.original_file_name }</td>
										<td>${result.r_regdate }</td>
										<td>${result.seller_score }</td>
										<td>
											<div>
												<a href="javascript:displayView('${result.r_idx}');"><button type="button" class="btn btn-secondary">수정</button></a>
												<a href="javascript:delUserReview('${result.r_idx}');"><button type="button" class="btn btn-danger">삭제</button></a>
											</div>
										</td>
									</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center">
			<div class="row justify-content-center">
				<ul class="paging_align">	
					<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage" />
				</ul>
			</div>
				</div>	
		<h5>삭제된 리뷰</h5>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>판매자 아이디</th>
						<th>상품 이름</th>
						<th>리뷰 내용</th>
					</tr>
				</thead>
					<c:forEach var="result" items="${list }">
					<c:if test="${result.r_delyn eq 'Y' }">
						<tbody>
							<tr>
								<td>${result.s_id }</td>
								<td>${result.p_name }</td>
								<td>삭제된 리뷰입니다.</td>
							</tr>
						</tbody>
					</c:if>
				</c:forEach>
				</table>
		</form>
	</div>
</div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>