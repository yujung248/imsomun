package egovframework.let.shop.user.snsprofile.web;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;

import egovframework.let.shop.user.snsprofile.service.KakaoAPI;
import egovframework.let.shop.user.snsprofile.service.NaverAPI;
import egovframework.let.shop.user.snsprofile.service.SnsProfileUserService;
import egovframework.let.shop.user.snsprofile.service.SnsProfileUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * 템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)
 * @author 실행환경 개발팀 JJY
 * @since 2011.08.31
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.08.31  JJY            최초 생성
 *
 * </pre>
 */
@Controller
public class SnsProfileUserController {

	@Autowired
    private KakaoAPI kakao;
	
	@Autowired
    private NaverAPI naver;
	
	private String apiResult = null;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	@Resource(name ="EgovSnsUserService")
	protected SnsProfileUserService snsprofileUserService;
	
	
	/**
	 * XSS 방지 처리.
	 *
	 * @param data
	 * @return
	 */
	protected String unscript(String data) {
		if (data == null || data.trim().equals("")) {
			return "";
		}

		String ret = data;

		ret = ret.replaceAll("<(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;script");
		ret = ret.replaceAll("</(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;/script");

		ret = ret.replaceAll("<(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;object");
		ret = ret.replaceAll("</(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;/object");

		ret = ret.replaceAll("<(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;applet");
		ret = ret.replaceAll("</(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;/applet");

		ret = ret.replaceAll("<(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");
		ret = ret.replaceAll("</(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");

		ret = ret.replaceAll("<(F|f)(O|o)(R|r)(M|m)", "&lt;form");
		ret = ret.replaceAll("</(F|f)(O|o)(R|r)(M|m)", "&lt;form");

		return ret;
	}
	
	@RequestMapping(value = "/shop/user/EgovUserLoginForm.do")
	public String egovUserLoginForm(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		String kakaoUrl = kakao.getAuthorizationUrl(session);
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverUrl = naver.getAuthorizationUrl(session);
		model.addAttribute("kakaoUrl", kakaoUrl);
		model.addAttribute("naverUrl", naverUrl);
		return "shop/userLogin/EgovUserLoginForm"; 
	}
	/**
	 * sns 로그인
	 *
	 * @param request
	 * @param commandMap
	 * @exception Exception Exception
	 */
	@RequestMapping(value = "/shop/user/EgovKakaoLogin.do")
	public void egovUserLogin(@RequestParam("code") String code, SnsProfileUserVO snsProfileVO, HttpServletRequest request, ModelMap model, HttpSession session, HttpServletResponse response)
			  throws Exception{
		System.out.println("code : "+code);
		String access_Token = kakao.getAccessToken(code);
		HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    System.out.println("login Controller : " + userInfo);
	    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
	    if (userInfo.get("kakaoid") != null) {
	    	//db에  값을 넣는 로직
	    	snsProfileVO.setUserid((String) userInfo.get("kakaoid"));
	    	snsProfileVO.setSnscode("kakao");
	    	snsProfileVO.setNickname((String) userInfo.get("nickname"));
	    	
	    	String email=(String)userInfo.get("email");
	    	if(email!=null&& !email.equals("")){
	    		snsProfileVO.setEmail(email);	
	    	}else{
	    		snsProfileVO.setEmail("");
	    	}
	    	
	    	//---------------------
	       
	        int result2 = snsprofileUserService.checkUserLogin(snsProfileVO);
	        SnsProfileUserVO vo = new SnsProfileUserVO();
	        String userid= snsProfileVO.getUserid();
	        if(userid != null){
	        	 vo = (snsprofileUserService).selectSnsidx(userid);
	        }
	        
	        System.out.println("result2 : "+result2);
	        response.setContentType("text/html; charset=UTF-8");
    		PrintWriter writer = response.getWriter();
	        if(result2 ==0){
	        	
	        	int result=snsprofileUserService.insertSnsUser(snsProfileVO);
	        	vo = (snsprofileUserService).selectSnsidx(userid);
	        	 session.setAttribute("userid", userInfo.get("kakaoid"));
	 	        session.setAttribute("nickname", userInfo.get("nickname"));
	 	        session.setAttribute("status", 1);
	 	        /* session.setAttribute("email", userInfo.get("email"));*/
	 	        //session.setAttribute("email", userInfo.get("email"));//카카오에서 이메일 못가져옴
	 	        session.setAttribute("snscode","kakao"); //세션 생성
	 	        session.setAttribute("access_Token", access_Token);
	        	session.setAttribute("sns_idx",vo.getSns_idx());
	        	System.out.println("result : "+result);
        		System.out.println("성공");
        		
        		writer.println("<script>alert('로그인 되었습니다.');</script>");
        		writer.println("<script>location.href='/shop/user/main/EgovUserMain.do';</script>");
        		writer.flush();
	        }else{
	        	 vo = (snsprofileUserService).selectSnsidx(userid);
	        	 session.setAttribute("userid", userInfo.get("kakaoid"));
	 	        session.setAttribute("nickname", userInfo.get("nickname"));
	 	        session.setAttribute("status", 1);
	 	        /* session.setAttribute("email", userInfo.get("email"));*/
	 	        //session.setAttribute("email", userInfo.get("email"));//카카오에서 이메일 못가져옴
	 	        session.setAttribute("snscode","kakao"); //세션 생성
	 	        session.setAttribute("access_Token", access_Token);
	        	session.setAttribute("sns_idx",vo.getSns_idx());
	        	writer.println("<script>alert('로그인 되었습니다.');</script>");
        		writer.println("<script>location.href='/shop/user/main/EgovUserMain.do';</script>");
        		writer.flush();
	        }
	    }
	}
	
