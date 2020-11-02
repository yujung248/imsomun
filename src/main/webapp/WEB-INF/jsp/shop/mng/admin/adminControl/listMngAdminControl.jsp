<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<mata http-equiv="content-langauge" content="ko">
<title>입소문넷</title>
</head>
<body>
  <%@ include file="../../../inc/EgovShopTop.jsp" %>
  <%@ include file="../../../inc/EgovShopHeader.jsp" %>
   <c:if test="${msg != null }">
	<p>${msg }</p>
	</c:if>
	<c:if test="${msg = null }">
	</c:if> 
	<div class="container">
	  <div class="row">
	   <%-- <input type="hidden" name="a_pass" value="${AdminVO.a_pass }" /> --%>
	   <form class="w-100" action="/shop/mng/admin/adminControl/delMngAdminControl.do" name="frm"">
	   <table class="table mx-auto">
	      <tr>
	         <th>아이디</th>
	         <th>이메일</th>
	         <th>이름</th>
	         <th>수정일</th>
	         <th>등록일</th>
	         <th>삭제</th>
	     </tr>
	     
       <c:forEach items="${list }" var="admin_list" varStatus="loop">
	    <tr>
	       <td><a href="/shop/mng/admin/adminControl/updateMngAdminControl.do?a_id=${admin_list.a_id }">${admin_list.a_id }</a></td>
	       <td>${admin_list.a_email }</td>
	       <td>${admin_list.a_name }</td>
	       <td>${admin_list.a_moddate }</td>
	       <td>${admin_list.a_regdate }</td>
	     <td><input type="checkbox" name="a_id" value="${admin_list.a_id }"></td>
		  </tr>
	    </c:forEach> 
	   </table>
	   <input class="btn btn-danger" type="submit" value="삭제"/>
	    <input class="btn btn-info" type="button" value="등록" onclick="location.href='/shop/mng/admin/adminControl/insertMngAdminControlForm.do'">
	   </form>
	   <div id="paging_div" class="mx-auto">
	   <ul class="paging_align">	
				<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage" />
			</ul>
	    </div>
	  </div>
	  
	</div>
	
  
	  
	 
  
</body>
</html>