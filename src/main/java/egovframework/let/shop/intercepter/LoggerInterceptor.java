package egovframework.let.shop.intercepter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import egovframework.let.shop.mng.log.service.LogMngService;
import egovframework.let.shop.mng.log.service.impl.LogMngVO;

public class LoggerInterceptor extends WebContentInterceptor {

	@Resource(name = "EgovMngLogService")
	private LogMngService mngLogService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {
		// System.out.println("logger prehandle");
		// LogMngVO vo = new LogMngVO();
		// HttpSession session = request.getSession();
		// if (session.getAttribute("S_ID") != null) {
		// vo.setS_id((String) session.getAttribute("S_ID"));
		// } else {
		// vo.setS_id("");
		// }
		//
		// if (session.getAttribute("sns_idx") != null) {
		// vo.setSns_idx((String) session.getAttribute("sns_idx"));
		// } else {
		// vo.setSns_idx("");
		// }
		//
		// System.out.println(request.getRequestURI());
		//
		// System.out.println("LoggerInterceptor insert");
		// String result = mngLogService.insertMngLogPro(vo);
		// System.out.println("result => " + result);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("logger postHandle");
		LogMngVO vo = new LogMngVO();
		HttpSession session = request.getSession();
		if (session.getAttribute("S_ID") != null) {
			vo.setS_id(session.getAttribute("S_ID").toString());
		} else {
			vo.setS_id("");
		}

		if (session.getAttribute("sns_idx") != null) {
			vo.setSns_idx(session.getAttribute("sns_idx").toString());
		} else {
			vo.setSns_idx("");
		}

		String uri = request.getRequestURI();
		System.out.println(uri);
		vo.setAc_page(uri);

		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = request.getRemoteAddr();

		vo.setLog_ip(ip);

		System.out.println("LoggerInterceptor insert");
		String result = mngLogService.insertMngLogPro(vo);
		System.out.println("result => " + result);

	}

}