	@RequestMapping(value = "/shop/user/EgovNaverLogin.do")
	public String egovUserLogin(@RequestParam("code") String code, @RequestParam("state") String state, SnsProfileUserVO snsProfileVO, HttpServletRequest request, ModelMap model, HttpSession session, HttpServletResponse response)
			  throws Exception{
	    OAuth2AccessToken oauthToken;
        oauthToken = naver.getAccessToken(session, code, state);
        
        //로그인 사용자 정보를 읽어온다.
        apiResult = naver.getUserProfile(oauthToken);
        if(apiResult != null){
	        System.out.println("result"+apiResult);
	        
	        //1. 로그인 사용자 정보를 읽어온다.
	        apiResult = naver.getUserProfile(oauthToken); //String형식의 json데이터
	        /** apiResult json 구조
	        {"resultcode":"00",
	        "message":"success",
	        "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
	        **/
	        //2. String형식인 apiResult를 json형태로 바꿈
	        JSONParser parser = new JSONParser();
	        Object obj = parser.parse(apiResult);
	        JSONObject jsonObj = (JSONObject) obj;
	        //3. 데이터 파싱
	        //Top레벨 단계 _response 파싱
	        JSONObject response_obj = (JSONObject)jsonObj.get("response");
	        //response의 nickname값 파싱
	        String id = (String)response_obj.get("id");
	        String name = (String)response_obj.get("name");
	        String email = (String)response_obj.get("email")==null?"":(String)response_obj.get("email");
	        //navre 정보 dbd에 담는 로직
	        snsProfileVO.setSnscode("naver");
	        snsProfileVO.setEmail(email);
	        snsProfileVO.setNickname(name);
	        snsProfileVO.setUserid(id);
	        //----------------
	        //4.파싱 닉네임 세션으로 저장
	        session.setAttribute("sns_idx",id); //세션 생성
	        session.setAttribute("nickname",name); //세션 생성
	        session.setAttribute("snscode","naver"); //세션 생성
	        session.setAttribute("email",email); //세션 생성
	        session.setAttribute("access_token", oauthToken.getAccessToken());
	        model.addAttribute("result", apiResult);
	        System.out.println("access_token : "+oauthToken.getAccessToken());
	        int result2 = snsprofileUserService.checkUserLogin(snsProfileVO);
	        response.setContentType("text/html; charset=UTF-8");
    		PrintWriter writer = response.getWriter();
	        if(result2 ==0){
	        	int result=snsprofileUserService.insertSnsUser(snsProfileVO);
	        	System.out.println("result : "+result);
        		System.out.println("성공");
        		
        		writer.println("<script>alert('로그인 되었습니다.');</script>");
        		writer.println("<script>location.href='/shop/user/main/EgovUserMain.do';</script>");
        		writer.flush();
	        }else{
	        	writer.println("<script>alert('로그인 되었습니다.');</script>");
        		writer.println("<script>location.href='/shop/user/main/EgovUserMain.do';</script>");
        		writer.flush();
	        }
        }
        
		return "redirect:/shop/user/main/EgovUserMain.do";
	}
	
	@RequestMapping(value="/shop/user/EgovUserLogout.do")
	public String egovUserLogout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/shop/user/main/EgovUserMain.do";
	}

}