<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var snscode='${sessionScope.snscode}';
		if(snscode!=null && snscode!=''){
			alert('로그인 상태 입니다.\n로그아웃하고 다시 이용해 주세요.');
			location.href ="http://xn--z92bt9ibqf.net/shop/user/main/EgovUserMain.do";	
		}
	});
function chk1() {

	if(document.getElementById("buyer").style.display=="none"){
		document.getElementById("buyer").style.display="block";
		document.getElementById("seller1").style.display="none";
		document.getElementById("seller2").style.display="none";
		
	}
};
function chk2() {

	if(document.getElementById("seller1").style.display=="none"){
		document.getElementById("buyer").style.display="none";
		document.getElementById("seller1").style.display="block";
		document.getElementById("seller2").style.display="block";
		
	}
};
	
</script>
</head>
 
<body>
<%@ include file="../inc/EgovShopHeader.jsp" %> 
<!-- result 값을 이용한 modal -->
	<c:if test="${chk == '0'}">
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
<div class="container" style="text-align:center; margin-top: 20px;">
<h2>로그인</h2>
<button  class="btn btn-secondary" onclick="chk1();">구매자</button>
<button  class="btn btn-secondary" onclick="chk2();">판매자</button>
</div>
<div id="buyer" class="container" style="text-align:center; margin-top: 20px; display: block;">
  	<a href="${kakaoUrl}"><img src="<c:url value='/'/>images/shop/login/kakaologin.png" width=231 height="50"/></a><br/><br/>
  	<a href="${naverUrl}"><img src="<c:url value='/'/>images/shop/login/naverlogin.PNG" width=231 height="50"/></a>
  	
  	

</div>
  	
<form action="<c:url value='/shop/user/seller/EgovsellerLoginPro.do'/>">
	<div id="seller1" class="container" style="text-align:center; margin-top: 20px; display: none;">
		
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

<div id="seller2" class="container" style="text-align:center; display: none;">
	<div class="find_info align_center">
		<a target="_blank" id="idinquiry" href="<c:url value='/shop/user/seller/sellerIdAgreeFrom.do'/>">아이디 찾기</a> <span class="bar" aria-hidden="true">|</span> 
		<a target="_blank" id="pwinquiry" href="<c:url value='/shop/user/seller/sellerSearchId.do'/>">비밀번호 찾기</a> <span class="bar" aria-hidden="true">|</span> 
		<a target="_blank" id="join" href="<c:url value='/shop/user/seller/sellerAgree.do'/>">회원가입</a>
	</div>
</div>

<%@ include file="../inc/EgovShopBottom.jsp"%>	   	
 
</body>
</html>