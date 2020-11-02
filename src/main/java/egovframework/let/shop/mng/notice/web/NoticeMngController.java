package egovframework.let.shop.mng.notice.web;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.let.shop.mng.notice.service.NoticeMngService;
import egovframework.let.shop.mng.notice.service.impl.NoticeMngVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeMngController {

	@Resource(name = "NoticeMngService")
	private NoticeMngService noticeMngService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

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

	@RequestMapping(value = "/shop/mng/notice/listMngNotice")
	public String listMngNotice(@ModelAttribute("searchVO") NoticeMngVO vo, HttpServletRequest request, Model model,
			@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex) {
		vo.setPageIndex(pageIndex);
		System.out.println("listMngNotice pageIndex => " + vo.getPageIndex());
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = noticeMngService.selectMngNoticeListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<NoticeMngVO> list = noticeMngService.selectMngNoticeList(vo);

		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);

		return "shop/mng/notice/listMngNotice";
	}


	@RequestMapping(value = "/shop/mng/notice/deleteMngNotice")
	public String deleteMngNotice(RedirectAttributes redirect, int n_idx, Model model) {
		System.out.println("deleteMngNotice()" + n_idx);
		NoticeMngVO vo = new NoticeMngVO();
		vo.setN_idx(n_idx);
		int result = noticeMngService.deleteMngNotice(vo);
		System.out.println("result" + result);
		return "redirect:/shop/mng/notice/listMngNotice.do";
	}

	@RequestMapping(value = "/shop/mng/notice/updateMngNoticeForm")
	public String updateMngNoticeForm(@ModelAttribute("searchVO") NoticeMngVO vo, HttpServletRequest request, ModelMap model) {
		System.out.println("updateMngNoticeForm()" + vo);
		
		System.out.println("vo.getN_IDX" + vo.getN_idx());
		vo = noticeMngService.selectMngNoticeForm(vo);
		System.out.println("selectMngNoticeForm" + vo);
		System.out.println("pageIndex" + vo.getPageIndex());
		
		model.addAttribute("NoticeMngVO", vo);
		
		return "/shop/mng/notice/updateMngNoticeForm";

	}

	@RequestMapping(value = "/shop/mng/notice/updateMngNoticePro", method = RequestMethod.POST)
	public String updateMngNoticePro(NoticeMngVO vo, HttpServletRequest request, Model model,
			RedirectAttributes redirect) throws Exception {
		System.out.println("updateMngNoticePro()");
		
		HttpSession session = request.getSession();
		String a_id = (String) session.getAttribute("A_ID");
		System.out.println("a_id" + a_id);
		vo.setA_id(a_id);
		
		int result = noticeMngService.updateMngNoticePro(vo);

		if (result > 0) {
			redirect.addFlashAttribute("result", result);
		} else {
			redirect.addFlashAttribute("result", result);
		}
		
		model.addAttribute(vo);

		return "redirect:/shop/mng/notice/listMngNotice.do";
		
	}

	@RequestMapping(value = "/shop/mng/notice/insertMngNoticeForm")
	public String insertMngNoticeForm() {
		return "/shop/mng/notice/insertMngNoticeForm";
	}
	
	@RequestMapping(value = "/shop/mng/notice/insertMngNoticePro", method = RequestMethod.POST)
	public String insertMngNoticePro(HttpServletRequest request, NoticeMngVO vo, Model model,
			RedirectAttributes redirect) {
		System.out.println("NoticeMngController insertMngNoticePro()");
		
		HttpSession session = request.getSession();
		String a_id  = (String) session.getAttribute("A_ID");
		System.out.println("a_id" + a_id);
		System.out.println("INSERT");
		vo.setA_id(a_id);
		
		int result = noticeMngService.insertMngNoticePro(vo);
		
		
		if (result > 0) {
			redirect.addFlashAttribute("result", result);
			System.out.println("result->" + result);
		} else {
			redirect.addFlashAttribute("result", result);
			System.out.println("result->" + result);
		}
		
		return "redirect:/shop/mng/notice/listMngNotice.do";
	}
}