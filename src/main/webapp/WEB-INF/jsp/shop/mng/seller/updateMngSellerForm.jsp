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
<script type="text/javascript">
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
			
			<form class="mx-auto" action="/shop/mng/seller/updateMngSellerPro.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name="s_id" value="${SellerVO.s_id }" />
				<input type="hidden" name="s_photo" value="${SellerVO.s_photo }" />
					
				<table class="table">				
					<tr>
						<th></th>
						<td height="200" style="">
						<img id="blah" src="<c:url value='/'/>file/${SellerVO.s_photo}" alt="your image" width="300" height="200" /> </td> 
					</tr>
					<tr>
						<th>파일 업로드</th>	
							<td><label for="ex_file">업로드</label>
							<input type='file' name="file" id="ex_file" onchange="readURL(this);" /></td>    
					</tr>
					
					<tr>
						<th>회원아이디</th>
						<td>${SellerVO.s_id }</td>
					</tr>
					
					<tr> 
						<th>닉네임</th>
						<td><input class="form-control" type="text" name="s_nickname" value="${SellerVO.s_nickname }" /></td>
					</tr>
					
					<tr> 
						<th>비밀번호</th>
						<td><input class="form-control" type="text" id="s_pass" name="s_pass" value="${SellerVO.s_pass }"></td>
					</tr>
					<tr>
						<th>생일</th>
						<td><input class="form-control" type="date" id="s_birth" name="s_birth" value="${SellerVO.s_birth }"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input class="form-control" type="email" name="s_email" value="${SellerVO.s_email }" /></td>
					</tr>
					<tr>
						<th>상태</th>
						<td><input type="radio" name="s_status" value="Y"
							${SellerVO.s_status eq 'Y' ? "checked = 'checked'" : '' } />활동중인 계정
							<input type="radio" name="s_status" value="N" 
							${SellerVO.s_status eq 'N' ? "checked = 'checked'" : '' } />탈퇴된 계정
						</td>
					</tr>
					<tr>
						<th>핸드폰 번호</th>
						<td><input class="form-control" type="text" maxlength="13" onKeyup="inputPhoneNumber(this);" name="s_phone" value="${SellerVO.s_phone }" />
                     	 </td>
							
							
					</tr>
					<tr>
						<th>은행</th>
						<td>
						<select class="form-control" name="s_account_n">
							<option value="국민은행" ${SellerVO.s_account_n eq '국민은행' ? "selected='selected'" : '' }>국민은행</option>
							<option value="농협은행" ${SellerVO.s_account_n eq '농협은행' ? "selected='selected'" : '' }>농협은행</option>
							<option value="기업은행" ${SellerVO.s_account_n eq '기업은행' ? "selected='selected'" : '' }>기업은행</option>
							<option value="국민은행" ${SellerVO.s_account_n eq '국민은행' ? "selected='selected'" : '' }>국민은행</option>
							<option value="카카오뱅크" ${SellerVO.s_account_n eq '카카오뱅크' ? "selected='selected'" : '' }>카카오뱅크</option>
							<option value="신한은행" ${SellerVO.s_account_n eq '신한은행' ? "selected='selected'" : '' }>신한은행</option>
							<option value="하나은행" ${SellerVO.s_account_n eq '하나은행' ? "selected='selected'" : '' }>하나은행</option>
							<option value="우리은행" ${SellerVO.s_account_n eq '우리은행' ? "selected='selected'" : '' }>우리은행</option>
							<option value="sc제일은행" ${SellerVO.s_account_n eq 'sc제일은행' ? "selected='selected'" : '' }>sc제일은행</option>
							<option value="우체국은행" ${SellerVO.s_account_n eq '우체국은행' ? "selected='selected'" : '' }>우체국은행</option>
							<option value="케이뱅크" ${SellerVO.s_account_n eq '케이뱅크' ? "selected='selected'" : '' }>케이뱅크</option>
							<option value="저축은행" ${SellerVO.s_account_n eq '저축은행' ? "selected='selected'" : '' }>저축은행</option>
						</select>
					</tr>
					<tr>
						<th>계좌 번호</th>
						<td><input class="form-control" type="text" name="s_account" value="${SellerVO.s_account }" /></td>
					</tr>
					
					<tr>
						<th>주소</th>
						<td>
						<div class="join_row">
						<div class="input-group">
							<input class="form-control" type="text" id="sample6_address" name="addr1"  value="${SellerVO.s_addr }" readonly>
						<div class="input-group-append">
							<input type="button" class="btn btn-secondary" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
						</div></div></div></td>
					</tr>
					
					<tr>
						<th>상세주소</th>
						<td><input class="form-control" type="text" id="sample6_detailAddress" name="addr2"></td>
					</tr>
					
					<tr>
						<th>성별</th>
						<td>${SellerVO.s_gender }</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>${SellerVO.s_regdate }</td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" class="btn btn-primary"  value="수정" /> 
						<input type="button" value="목록" class="btn btn-info"  onclick="location.href='/shop/mng/seller/listMngSeller.do'" />
						<input type="button" value="로그인" class="btn btn-secondary" onclick="location.href='/shop/user/seller/EgovsellerLoginPro.do?id=${SellerVO.s_id}&passwd=${SellerVO.s_pass }'">
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