package egovframework.let.shop.user.log.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.let.shop.user.log.service.LogUserService;
import egovframework.let.shop.user.log.service.impl.LogUserVO;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class LogUserController {
	
	/**
	 * EgovBBSManageService
	 */
	@Resource(name = "EgovUserLogService")
	private LogUserService userLogService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
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
	
	@RequestMapping(value = "/shop/user/log/EgovUserLoglist")
	public String forwardPageWithMenuNo(@ModelAttribute("searchVO") LogUserVO vo, HttpServletRequest request,
			ModelMap model,ReviewUserVO vo2) throws Exception {
		System.out.println("test");
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = userLogService.selectUserLogListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<LogUserVO> list = userLogService.selectUserLogList(vo);
		System.out.println("test"+list.get(0).getS_id());
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
				
		return "/shop/user/log/EgovUserLoglist";
	}
	
	@RequestMapping(value ="/shop/user/log/EgovUserLogUpdatePro", method = RequestMethod.POST)
	public String egovUserLogUpdatePro(LogUserVO vo, Model model) throws Exception{
		int result = userLogService.updateUserLogPro(vo);
		System.out.println("vo Log_Date => " + vo.getLog_date());
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		model.addAttribute("vo");

		return "forward:/shop/user/log/EgovUserLogUpdateForm.do";

	}
	
	@RequestMapping(value = "/shop/user/log/EgovUserLogInsertPro", method = RequestMethod.POST)
	public String EgovUserLogInsertPro(LogUserVO vo,Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		String s_id = (String) session.getAttribute("S_ID");
		vo.setS_id(s_id);
		String result = userLogService.insertUserLogPro(vo);
		System.out.println("EgovUserLogInsertPro");
		System.out.println("result => " + result);
		
		return "redirect:/shop/user/product/EgovUserProductInsertForm.do";
	}
	
}
