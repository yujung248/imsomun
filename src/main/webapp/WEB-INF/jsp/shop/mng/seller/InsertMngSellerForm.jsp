<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#s_id").blur(function() {
          idFlag = false;
          fn_idChk("first");
      });
	 // 취소
	$("#submit").on("click", function(){
		//이메일 정규식
		if($("#s_id").val()==""){
			alert("아이디를 입력해주세요.");
			$("#s_id").focus();
			return false;
		}
		if($("#s_nickname").val()==""){
			alert("닉네임을 입력해주세요.");
			$("#s_nickname").focus();
			return false;
		}
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
		if($("#s_email").val()==""){
			alert("이메일을 입력해주세요.");
			$("#s_email").focus();
			return false;
		}
		if($("#s_phone").val()==""){
			alert("핸드폰 번호을 입력해주세요.");
			$("#s_phone").focus();
			return false;
		}
		if($("#sample6_address").val()==""){
			alert("주소를 입력해주세요.");
			$("#sample6_address").focus();
			return false;
		}
		if($("#sample6_detailAddress").val()==""){
			alert("상세주소를 입력해주세요.");
			$("#sample6_detailAddress").focus();
			return false;
		}
		if($("#s_birth").val()==""){
			alert("생일을 입력해주세요.");
			$("#s_birth").focus();
			return false;
		}
		var idChkVal = $("#idChk").val();
		if(idChkVal == "N"){
			alert("중복확인 버튼을 눌러주세요.");
			return false;
		}else if(idChkVal == "Y"){
			$("#regForm").submit();
		}else if(idChkVal == "D"){
			alert("중복된 아이디입니다.");
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
						$("#idChk").attr("value", "D");
					
					}else if(data == 0){
						  showSuccessMsg(oMsg, "멋진 아이디네요!");
						$("#idChk").attr("value", "Y");
						
						
					}
					
				}
			})
			return true;
		}
function showSuccessMsg(obj, msg) {
    obj.attr("class", "error_next_box green");
    obj.html(msg);
    obj.show();
}
function showErrorMsg(obj, msg) {
    obj.attr("class", "error_next_box");
    obj.html(msg);
    obj.show();
} 
 function inputPhoneNumber(obj) {



    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";



    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
} 
</script>

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


<script type="text/javascript">
function readURL(input) {
if (input.files && input.files[0]) {
var reader = new FileReader();
reader.onload = function (e) {
$('#blah').attr('src', e.target.result);
}
reader.readAsDataURL(input.files[0]);
}
}
</script>
<style type="text/css">
label {
  display: inline-block;
  padding: .5em .75em;
  color: #fff;
  font-size: inherit;
  line-height: normal;
  vertical-align: middle;
  background-color: #6c757d;
  cursor: pointer;
  border: 1px solid #6c757d;
  border-radius: .25em;
  -webkit-transition: background-color 0.2s;
  transition: background-color 0.2s;
}

label:hover {
  background-color: #5a5a5a;
}

label:active {
  background-color: #5a5a5a;
}

input[type="file"] {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  border: 0;
}
</style>
</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>

<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-2 col-sm-1"></div>
			<div class="col-lg-6 col-md-8 col-sm-10">
			
			<form class="mx-auto" action="/shop/mng/seller/InsertMngSellerPro.do" method="post" enctype="multipart/form-data">
					<input type="hidden" value="" name="s_addr">
					
				<table class="table">		
						
					<tr>
						<th></th>
						<td height="200" style=""><img id="blah" src="#" alt="your image" width="300" height="200" /></td>    				
					</tr>
					<tr>
						<th>파일업로드</th>	
						<td><label for="ex_file">업로드</label>
							<input type='file' name="file" id="ex_file" onchange="readURL(this);" /></td>    
					</tr>
					<tr>
						<th>회원아이디</th>
						<td><input class="form-control" type="text" id="s_id" name="s_id" placeholder="아이디"><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span></td>
					</tr>
			
					<tr> 
						<th>닉네임</th>
						<td><input class="form-control" type="text" name="s_nickname" placeholder="닉네임"></td>
					</tr>
					<tr> 
						<th>비밀번호</th>
						<td><input class="form-control" type="password" id="s_pass" name="s_pass" placeholder="비밀번호"></td>
					</tr>
					<tr> 
						<th>비밀번호 재확인</th>
						<td><input class="form-control" type="password" id="s_pass2" name="s_pas2s" placeholder="비밀번호 재확인"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input class="form-control" type="email" id="s_email" name="s_email" placeholder="이메일"></td>
					</tr>
				
					<tr>
						<th>핸드폰 번호</th>
						<td><input class="form-control" type="text" maxlength="13" onKeyup="inputPhoneNumber(this);" id="s_phone" name="s_phone" placeholder="01X-XXXX-XXXX">
                     	 </td>						
					</tr>
					
					<tr>
						<th>주소</th>
						<td>
							<div class="join_row">
							<div class="input-group">
								<input class="form-control" type="text" id="sample6_address" name="addr1" placeholder="주소" readonly>
							<div class="input-group-append">
								<input type="button" class="btn btn-secondary" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
							</div></div></div></td>
					</tr>
					
					<tr>
						<th>상세주소</th>
						<td><input class="form-control" type="text" id="sample6_detailAddress" name="addr2" placeholder="상세주소"></td>
					</tr>
					
					<tr>
						<th>성별</th>
						<td>&nbsp;&nbsp; <input type="radio" class="form-check-input" id="s_gender" name="s_gender" value="여자" checked="checked" />여자 &nbsp;&nbsp;&nbsp;&nbsp;
						 <input type="radio" class="form-check-input" id="s_gender" name="s_gender" value="남자" >남자
						</td>
					</tr>
					<tr>
						<th>생일</th>
						<td><input class="form-control" type="date" id="s_birth" name="s_birth" placeholder="생년월일"></td>
					</tr>
					<tr>
						<th>은행</th>
						<td>
						<select class="form-control" name="s_account_n">
							<option value="국민은행" ${SellerVO.s_account_n eq '국민은행' ? "selected='selected'" : '' }>국민은행</option>
							<option value="농협은행" ${SellerVO.s_account_n eq '농협은행' ? "selected='selected'" : '' }>농협은행</option>
							<option value="기업은행" ${SellerVO.s_account_n eq '기업은행' ? "selected='selected'" : '' }>기업은행</option>
							<option value="신한은행" ${SellerVO.s_account_n eq '신한은행' ? "selected='selected'" : '' }>신한은행</option>
							<option value="하나은행" ${SellerVO.s_account_n eq '하나은행' ? "selected='selected'" : '' }>하나은행</option>
							<option value="우리은행" ${SellerVO.s_account_n eq '우리은행' ? "selected='selected'" : '' }>우리은행</option>
						</select>
					</tr>
					<tr>
						<th>계좌 번호</th>
						<td><input class="form-control" type="text" name="s_account" id="s_account" placeholder="계좌번호"></td>
					</tr>
					<tr>
						<th></th>
						<td><input class="btn btn-primary" type="submit" id="submit" value="등록" /> 
						<input type="button" class="btn btn-info" value="목록" onclick="location.href='/shop/mng/seller/listMngSeller.do'" />
						</td>
					</tr>
				</table>
			</form>
			</div>
			<div class="col-lg-3 col-md-2 col-sm-1"></div>
		</div>
	</div>


<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>