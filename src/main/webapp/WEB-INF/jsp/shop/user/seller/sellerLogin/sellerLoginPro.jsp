<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">

	if(${chk} == 0){
		
		alert("${msg}");
		location.href='/shop/user/EgovUserLoginForm.do';
		
		
	}else{
		
		location.href='/shop/user/main/EgovUserMain.do';
	}

</script>