package egovframework.let.shop.mng.basket.web;

import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import egovframework.com.cmm.ComDefaultVO;
import egovframework.let.shop.mng.basket.service.BasketMngService;
import egovframework.let.shop.mng.basket.service.impl.BasketBuyerMngVO;
import egovframework.let.shop.mng.basket.service.impl.BasketMngVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@SessionAttributes(types = ComDefaultVO.class)

public class BasketMngController {

	private static final Logger logger = LoggerFactory.getLogger(BasketMngController.class);

	@Resource(name = "BasketMngService")
	private BasketMngService basketService;

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

	// requestmapping
	// "/shop/basket/Basket***"

	@RequestMapping(value = "/shop/mng/basket/listMngBasket")
	public String listMngBasket(@ModelAttribute("searchVO") BasketBuyerMngVO vo, HttpServletRequest request, Model model) {
		/*logger.info("listMngBasket");
		Map<String, ?> redirectMap = RequestContextUtils.getInputFlashMap(request);
		if(redirectMap != null){
			logger.info("redirectMap is not Null");
			int pageIndex = 1;
			pageIndex = (int) redirectMap.get("pageIndex");			
			logger.info("pageIndex => " + pageIndex);
			vo.setPageIndex(pageIndex);
		} */
		
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = basketService.selectListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<BasketBuyerMngVO> list = basketService.selectList(vo);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		logger.info("totCnt => " + totCnt);
		logger.info("list size => " + list.size());
		logger.info("vo.getPageIndex => " + vo.getPageIndex());
		
		return "shop/mng/basket/listMngBasket";

	}
	
//	@RequestMapping(value = "/shop/mng/basket/updateMngBasketQty", method=RequestMethod.POST)
//	public String updateMngBasketQty(BasketMngVO vo, Model model){
//		logger.info("updateMngBasketQty");
//		int result = basketService.updateMngBasketQty(vo);
//		logger.info("result => " + result);
//		logger.info("vo.getPageIndex => " + vo.getPageIndex());
//		return "redirect:/shop/mng/basket/listMngBasket.do?pageIndex="+vo.getPageIndex();
//	}
//	
	@RequestMapping(value = "/shop/mng/basket/updateMngBasketQty")
	@ResponseBody
	public int updateMngBasketQty(int ba_idx, int ba_q, Model model){
		BasketMngVO vo = new BasketMngVO();
		vo.setBa_idx(ba_idx);
		vo.setBa_q(ba_q);
		logger.info("updateMngBasketQty");
		int result = basketService.updateMngBasketQty(vo); 
		logger.info("result =" + result);
		return result;
	}
	
	@RequestMapping("/shop/mng/basket/deleteMngBasket")
	public String deleteMngBasket(RedirectAttributes redirect, int ba_idx, Model model){
		logger.info("deleteMngBasket ba_idx=> " + ba_idx);
		BasketMngVO vo = new BasketMngVO();
		vo.setBa_idx(ba_idx);
		int result = basketService.deleteMngBasket(vo);
		logger.info("result => " + result);	
		return "redirect:/shop/mng/basket/listMngBasket.do";
	}


}
