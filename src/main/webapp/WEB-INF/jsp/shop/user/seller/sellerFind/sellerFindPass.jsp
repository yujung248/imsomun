
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
<%@ include file="../../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript">
$(document).ready(function(){
			// 취소
			$("#cencle").on("click", function(){
			$("form").attr("action", "/shop/user/EgovUserLoginForm.do");
			})
			
			$("#submit").on("click", function(){


				if($("#s_pass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#s_pass").focus();
					return false;
				}
				if($("#s_pass2").val()==""){
					alert("비밀번호재확인를 입력해주세요.");
					$("#s_pass2").focus();
					return false;
				}
				if($("#s_pass").val() != $("#s_pass2").val()){
					alert("비밀번호가 일치하지 않습니다.");
					$("#s_pass").focus();
					return false;
				}
				
				$.ajax({
					url : "/shop/user/seller/sellerRePass.do",
					type : "post",
					dataType : "json",
					data : {"s_id" : $("#s_id").val(),"s_pass" : $("#s_pass").val()},
					success : function(data){
						if(data == 1){
							alert("인증되었습니다.");
							alert("비밀번호가 재설정되었습니다.");
							
						}else if(data == 0){
							alert("실패");
							return false;
						}
					}
				})
	});
})
/* function check() {
	location.href = "<c:url value='/shop/user/EgovUserLoginForm.do'/>";
} */
</script>
</head>
<body>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
<form id="fm" name="fm" action="/shop/user/EgovUserLoginForm.do" method="post">
<div class="container"	style="text-align:center;">
	<div class="container" style="text-align:left;">
		<input id="s_id" name="s_id" type="hidden"value="${s_id }"> 		
			<div class="section section_find">
					<dl class="n_id">
					<dt>아이디 : ${s_id }</dt>
					</dl>
						<label id="lb_new_pw" for="new_pw" style="">새 비밀번호</label>	<br>			
						<input class="form-control" id="s_pass" name="s_pass" type="password"><br>
						<label id="lb_new_pw" for="new_pw" style="">새 비밀번호 확인</label>	<br>				
						<input class="form-control" id="s_pass2" name="s_pass2" type="password">

					<input class="btn btn-success" type="submit" id="submit" value="확인">
					<input class="btn btn-success" type="submit" id="cencle" value="취소">
				
			</div>
	</div>
</div>
</form>
<%@ include file="../../../inc/EgovShopBottom.jsp"%>

</body>
</html>