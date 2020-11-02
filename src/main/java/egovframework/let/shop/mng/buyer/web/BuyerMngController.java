package egovframework.let.shop.mng.buyer.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.let.shop.mng.buyer.service.BuyerMngService;
import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BuyerMngController {

	@Resource(name = "BuyerMngService")
	private BuyerMngService buyerService;

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

	@RequestMapping(value = "/shop/mng/buyer/listMngBuyer")
	public String listMngBuyer(@ModelAttribute("searchVO") BuyerMngVO vo, HttpServletRequest request, Model model, 
			@RequestParam(value = "pageIndex", required=false, defaultValue="1") int pageIndex) {
		System.out.println("listMngBuyer pageIndex => " + vo.getPageIndex());
		System.out.println("listMngBuyer searchWrd => " + vo.getSearchWrd());
		System.out.println("listMngBuyer searchCnd => " + vo.getSearchCnd());
		vo.setPageIndex(pageIndex);
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = buyerService.selectListCnt(vo); //
		paginationInfo.setTotalRecordCount(totCnt);

		List<BuyerMngVO> list = buyerService.selectList(vo); //

		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);

		return "shop/mng/buyer/listMngBuyer";
	
	}

	@RequestMapping("/shop/mng/buyer/updateMngBuyerForm")
	public String updateMngBuyerForm(BuyerMngVO vo, Model model) {
		System.out.println("buyerMngModifyForm ()");
		vo = buyerService.buyerSelect(vo);
		model.addAttribute("BuyerVO", vo);
		return "shop/mng/buyer/updateMngBuyerForm";
	}

	@RequestMapping(value = "/shop/mng/buyer/updateMngBuyerPro", method = RequestMethod.POST)
	public String updateMngBuyerPro(BuyerMngVO vo, Model model) {
		System.out.println("updateMngBuyerForm ()");
		System.out.println("vo sns_idx=>" + vo.getSns_idx());
		int result = buyerService.buyerUpdate(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		model.addAttribute("vo");

		return "forward:updateMngBuyerForm.do";

	}

	@RequestMapping("/shop/mng/buyer/updateMngBuyerStateChange")
	public String updateMngBuyerStateChange(BuyerMngVO vo, Model model) {
		System.out.println("updateMngBuyerStateChange()");

		System.out.println("vo sns_idx=>" + vo.getSns_idx());
		System.out.println("vo pageIndex=>" + vo.getPageIndex());
		int result = buyerService.updateMngBuyerStateChange(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		String pageIndex = Integer.toString(vo.getPageIndex());
		return "redirect:/shop/mng/buyer/listMngBuyer.do?pageIndex=" + pageIndex;
	}

}
