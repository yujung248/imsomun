package egovframework.let.shop.user.like.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.shop.user.like.service.LikeUserService;
import egovframework.let.shop.user.like.service.impl.LikeUserVO;
import egovframework.let.shop.user.product.service.ProductUserService;
import egovframework.let.shop.user.product.service.impl.ProductUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class LikeUserController {
	@Resource(name = "LikeUserService")
	private LikeUserService likeUserService;
	
	@Resource(name="EgovUserProductService")
	private ProductUserService productUserService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	

	/*@Resource(name ="EgovReviewService")
	protected ReviewMngService reviewService;*/
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
	
	@RequestMapping(value = "/shop/user/like/LikeUserList")
	public String forwardPageWithMenuNo(@ModelAttribute("searchVO") LikeUserVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		System.out.println("test");
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));
		HttpSession session = request.getSession();
		int sns_idx = (int) session.getAttribute("sns_idx");
		vo.setSns_idx(sns_idx);

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = likeUserService.selectLikeUserListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<LikeUserVO> list = likeUserService.selectLikeUserList(vo);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
			
//		리뷰 관련  			//
		
		/*List<ReviewVO> list2 = reviewService.selectReviewList(vo2);
		model.addAttribute("list2", list);*/
		
//		리뷰 관련  			//		
		return "/shop/user/like/LikeUserList";
	}
	

	
	@RequestMapping(value="/shop/user/product/LikeUserInsert")
	 public String LikeUserInsert(ProductUserVO pvo, LikeUserVO vo, Model model, HttpServletRequest request) throws Exception {
		 System.out.println("LikeUserInsert"+vo.getS_id());
		 
		 HttpSession session = request.getSession();
			int userSnsIdx = 0;
			try {
				userSnsIdx = (int) session.getAttribute("sns_idx");
			} catch (NullPointerException e) {
				System.out.println("");
				return "redirect:/shop/user/EgovUserLoginForm.do";
			}
		 
		 
		 HttpSession session1 = request.getSession();
		 int sns_idx =  (int) session1.getAttribute("sns_idx");
		 System.out.println("sns id = " + sns_idx );
		 vo.setSns_idx(sns_idx);
	
		 int result=0;
		 
		 
		 int voChk = likeUserService.insertUserLikeSelect(vo);
		
		 
		 if(voChk == 0){
			 System.out.println("찜하기 성공");
			 result = likeUserService.insertUserLike(vo);
		 }else{
			 // delete list failed
			 System.out.println("찜하기 실패");
			return "redirect:/shop/user/product/EgovBuyerProductForm.do";
			 
		 }
		
		 return "redirect:/shop/user/product/EgovUserProductlist.do";
		 
		 
		
	}
	

	@RequestMapping(value="/shop/user/like/LikeUserDelete")
	 public String LikeUserDelete (HttpServletRequest request, Model model, LikeUserVO vo) throws Exception {
		int result = likeUserService.deleteUserLike(vo);
		return "redirect:/shop/user/like/LikeUserList.do";
		 
	 }
	
}