<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
<%@ include file="../../../inc/EgovShopTop.jsp" %>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style> 
input[type="date"]::before {content:attr(data-placeholder);width:100%}
input[type="date"]:focus::before,
input[type="date"]:valid::before {display:none}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript">
		$(document).ready(function(){
			$("#cencle").on("click", function(){
				alert("test");
				$("form").attr("action", "/shop/user/EgovUserLoginForm.do");
			});
			
			 $("#s_id").blur(function() {
		            idFlag = false;
		            fn_idChk();
		        });
			 $("#s_name").blur(function() {
		            idFlag = false;
		            fn_nameChk();
		        });
			 $("#s_pass").blur(function() {
		            idFlag = false;
		            fn_passChk();
		        });
			 $("#s_pass2").blur(function() {
		            idFlag = false;
		            fn_pass2Chk();
		        });
		     $("#s_nickname").blur(function() {
		            idFlag = false;
		            fn_nicknameChk();
		        });
		     $("#sample6_address").blur(function() {
		            idFlag = false;
		            fn_addr1Chk();
		        });
		     $("#sample6_detailAddress").blur(function() {
		            idFlag = false;
		            fn_addr2Chk();
		        });
		     $("#email1").blur(function() {
		            idFlag = false;
		            fn_email1Chk();
		        });s_phone
		     $("#email2").blur(function() {
		            idFlag = false;
		            fn_email2Chk();
		        });
		      $("#s_phone").blur(function() {
		    	
		            idFlag = false;
		            fn_phonChk();
		        });
		      $("#s_birth").blur(function() {
			    	
		            idFlag = false;
		            fn_birthChk();
		        });
		   
			// 취소
			
			
			$("#submit").on("click", function(){
				//이메일 정규식
				var emailAdd1 = document.getElementById('email1').value; 
	               var emailAdd2 = document.getElementById('email2').value;

	               var emailAddress = emailAdd1 + "@" + emailAdd2;
	               var eregExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	              
	               var pregExp = /^\d{2,3}-\d{3,4}-\d{4}$/;

				if($("#s_id").val()==""){
					
					$("#s_id").focus();
					return false;
				}
				if($("#s_name").val()==""){
					
					$("#s_name").focus();
					return false;
				}
				if($("#s_pass").val()==""){
					
					$("#s_pass").focus();
					return false;
				}
				if($("#s_pass2").val()==""){
					
					$("#s_pass2").focus();
					return false;
				}
				if($("#s_pass").val() != $("#s_pass2").val()){
					
					$("#s_pass").focus();
					return false;
				}
				if($("#s_nickname").val()==""){
					
					$("#s_nickname").focus();
					return false;
				}
				if($("#sample6_address").val()==""){
					
					$("#sample6_address").focus();
					return false;
				}
				if($("#sample6_detailAddress").val()==""){
					
					$("#sample6_detailAddress").focus();
					return false;
				}
				if($("#email1").val()==""){
					
					$("#email1").focus();
					return false;
				}
				if($("#email2").val()==""){
					
					$("#email2").focus();
					return false;
					}
				if ( !emailAddress.match(eregExp) ) {
	            	   
	            	   $("#email2").focus();
	            	 return false;
	               } 
				
				if($("#s_phone").val()==""){
					
					$("#s_phone").focus();
					return false;
				}
				if(!pregExp.test($("input[id='s_phone']").val())) {            
					
					$("#s_phone").focus();
		            return false;
				}

				 if($("#s_birth").val()==""){
					
					$("#s_birth").focus();
					return false;
				} 
				
				var idChkVal = $("#idChk").val();
				var emailChkVal = $("#emailChk").val();
				var nickChkVal = $("#nickChk").val();
				
				if(idChkVal == "Y" && emailChkVal == 'Y' && nickChkVal == 'Y'){
					$("#regForm").submit();
					
				}else{ 
					alert("중복된 ");
					return false;
				}
			
			});
		})
		
		function fn_idChk(){
			if(idFlag) return true;
			var oMsg = $("#idMsg");
	        var oInput = $("#id");

	        if ( $("#s_id").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }
			idFlag = false;
			$.ajax({
				url : "/shop/user/seller/sellerIdChk.do",
				type : "post",
				dataType : "json",
				data : {"s_id" : $("#s_id").val()},
				success : function(data){
					if(data == 1){
						showErrorMsg(oMsg, "이미 사용중이거나 탈퇴한 아이디입니다.");
						$("#idChk").attr("value", "N");
						/* $("#s_id").focus(); */
					}else if(data == 0){
						  showSuccessMsg(oMsg, "멋진 아이디네요!");
						$("#idChk").attr("value", "Y");
						
						
					}
					
				}
			})
			return true;
		}
		function fn_nameChk(){
			var oMsg = $("#nameMsg");
	        var oInput = $("#s_name");

	        if ( $("#s_name").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }else{
	        	showErrorMsg(oMsg,"");
	        }
			return true;
		}
		
		function fn_passChk(){
			var oMsg = $("#passMsg");
	        var oInput = $("#s_pass");

	        if ( $("#s_pass").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }else{
	        	showErrorMsg(oMsg,"");
	        }
	        if ($("#s_pass2").val() == $("#s_pass").val()) {
	            showErrorMsg($("#pass2Msg"),"");
	        } 
	        if ($("#s_pass2").val() != $("#s_pass").val()) {
	            showErrorMsg($("#pass2Msg"),"비밀번호가 다릅니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }
	        
	        if (  $("#s_pass2").val() != "" && $("#s_pass2").val() != $("#s_pass").val()) {
	            showErrorMsg($("#pass2Msg"),"비밀번호가 다릅니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }
	        return true;
		}
		function fn_pass2Chk(){
			var oMsg = $("#pass2Msg");
	        var oInput = $("#s_pass2");

	        if ( $("#s_pass2").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }else{
	        	showErrorMsg(oMsg,"");
	        }
	        if ( $("#s_pass2").val() != $("#s_pass").val()) {
	            showErrorMsg(oMsg,"비밀번호가 다릅니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }
	        
			return true;
		}
		function fn_nicknameChk(){
			if(idFlag) return true;
			var oMsg = $("#nicknameMsg");
	        var oInput = $("#s_nickname");

	        if ( $("#s_nickname").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }
			idFlag = false;
			$.ajax({
				url : "/shop/user/seller/sellerNicknameChk.do",
				type : "post",
				dataType : "json",
				data : {"s_nickname" : $("#s_nickname").val()},
				success : function(data){
					if(data >= 1){
						showErrorMsg(oMsg, "이미 사용중 입니다.");
						$("#nickChk").attr("value", "N");
						/* $("#s_id").focus(); */
					}else if(data == 0){
						  showSuccessMsg(oMsg, "멋진 닉네임이네요!");
						$("#nickChk").attr("value", "Y");
						
						
					}
					
				}
			})
			return true;
		}
		function fn_addr1Chk(){
			var oMsg = $("#addrMsg");
	        var oInput = $("#sample6_address");

	        if ( $("#sample6_address").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }else{
	        	showErrorMsg(oMsg,"");
	        }
	        if ( $("#sample6_detailAddress").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }else{
	        	showErrorMsg(oMsg,"");
	        }
	        
			return true;
		}
		function fn_addr2Chk(){
			var oMsg = $("#addrMsg");
	        var oInput = $("#sample6_detailAddress");

	        if ( $("#sample6_address").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }else{
	        	showErrorMsg(oMsg,"");
	        }
	        if ( $("#sample6_detailAddress").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }else{
	        	showErrorMsg(oMsg,"");
	        }
	        
			return true;
		}
		function fn_email1Chk(){
			var emailAdd1 = document.getElementById('email1').value; 
            var emailAdd2 = document.getElementById('email2').value;

            var emailAddress = emailAdd1 + "@" + emailAdd2;
            var eregExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
           
			var oMsg = $("#emailMsg");
	        var oInput = $("#email2");
	        
	        if ( $("#email1").val() == "" && $("#email2").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            
	            return false;
	        }
	        if ( !emailAddress.match(eregExp) ) {
	        	showErrorMsg(oMsg,"이메일형식이 맞지 않습니다.");
	            
	            return false
            }else{
            	
            	idFlag = false;
    		 	$.ajax({
    				url : "/shop/user/seller/sellerEmailChk.do",
    				type : "post",
    				dataType : "json",
    				data : {"email1" : $("#email1").val(),"email2" : $("#email2").val()},
    				success : function(data){
    					if(data >= 1){
    						showErrorMsg(oMsg, "이미 사용중 입니다.");
    						$("#emailChk").attr("value", "N");
    						
    					}else if(data == 0){
    						  showSuccessMsg(oMsg, "성공");
    						$("#emailChk").attr("value", "Y");
    						
    						
    					}
    					
    				}
    			})
            	
            }
			
			return true;
		}
		function fn_email2Chk(){
			if(idFlag) return true;
			var emailAdd1 = document.getElementById('email1').value; 
            var emailAdd2 = document.getElementById('email2').value;

            var emailAddress = emailAdd1 + "@" + emailAdd2;
            var eregExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
           
			var oMsg = $("#emailMsg");
	        var oInput = $("#email2");
	        
	     
	        if ( $("#email1").val() == "" && $("#email2").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            
	            return false;
	        }
	        if ( !emailAddress.match(eregExp) ) {
	        	showErrorMsg(oMsg,"이메일형식이 맞지 않습니다.");
	            
	            return false
            }else{
            	
            	idFlag = false;
    		 	$.ajax({
    				url : "/shop/user/seller/sellerEmailChk.do",
    				type : "post",
    				dataType : "json",
    				data : {"email1" : $("#email1").val(),"email2" : $("#email2").val()},
    				success : function(data){
    					if(data >= 1){
    						showErrorMsg(oMsg, "이미 사용중 입니다.");
    						$("#emailChk").attr("value", "N");
    						
    					}else if(data == 0){
    						  showSuccessMsg(oMsg, "성공");
    						$("#emailChk").attr("value", "Y");
    						
    						
    					}
    					
    				}
    			})
            	
            }
			
			return true;
		}
		function fn_phonChk(){
			var oMsg = $("#phonMsg");
	        
			var pregExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	        if ( $("#s_phone").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	           
	            return false;
	        }else{
	        	showErrorMsg(oMsg,"");
	        }
	        if(!pregExp.test($("input[id='s_phone']").val())) {
	        	showErrorMsg(oMsg,"핸드폰 번호을 형식에 맞게.");

	            return false;
			}else{
	        	showErrorMsg(oMsg,"");
	        }
	        
			return true;
		}
		function fn_birthChk(){
			var oMsg = $("#birthMsg");
	        
	        if ( $("#s_birth").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	           
	            return false;
	        }else{
	        	showErrorMsg(oMsg,"");
	        }
	        
			return true;
		}
		
		 function showSuccessMsg(obj, msg) {
		        obj.attr("class", "error_next_box green");
		        obj.css("color","black");
		        obj.html(msg);
		        obj.show();
		    }
		 function showErrorMsg(obj, msg) {
		        obj.attr("class", "error_next_box");
		        obj.css("color","red");
		        obj.html(msg);
		        obj.show();
		    }
	</script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- <script>
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
</script> -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

             
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
              /*   document.getElementById('sample6_postcode').value = data.zonecode; */
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>

</head>
<body>



<div class="container">
	<div class="row justify-content-center">
		<form action="/shop/user/seller/sellerinsertPro.do" name="frm" method="post" enctype="multipart/form-data">
			<input type="hidden" value="" name="s_addr">
			<input type="hidden" id="idChk" value="N">
			<input type="hidden" id="nickChk" value="N">
			<input type="hidden" id="emailChk" value="N">
					<h2>회원가입 </h2>
					<div class="form-group">
							<!-- <label for="id">아이디</label> --><div>
							<div class="join_row">
							<input class="form-control" type="text" id="s_id" name="s_id" placeholder="아이디">
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<!-- <button class="idChk" type="hidden" id="idChk" onclick="fn_idChk();" value="N">중복확인</button><br> -->
							<div class="join_row">
							<input class="form-control" type="text" id="s_name" name="s_name" placeholder="이름">
							<span class="error_next_box" id="nameMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input class="form-control" type="password"  id="s_pass" name="s_pass" placeholder="비밀번호">
							<span class="error_next_box" id="passMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input class="form-control" type="password"  id="s_pass2" name="s_pas2s" placeholder="비밀번호 재확인">
							<span class="error_next_box" id="pass2Msg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input class="form-control" type="text"  id ="s_nickname" name="s_nickname" placeholder="닉네임">
							<span class="error_next_box" id="nicknameMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<!-- <div class="join_row">
							<input class="form-control" type="text" id="sample6_address" name="addr1" placeholder="주소" readonly>
							<input class="btn btn-secondary" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							<input class="form-control" type="text" id="sample6_detailAddress" name="addr2" placeholder="상세주소">
							<span class="error_next_box" id="addrMsg" style="display:none" aria-live="assertive"></span><br>
							</div> -->
							<div class="join_row">
							<div class="input-group">
							<input class="form-control" type="text" id="sample6_address" name="addr1" placeholder="주소" readonly>
								<div class="input-group-append">
									<input class="btn btn-secondary" type="button" onclick="sample6_execDaumPostcode()" value="주소 찾기">
								</div>
							</div>
    						</div>
    						<input class="form-control" type="text" id="sample6_detailAddress" name="addr2" placeholder="상세주소">
      						<span class="error_next_box" id="addrMsg" style="display:none" aria-live="assertive"></span><br>
    					
							<div class="join_row">
							<!-- <div class="col-5">
      						<input class="form-control" type='text' id='email1' name="email1"/>
    						</div>
    						<div class="col-1">
      						 @
    						</div>
    						<div class="col-6">
      						 <input class="form-control" type='text' id='email2' name="email2"/>
    						</div><br> -->
    						<div class="input-group">
								<input class="form-control" type='text' id='email1' name="email1"/>@
							<div class="input-group-append">
								 <input class="form-control" type='text' id='email2' name="email2"/>
							</div>
							</div>
    						</div>
							<span class="error_next_box" id="emailMsg" style="display:none" aria-live="assertive"></span><br>
							
							<div class="join_row">
							
							<input class="form-control" type="text"  id="s_phone" name="s_phone" placeholder="01X-XXXX-XXXX">
							<span class="error_next_box" id="phonMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input class="form-control" type="date"  id="s_birth" name="s_birth" data-placeholder="생년월일" required aria-required="true">
							<span class="error_next_box" id="birthMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<select class="form-control" name="s_account_n">
								<option value="null">은행선택</option>
								<option value="농협은행">농협은행</option>
								<option value="신한은행">신한은행</option>
								<option value="국민은행">국민은행</option>
								<option value="우리은행">우리은행</option>
								<option value="기업은행">기업은행</option>
								<option value="하나은행">하나은행</option>
							</select>
							</div>
							<input class="form-control" type="text"  id="s_account" name="s_account" placeholder="계좌번호"><br>
							<div class="join_row">
							<select class="form-control" id="s_gender" name="s_gender">
								<option value="남자">남자</option>
								<option value="여자">여자</option>
							</select>
							<!-- <label class="form-check-label" for="gender"> 
							<input class="form-control" type="radio" class="form-check-input" id="s_gender" name="s_gender" value="남자" checked="checked">남&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="form-control" type="radio" class="form-check-input" id="s_gender" name="s_gender" value="여자">여
							</label> -->
							</div>
					</div><br>
					<input  type="file"  id="file" name="file"><br><br>
					<div class="join_row">
						<input class="btn btn-success" style="width: 100%" type="submit" id="submit" value="회원가입">
					</div>	
					
			</div>
		</form>
	</div>
</div>

<%@ include file="../../../inc/EgovShopBottom.jsp" %>
</html>
</body>
</html>