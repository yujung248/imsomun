<%--
  Class Name : EgovMainView.jsp
  Description : 메인화면
  Modification Information

      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2011.08.31   JJY       경량환경 버전 생성

    author   : 실행환경개발팀 JJY
    since    : 2011.08.31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
<%@ include file="../../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript">
function check() {
	location.href = "<c:url value='/shop/seller/EgovsellerLoginFrom.do'/>";
}
</script>
</head>
<body>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
<form id="fm" name="fm" action="/user2/help/pwInquiry.nhn?m=actionInputPasswd" method="post">
            <input type="hidden" id="encNewPasswd" name="encNewPasswd" value="">
            <input type="hidden" id="encNm" name="encNm" value="">
			<input type="hidden" id="id" name="id" value="nwos1412">
			<input type="hidden" id="token_help" name="token_help" value="ZZqGbsftgFFfUGu2" />
			<input type="hidden" id="captcha_type" name="captcha_type" value="image">
			<input type="hidden" id="chptchakey" name="chptchakey" value="1BI9hBFLXhnkSnnG">
			
			<div class="section section_find">
				<div class="box6">
					<dl class="n_id">
					<dt>네이버 아이디 : </dt>
					<dd>nwos1412</dd>
					</dl>
					<div id="div_new_pw" class="input_box">	
						<label id="lb_new_pw" for="new_pw" style="">새 비밀번호</label>					
						<input id="new_pw" name="new_pw" type="password" value=""
						       maxlength="20"
							   onkeyup="checkShiftUp(event);checkpwd_nologin('new_pw','id');" 
							   onkeypress="capslock(event);"
							   onKeydown="checkShiftDown(event);"
							   onFocus="checkpwd_nologin('new_pw','id');convertDiv('new_pw', 'new_conf_pw', 'none');" 
							   onBlur="showhelpmsg(-1);convertDiv('new_pw', 'new_conf_pw','block')"						       
						       title="새 비밀번호 입력" class="input_txt">
