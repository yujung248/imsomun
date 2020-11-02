package egovframework.let.shop.user.buyer.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;
import egovframework.let.shop.user.basket.service.impl.BasketProductUserVO;
import egovframework.let.shop.user.basket.service.impl.BasketUserVO;
import egovframework.let.shop.user.basket.web.BasketUserController;
import egovframework.let.shop.user.buyer.service.BuyerUserService;
import egovframework.let.shop.user.buyer.service.impl.BuyerUserVO;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.like.service.impl.LikeUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class BuyerUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(BasketUserController.class);

	
	@Resource(name="BuyerUserSerivce")
	private BuyerUserService buyerService;
	
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
	
	@RequestMapping("/shop/user/buyer/selectUserBuyer")
	public String selectUserBuyer(BuyerUserVO vo, Model model, HttpServletRequest request) {
		System.out.println("selectUserBuyer ()");
		HttpSession session = request.getSession();
		int sessionSns_idx = (int) session.getAttribute("sns_idx");
		vo.setSns_idx(sessionSns_idx);		
		
		vo = buyerService.selectUserBuyer(vo);
		model.addAttribute("BuyerVO", vo);
		
		List<BasketProductUserVO> myBasketList = buyerService.listBuyerUserBasket(sessionSns_idx);
		model.addAttribute("myBasket", myBasketList);
		logger.info("myBasketList size() : " + myBasketList.size());
		
		List<DealUserVO> myDealList = buyerService.listBuyerUserDeal(sessionSns_idx);
		model.addAttribute("myDeal", myDealList);
		logger.info("myDealList size() : " + myDealList.size());
		
		List<LikeUserVO> myLikeList = buyerService.listBuyerUserLike(sessionSns_idx);
		model.addAttribute("myLike", myLikeList);
		logger.info("myLikeList size() : " + myLikeList.size());
		
		return "shop/user/buyer/selectUserBuyer";
	}
	
	@RequestMapping("/shop/user/buyer/updateUserBuyerForm")
	public String updateUserBuyerForm(BuyerUserVO vo,Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		int sessionSns_idx = (int) session.getAttribute("sns_idx");
		vo.setSns_idx(sessionSns_idx);
		vo = buyerService.selectUserBuyer(vo);
		model.addAttribute("BuyerVO", vo);
		
		return "shop/user/buyer/updateUserBuyerForm";
	}
	
	@RequestMapping(value = "/shop/user/buyer/updateUserBuyerPro", method=RequestMethod.POST)
	public String updateUserBuyerPro(BuyerUserVO vo, Model model, RedirectAttributes redirect){
		System.out.println("BuyerUserController updateUserBuyerPro");
		int result = buyerService.updateUserBuyer(vo);
		if (result > 0) {
			System.out.println("result > 0");
			System.out.println("result => " + result);
		} else {
			System.out.println("result => " + result);
		}
		redirect.addFlashAttribute("result", result);
		return "redirect:/shop/user/buyer/updateUserBuyerForm.do";
	}
	
	
}
