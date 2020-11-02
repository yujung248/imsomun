<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import="egovframework.com.cmm.LoginVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnlogin").click(function() {
			location.href = "/shop/user/EgovUserLoginForm.do";
		});
	});
	$(document)
			.ready(
					function() {
						$("#btnlogout")
								.click(
										function() {
											var snscode = '${sessionScope.snscode}';
											var access_token = '${sessionScope.access_token}';
											if (snscode == 'kakao') {
												location.href = "https://kauth.kakao.com/oauth/logout?client_id=7e2a4e5240c656b96978c81a1a99fa2a&logout_redirect_uri=http://xn--z92bt9ibqf.net/shop/user/EgovUserLogout.do";
											} else if (snscode == 'naver') {
												//location.href = "https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=7e2a4e5240c656b96978c81a1a99fa2a&client_secret=SiffbMIVyj&access_token="+access_token+"&service_provider=NAVER";
												//winpop=open("https://nid.naver.com/nidlogin.logout");
												location.href = "http://xn--z92bt9ibqf.net/shop/user/EgovUserLogout.do";
												//winpop.self.close();
											}
										});
					});
	$(document).ready(function() {
		$("#sellerlogout").click(function() {

			location.href = "/shop/user/seller/sellerLogout.do";
		});
	});
	$(document).ready(function() {
		$("#adminlogout").click(function() {

			location.href = "/shop/mng/seller/adminLogout.do";
		});
	});
	$(document).ready(function() {
		$("#userlogout").click(function() {

			location.href = "/shop/user/EgovUserLogout.do";
		});
	});
</script>
</head>
<body>
	<%-- <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="/shop/user/main/EgovUserMain.do">Logo</a>

	<!-- Links -->
	<ul class="navbar-nav">
	  <li class="nav-item">
	    <a class="nav-link" href="/shop/user/product/EgovUserProductlist.do">상품게시판</a>
	  </li>
	</ul>
	<form class="form-inline" action="/shop/user/product/EgovUserProductlist.do">
	  <input type="hidden" id="searchCnd" name="searchCnd" value="0">
	  <input class="form-control mr-sm-2" id="searchWrd" name="searchWrd" type="text" placeholder="Search"3>
	  <button class="btn btn-success" type="submit">Search</button>
	</form>
		
	<c:choose>
		 <c:when test="${(sessionScope.sns_idx != null)or(sessionScope.S_ID != null and sessionScope.S_ID ne ' ')or(sessionScope.A_ID != null and sessionScope.A_ID ne ' ')}">
		 
		 		<c:if test="${sessionScope.status == 1 }">
				 <!-- <button type="button" id="btnlogout" id="userlogout">사용자 logout</button> -->
				 <button  class="btn btn-info" type="button" id="userlogout">사용자 logout</button>
				 <!-- Dropdown -->
	 				 <ul class="navbar-nav" >
	 					 <li class="nav-item dropdown">
	 					   <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	    				  	회원 메뉴
	  					  </a>
	  					  <div class="dropdown-menu">
	   						   <a class="dropdown-item" href="/shop/user/buyer/selectUserBuyer.do">마이 페이지</a>
	    					   <a class="dropdown-item" href="#">Link 2</a>
	     					   <a class="dropdown-item" href="#">Link 3</a>
	   					 </div>
					  </li>
	  				</ul>
				 </c:if>
				 <c:if test="${sessionScope.status == 2 }">
				 <button class="btn btn-info" type="button" id="sellerlogout">판매자logout</button>
				  <!-- Dropdown -->
	 				 <ul class="navbar-nav" >
	 					 <li class="nav-item dropdown">
	 					   <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	    				  	${sessionScope.S_ID} 님 
	  					  </a>
	  					  <div class="dropdown-menu">
	   						   <a class="dropdown-item" href="/shop/user/seller/selectUserSeller.do">마이 페이지</a>
	    					   <a class="dropdown-item" href="#">Link 2</a>
	     					   <a class="dropdown-item" href="#">Link 3</a>
	   					 </div>
					  </li>
	  				</ul>
				 </c:if>
				 <c:if test="${sessionScope.status == 0 }">
				 <button class="btn btn-info" type="button" id="adminlogout">운영자logout</button>
				  <!-- Dropdown -->
	 				 <ul class="navbar-nav" >
	 					 <li class="nav-item dropdown">
	 					   <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	    				  	마이페이지
	  					  </a>
	  					  <div class="dropdown-menu">
	   						   <a class="dropdown-item" href="#">후기 관리 페이지</a>
	    					   <a class="dropdown-item" href="/shop/mng/product/EgovMngProductlist.do">상품관리 페이지</a>
	     					   <a class="dropdown-item" href="#">관리자 관리 페이지</a>
	     					   <a class="dropdown-item" href="#">구매자 관리 페이지</a>
	     					   <a class="dropdown-item" href="#">판매자 관리 페이지</a>
	   					 </div>
					  </li>
	  				</ul>
				 </c:if>
			</c:when>
	
		<c:otherwise>
			<button type="button" id="btnlogin" class="btn btn-info">login</button>
			<!-- <button type="button" id="btnSignIn" class="btn btn-danger" >회원가입</button> -->
		</c:otherwise>
