<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
<%@ include file="../../../inc/EgovShopTop.jsp" %>
<script type="text/javascript">

	if(${chk} == 0){
		alert("test");
		alert("${msg}");
		location.href='/shop/mng/admin/EgovMngAdminLoginForm.do';
		
		
	}else{
		location.href='/shop/user/main/EgovUserMain.do';
	}
</script>