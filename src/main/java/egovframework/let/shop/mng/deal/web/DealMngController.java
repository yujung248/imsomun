package egovframework.let.shop.mng.deal.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.let.shop.mng.deal.service.DealMng;
import egovframework.let.shop.mng.deal.service.DealMngService;
import egovframework.let.shop.mng.deal.service.impl.DealMngVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class DealMngController {

	private static final Logger logger = LoggerFactory.getLogger(DealMngController.class);

	@Resource(name = "DealMngService")
	private DealMngService dealMngService;

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

	@RequestMapping(value = "/shop/mng/deal/dealMngList.do")
	public String listDealMngBuyer(@ModelAttribute("searchVO") DealMngVO vo, HttpServletRequest request, Model model, 
			@RequestParam(value = "pageIndex", required=false, defaultValue="1") int pageIndex) {

		HttpSession session = request.getSession();
		String a_id = (String) session.getAttribute("A_ID");
		System.out.println("DealMngController listDealMngBuyer a_id -> " +a_id);
		vo.setA_id(a_id);
		
		vo.setPageIndex(pageIndex);
		System.out.println("listMng pageIndex => " + vo.getPageIndex());
		System.out.println("listDealUserBuyer vo.getSortD_ing() => " + vo.getSortD_ing());
		System.out.println("listDealUserBuyer vo.getSortD_regdate() => " + vo.getSortD_regdate());
		
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = dealMngService.selectListCntDealMng(vo); //
		paginationInfo.setTotalRecordCount(totCnt);

		System.out.println("s_id 출력 값 ->" + vo.getS_id());
		List<DealMngVO> list = dealMngService.selectListDealMng(vo); //
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("dealMnglist", list);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("vo", vo);
		return "/shop/mng/deal/dealMngList";

	}
	@RequestMapping(value="/shop/mng/deal/dealMngBuyerDetail.do")
	public String selectDealMngBuyerDetail(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController selectDealMngBuyerDetail Start...");
		vo = dealMngService.selectDealMngBuyerDetail(vo);
		/*vo = dealMngService.selectDealMngBuyerScore(vo);*/
		
		model.addAttribute("dealMngVO", vo);
		return "/shop/mng/deal/dealMngBuyerDetail";	
	}
	
	@RequestMapping(value="/shop/mng/deal/dealMngBuyerIng.do")
	public String updateDealMngBuyerDetail(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController updateDealMngBuyerDetail Start...");
		int result = dealMngService.updateDealMngBuyerDetail(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "redirect:/shop/mng/deal/dealMngBuyerList.do?d_idx=" + d_idx;	
	}

	@RequestMapping(value="/shop/mng/deal/dealMngBuyerCancel.do")
	public String updateDealMngBuyerCancel(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController updateDealMngBuyerCancel Start...");
		int result = dealMngService.updateDealMngBuyerCancel(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "forward:/shop/mng/deal/dealMngBuyerDetail.do";
	}

	@RequestMapping(value="/shop/mng/deal/dealMngBuyerComplete.do")
	public String updateDealMngBuyerComplete(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController updateDealMngBuyerComplete Start...");
		int result = dealMngService.updateDealMngBuyerComplete(vo);
		int result1 = dealMngService.updateDealMngBuyerD_edate(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "redirect:/shop/mng/deal/dealMngBuyerDetail.do?d_idx=" + d_idx;
	}
	
	@RequestMapping(value="/shop/mng/deal/dealMngSellerDetail.do")
	public String selectDealMngSellerDetail(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController selectDealMngSellerDetail Start...");
		System.out.println("s_id 값  출력 ->"+vo.getS_id());
		String ssid = vo.getS_id();
		vo = dealMngService.selectDealMngSellerDetail(vo);
		/*vo = dealMngService.selectDealMngBuyerScore(vo);*/
		
		model.addAttribute("dealMngVO", vo);
		model.addAttribute("s_id", ssid);
		System.out.println("s_id"+vo.getS_id());
		return "/shop/mng/deal/dealMngSellerDetail";	
	}
	
	@RequestMapping(value="/shop/mng/deal/dealMngSellerAccept.do")
	public String updateDealMngSellerAccept(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController updateDealMngSellerAccept Start...");
		int result = dealMngService.updateDealMngSellerAccept(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "forward:/shop/mng/deal/dealMngSellerDetail.do";
	}
	
	@RequestMapping(value="/shop/mng/deal/dealMngSellerCancel.do")
	public String updateDealMngSellerCancel(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController updateDealMngSellerCancel Start...");
		int result = dealMngService.updateDealMngSellerCancel(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "forward:/shop/mng/deal/dealMngSellerDetail.do";
	}

	@RequestMapping(value="/shop/mng/deal/dealMngSellerDeliver.do")
	public String updateDealMngSellerDeliver(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController updateDealMngSellerDeliver Start...");
		int result = dealMngService.updateDealMngSellerDeliver(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "forward:/shop/mng/deal/dealMngSellerDetail.do";
	}
	
		
}