</c:choose>
	  
</nav> --%>
	<!-- <div class="navbar navbar-expand-sm bg-dark navbar-dark" style="background-color: black; width: 100%"> -->
	<!-- <div class="container"> -->
	<!-- <div style="height: auto; width: 100%; border-top:2px solid black;"> 
</div> -->
	<div class="container">
		<nav class="navbar navbar-expand-sm mx-auto" style="width:100%";>
		<div class="flex-grow-2">
			<a class="navbar-brand" href="/shop/user/main/EgovUserMain.do"><img
				src="<c:url value='/file/logo.png'/>" width="120px" height="50px"></a>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"></li>

				</ul>
			</div>
		</div>
		<div class="flex-grow-1 container">
			<div class="row mx-auto">
				<form class="form-inline"
					action="/shop/user/product/EgovUserProductlist.do">
					<input type="hidden" id="searchCnd" name="searchCnd" value="0">
					<div class="input-group">
						<input class="form-control" id="searchWrd" name="searchWrd"
							type="text" placeholder="검색어를 입력하세요." style="width: 50%">
						<div class="input-group-append">

							<button class="btn btn-secondary" type="submit"
								style="border: 1px black">
								<i class="fa fa-search"></i>
							</button>


						</div>
					</div>
				</form>

			</div>
		</div>
		<div class="flex-grow-2">
			<ul class="navbar-nav">
				<c:choose>
					<c:when
						test="${(sessionScope.sns_idx != null)or(sessionScope.S_ID != null and sessionScope.S_ID ne ' ')or(sessionScope.A_ID != null and sessionScope.A_ID ne ' ')}">

						<c:if test="${sessionScope.status == 1 }">
						<button class="btn btn-info" type="button" id="userlogout">logout</button>
							<!-- Dropdown -->
							<ul class="navbar-nav">
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbardrop"
									data-toggle="dropdown"> 회원 메뉴 </a>
									<div class="dropdown-menu">
										<a class="dropdown-item"
											href="/shop/user/buyer/selectUserBuyer.do">마이 페이지</a>
									</div></li>
							</ul>
						</c:if>
						<c:if test="${sessionScope.status == 2 }">

							<!-- Dropdown -->
							<ul class="navbar-nav">
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbardrop"
									data-toggle="dropdown"> ${sessionScope.S_ID} 님 </a>
									<div class="dropdown-menu">
										<a class="dropdown-item"
											href="/shop/user/seller/selectUserSeller.do">마이 페이지</a>
									</div></li>
							</ul>
							<button class="btn btn-info" type="button" id="sellerlogout">logout</button>
						</c:if>
						<c:if test="${sessionScope.status == 0 }">

							<!-- Dropdown -->
							<ul class="navbar-nav navbar-right">
								<li>
									<a class="dropdown-item" href="/shop/mng/admin/adminMainForm.do">운영자 페이지</a>
								</li> 
								
							</ul>
							<button class="btn btn-info" type="button" id="adminlogout">logout</button>
						</c:if>
					</c:when>

					<c:otherwise>
						<button type="button" id="btnlogin" class="btn btn-info">login</button>
						<!-- <button type="button" id="btnSignIn" class="btn btn-danger" >회원가입</button> -->
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		</nav>
		<div class="mx-auto"
			style="height: auto; width: 100%; border-top: 2px solid #cd3c3c;">

		</div>
	</div>
	<br>
	<!-- </div> -->
	<!-- </div> -->
</body>
</html>