<!-- ///////////////////////////////////////////////////////////////////////////////////////// -->	
						<div id="help1_1" class="help left h32" style="left:305px;top:-1px; display: none;">
							<!-- 비밀번호 안전도 -->
							<div class="txt">
								<p><strong>사용불가</strong> : 비밀번호 재작성 필요<br><span class="ex">8~16 자의 영문 대소문자, 숫자 및 특수문자 사용</span></p>
							</div>
							<!-- //비밀번호 안전도 -->
							<span class="arrow"></span>
						</div>
						<div id="help1_2" class="help left h32" style="left:305px;top:-1px; display: none;">
							<!-- 비밀번호 안전도 -->
							<div class="txt">
								<p>비밀번호 안전도<em>|</em> <strong>낮음</strong> <img src="https://static.nid.naver.com/images/user/images/help/safetybar1.gif" width="47" height="3" alt=""><br><span class="ex">안전도가 높은 비밀번호를 권장합니다.</span></p>
							</div>
							<!-- //비밀번호 안전도 -->
							<span class="arrow"></span>
						</div>
						<div id="help1_3" class="help left h32" style="left:305px;top:-1px; display:none;">
							<!-- 비밀번호 안전도 -->
							<div class="txt">
								<p>비밀번호 안전도<em>|</em> <strong>적정</strong> <img src="https://static.nid.naver.com/images/user/images/help/safetybar2.gif" width="47" height="3" alt=""><br><span class="ex">안전하게 사용하실 수 있는 비밀번호 입니다.</span></p>
							</div>
							<!-- //비밀번호 안전도 -->
							<span class="arrow"></span>
						</div>
						<div id="help1_4" class="help left h32" style="left:305px;top:-1px; display:none;">
							<!-- 비밀번호 안전도 -->
							<div class="txt">
								<p>비밀번호 안전도<em>|</em> <strong>높음</strong> <img src="https://static.nid.naver.com/images/user/images/help/safetybar3.gif" width="47" height="3" alt=""><br><span class="ex">예측하기 힘든 비밀번호로 더욱 안전합니다.</span></p>
							</div>
							<!-- //비밀번호 안전도 -->
							<span class="arrow"></span>
						</div>
						<div id="help1_5" class="help left h32" style="left:305px;top:-1px; display: none;">
							<!-- 비밀번호 안전도 -->
							<div class="txt">
								<p>
									비밀번호 안전도<em>|</em> <strong>낮음</strong> <img src="https://static.nid.naver.com/images/user/images/help/safetybar1.gif" width="47" height="3" alt=""><br>
									<span class="ex">이전에 사용하셨던 비밀번호입니다. <br>도용 예방을 위해 새로운 비밀번호 <br>사용을 권장합니다.</span>
								</p>
								<p class="topline">비밀번호는 네이버 관리자도 알 수 없도록 <br>암호화하여 기존 비밀번호와의 <br>일치 여부만을 확인하고 있습니다.</p>
							</div>
							<!-- //비밀번호 안전도 -->
							<span class="arrow"></span>
						</div>
						<div id="help1_6" class="help left h32" style="left:305px;top:-1px; display: none;">
							<!-- 비밀번호 안전도 -->
							<div class="txt">
								<p>비밀번호는 8자 이상 입력하셔야 합니다.</p>
							</div>
							<!-- //비밀번호 안전도 -->
							<span class="arrow"></span>
						</div>
						<div id="help1_7" class="help left h32" style="left:305px;top:-1px; display: none;">
							<div class="txt">
								<p><strong>사용불가</strong> : 비밀번호 재작성 필요<br><span>입력하신 비밀번호는 도용된 <br>비밀번호이므로 추가 도용 가능성이 <br>높아 사용하실 수 없습니다.</span></p>
								<p class="topline">비밀번호는 네이버 관리자도 알 수 없도록 <br>암호화하여 기존 비밀번호와의 <br>일치 여부만을 확인하고 있습니다.</p>
							</div>
							<span class="arrow"></span>
						</div>
						<!-- 비밀번호 관련레이어 팝업 -->
						<div id="help2_1" class="help left h32" style="left:305px;top:-1px; display: none;">
							<div class="txt">
								<!-- <p><span id="p01"><strong>사용불가</strong> : 비밀번호 재작성 필요 </span><br /> -->
								<p>
									<strong>사용불가</strong> : 비밀번호 재작성 필요 <br><span id="p02" class="ex">8~16 자의 영문 대소문자, 숫자 및 <br>특수문자 사용</span>
									<span class="ex2">키보드에<strong>CapsLock</strong>이 켜져 있습니다.</span>
								</p>
							</div>
							<span class="arrow"></span>
						</div>
						<div id="help2_2" class="help left h32" style="left:305px;top:-1px; display: none;">
							<div class="txt">
								<p>비밀번호 안전도<em>|</em> <strong>낮음</strong> <img alt="" src="https://static.nid.naver.com/images/user/images/help/safetybar1.gif" width="47" height="3"><br><span class="ex">안전도가 높은 비밀번호를 권장합니다.</span><span class="ex2">키보드에<strong>CapsLock</strong>이 켜져 있습니다.</span></p>
							</div>
							<span class="arrow"></span>
						</div>
						<div id="help2_3" class="help left h32" style="left:305px;top:-1px; display: none;">
							<div class="txt">
								<p>비밀번호 안전도<em>|</em> <strong>적정</strong> <img alt="" src="https://static.nid.naver.com/images/user/images/help/safetybar2.gif" width="47" height="3"><br><span class="ex">안전하게 사용하실 수 있는 비밀번호 입니다.</span><span class="ex2">키보드에<strong>CapsLock</strong>이 켜져 있습니다.</span></p>
							</div>
							<span class="arrow"></span>
						</div>
						<div id="help2_4" class="help left h32" style="left:305px;top:-1px; display: none;">
							<div class="txt">
								<p>비밀번호 안전도<em>|</em> <strong>높음</strong> <img alt="" src="https://static.nid.naver.com/images/user/images/help/safetybar3.gif" width="47" height="3"><br><span class="ex">예측하기 힘든 비밀번호로 더욱 안전합니다.</span><span class="ex2">키보드에<strong>CapsLock</strong>이 켜져 있습니다.</span></p>
							</div>
							<span class="arrow"></span>
						</div>
						<div id="help2_5" class="help left h32" style="left:305px;top:-1px; display: none;">
							<div class="txt">
								<p>비밀번호 안전도<em>|</em> <strong>낮음</strong> <img alt="" src="https://static.nid.naver.com/images/user/images/help/safetybar1.gif" width="47" height="3"><br><span class="ex">이전에 사용하셨던 비밀번호입니다. <br>도용 예방을 위해 새로운 비밀번호 <br>사용을 권장합니다.</span></p>
								<!-- <p>비밀번호 안전도 <em>|</em> <strong>중간</strong> <img src="https://static.nid.naver.com/images/user/images/help/safetybar2.gif" width="47" height="3" alt="" /></p>
												<p>비밀번호 안전도 <em>|</em> <strong>높음</strong> <img src="https://static.nid.naver.com/images/user/images/help/safetybar3.gif" width="47" height="3" alt="" /></p> -->
								<p class="topline">비밀번호는 네이버 관리자도 알 수 없도록 <br>암호화하여 기존 비밀번호와의 <br>일치 여부만을 확인하고 있습니다.</p>
							</div>
							<span class="arrow"></span>
						</div>
						<div id="help2_6" class="help left h32" style="left:305px;top:-1px; display: none;">
							<div class="txt">
								<p>비밀번호는 8자 이상 입력하셔야 합니다.<span class="ex2">키보드에<strong>CapsLock</strong>이 켜져 있습니다.</span></p>
							</div>
							<span class="arrow"></span>
						</div>
						<div id="help2_7" class="help left h32" style="left:305px;top:-1px; display: none;">
							<div class="txt">
								<p><strong>사용불가</strong> : 비밀번호 재작성 필요<br><span>입력하신 비밀번호는 도용된 <br>비밀번호이므로 추가 도용 가능성이 <br>높아 사용하실 수 없습니다.</span></p>
								<p class="topline">비밀번호는 네이버 관리자도 알 수 없도록 <br>암호화하여 기존 비밀번호와의 <br>일치 여부만을 확인하고 있습니다. 
								<span class="ex2">키보드에<strong>CapsLock</strong>이 켜져 있습니다.</span></p>
							</div>
							<span class="arrow"></span>
						</div>	
					</div>	

					<div id="div_new_conf_pw" class="input_box">	
						<label id="lb_new_conf_pw" for="new_conf_pw" style="">새 비밀번호 확인</label>					
						<input id="new_conf_pw" name="new_conf_pw" type="password" value="" maxlength="20" onFocus="convertDiv('new_conf_pw', 'new_pw', 'none')" onBlur="convertDiv('new_conf_pw', 'new_pw','block')" title="새 비밀번호 확인" class="input_txt">
					</div>
					<!-- 이미지로 보기 -->
					<div id="captcha_image_legend" class="captcha" style="display:block">
						<p class="error_txt">아래 이미지를 보이는 대로 입력해주세요</p>
						<div id="image_captcha_div" class="error_v2">
							<span class="error_img"><img name='captchaImage' id='chptchaimg' src='/login/image/captcha/nhncaptchav4.gif?key=1BI9hBFLXhnkSnnG&1' width='205' height='80' alt='자동 가입 방지'></span>
							<a href="javascript:reCaptcha('');" id="aReCaptcha" onclick="" class="btn_refresh"><span>새로고침</span></a>
							<a href="javascript:changeCaptchaMode('', 'autoValue');" class="btn_sound"><span>음성으로 듣기</span></a>
							<span class="blind"> 자동입력방지문자 음성 안내입니다. 음성으로 듣기 버튼을 누르신 후 들려드리는 숫자 6자리를 자동입력 방지문자 입력창에 입력해 주세요. 다시 듣고 싶으면, 키보드 컨트롤키와 알트키를 누르고 알파벳 R을 눌러주세요.</span>
						</div>
					</div>				
					<!-- // 이미지로 보기 -->
					<!-- [D]음성으로 듣기했을경우 display:block -->
					<div id="captcha_sound_legend" class="captcha error_sound" style="display:none">
						<p class="error_txt">스피커로 들리는 내용을 숫자로 입력해 주세요.</p>
						<div id="sound_captcha_div" class="error_v2" style="display:none">
							<span class="error_img">음성으로 안내되고 있습니다. (시작음 3회 반복 후 재생)</span>
							<a href="javascript:playSoundCaptcha('');" id="play_audio" class="btn_refresh"><span>새로고침</span></a>
							<a href="javascript:changeCaptchaMode('');" class="btn_img"><span>이미지로 보기</span></a>
						</div>
					</div>					
					<!-- //음성으로 듣기 -->
	
					<!-- [D]focus시 클래스 focus 추가, label은 display:none시켜주세요 -->
					<div id="bdr_autoValue" class="input_box input_box_v2">
						<label id="lbCapcha" for="autoValue" class="lbl_in" style="display: block;">자동입력 방지문자</label> 
						<span class="int_box" style="width:289px">
	                         <!-- 캡챠 어뷰징 방지를 위해 maxlength는 제거함 : 2014-02-11- euli0912 -->					    
							<input type="text"  id="autoValue" name="autoValue"  onkeydown="checkNumber();" title="자동입력 방지문자" onfocus="hiddenText('lbCapcha');changeFocus('bdr_autoValue','on')" onblur="showText('lbCapcha','autoValue');changeFocus('bdr_autoValue','off')"  class="int" style="width:289px">
						</span>
					</div>				
					<!-- //자동입력 방지문자-->
					<ul class="find_notice">
					<li>영문, 숫자, 특수문자를 함께 사용하면(8자 이상 16자 이하)보다 안전합니다.</li>
					<li>다른 사이트와 다른 <strong>네이버 아이디만의 비밀번호</strong>를 만들어 주세요.</li>
					<li class="n_bu">
						<div id="divShowBlock" class="ip_che" style="display:none">
							<input type="checkbox" id="chkBlockIp" name="chkBlockIp" onclick="clickcr(this,'rst.ipblock','','',event);" class="input_chk" checked />
							<label for="chkBlockIp">보안 강화를 위해 해외 IP에서의 로그인 차단</label>
							<a href="javascript:toggle();" onclick="clickcr(this,'rst.ipblockhelp','','',event);" class="ico_help2"><span class="blind">도움말</span></a>
							<!-- 해외ip차단 도움말 -->
							<div id="tmpBlockIp" style="position:relative">
								<!-- [D] 레이어 팝업 비활성화시 style="display:none" -->
								<div id="blockIp" class="ly_pop_ab" style="display:none;">
									<span class="edge"></span> 
                                    <p>해외에서 접속할 경우 회원정보에 등록된 이름/생일을 입력하여 본인 여부를 확인합니다. <br>기억나지 않을 경우 등록된 사용자 연락처 정보로 로그인 하실 수 있습니다.</p>
                                    <p class="desc">해외 사용자이시거나, 여행, 출장 등으로 해외에서 체류할 경우 해제해 주세요.</p> 
								</div>
							</div>
						</div>
					</li>
					</ul>
				</div>
				<div class="btn_area">
					<a href="#" id="changeSubmit" onclick="check();" class="btn_confirm2"><span class="blind">확인</span></a>
				</div>
</form>
</body>
</html>