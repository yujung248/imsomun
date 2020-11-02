package egovframework.let.shop.intercepter;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

public class MngLoginInterceptor extends WebContentInterceptor {

	/*
	 * 운영자 로그인 인터셉터 
	 * 
	 * 운영자의 로그인 여부를 확인하기 위한 인터셉터
	 * 인터셉터 작성에 참고하세요
	 * WebContentInterceptor를 상속 받고 
	 * egov-com-servlet.xml 파일에서 인터셉터 설정이 필요하다.
	 * 
	 * 작성자 : 박종찬
	 * 작성일 : 2020. 10. 14. 
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {
		System.out.println("MngLoginInterceptor");

		// 세션을 통헤 로그인 정보를 취득
		HttpSession session = request.getSession();
		String a_id = (String) session.getAttribute("A_ID");

		if (a_id == null || a_id.equals("")) {
			// a_id 가 null 인 경우에는 운영자 로그인이 되어있지 않은 것으로 간주한다.
			System.out.println("관리자 권한 없음 => 로그인 페이지로 리다이렉트 합니다.");
			try {
				// 로그인 페이지로 리다이렉트 시킨다. (로그인 페이지는 MngLoginInterceptor의 예외 대상으로 지정되어있다.)
				
				response.sendRedirect("/shop/mng/admin/AdminLogin.do");

			} catch (IOException e) {
				e.printStackTrace();
			}
			// 컨트롤러로 요청을 넘기지 않기 위해 false를 반환한다.
			return false;
		}

		// preHandle에서 true를 반환한 경우에는 preHandler 처리 이후 정상적으로 컨트롤러가 호출된다. 
		return true;
	}

}
