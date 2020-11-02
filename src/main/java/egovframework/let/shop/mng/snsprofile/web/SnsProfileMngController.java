package egovframework.let.shop.mng.snsprofile.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.shop.mng.snsprofile.service.SnsProfileMngService;
import egovframework.let.shop.mng.snsprofile.service.SnsProfileMngVO;

@Controller
public class SnsProfileMngController {

	@Resource(name = "SnsProfileMngService")
	SnsProfileMngService snsProfileMngService;

	@RequestMapping("/shop/mng/snsprofile/loginSnsprofileMngForm")
	public String loginSnsprofileMngForm(Model model) {
		System.out.println("loginUserSnsprofileTest loginUserSnsprofileTestPro");
		return "/shop/user/snsprofile/loginUserSnsprofileTestForm";
	}

	@RequestMapping("/shop/mng/snsprofile/loginMngSnsprofilePro")
	public String loginMngSnsprofilePro(SnsProfileMngVO vo, Model model, HttpServletRequest request) {
		System.out.println("SnsProfileMngController loginMngSnsprofilePro");
		vo = snsProfileMngService.selectMngSnsprofile(vo);
		model.addAttribute("vo", vo);
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		session.setAttribute("sns_idx", vo.getSns_idx());
		session.setAttribute("nickname", vo.getNickname());
		session.setAttribute("email", vo.getEmail());
		session.setAttribute("status", 1);
		return "redirect:/shop/user/main/EgovUserMain.do";
	}

}