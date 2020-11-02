package egovframework.let.shop.mng.review.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.shop.mng.review.service.ReviewMngService;
import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.let.shop.user.product.service.impl.ProductUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class ReviewMngController {

	@Resource(name = "EgovMngReview")
	private ReviewMngService reviewMngService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	//구매자, 판매자 선택 화면
	@RequestMapping(value ="/shop/mng/review.do")
	public String mngView() throws Exception{
		return "/shop/mng/review/adminPage";
	}
	// 관리자 리뷰 페이지의 전체 댓글 출력
	@RequestMapping(value = "/shop/mng/review/MngSelect.do")
	public String selectMngList(ReviewMngVO mngVO, ModelMap model) throws Exception {
		
		System.out.println("test"+mngVO.getSearchCnd());
		System.out.println("test"+mngVO.getSearchWrd());
		mngVO.setPageUnit(propertyService.getInt("pageUnit"));
		mngVO.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(mngVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(mngVO.getPageUnit());
		paginationInfo.setPageSize(mngVO.getPageSize());

		
		int num = mngVO.getFirstIndex();
	    int result = num-1;
	    mngVO.setFirstIndex(result);
	    System.out.println("result---------------->"+result);
		
		mngVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		mngVO.setLastIndex(paginationInfo.getLastRecordIndex());
		mngVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = reviewMngService.selectMngCnt(mngVO);
		paginationInfo.setTotalRecordCount(totCnt);

		System.out.println("totCnt"+ totCnt);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		List<ReviewMngVO> list = reviewMngService.selectMngList(mngVO);
		model.addAttribute("list", list);
		return "/shop/mng/review/EgovMngReview";  //판매자
	}

	// 관리자 리뷰에서의 댓글 삭제
	@RequestMapping(value = "/shop/mng/review/delMngReview.do")
	public String delMngReview(ReviewMngVO mngVO, HttpServletRequest request) throws Exception {
		String[] chk = request.getParameterValues("chk");
		for (int j = 0; j < chk.length; j++) {
			System.out.println("chk : " + chk[j]);
			mngVO.setR_idx(chk[j]);
			reviewMngService.delMngReview(mngVO);
		}
		return "redirect:/shop/mng/review/MngSelect.do";
	}

	// 관리자 리뷰에서의 댓글 복구
	@RequestMapping(value = "/shop/mng/review/reMngReview.do")
	public String reMngReview(ReviewMngVO vo, HttpServletRequest request) throws Exception {
		String[] rechk = request.getParameterValues("rechk");
		for (int i = 0; i < rechk.length; i++) {
			System.out.println("rechk222-->" + rechk[i]);
			vo.setR_idx(rechk[i]);
			reviewMngService.reMngReview(vo);
		}
		return "redirect:/shop/mng/review/MngSelect.do";
	}

	// 관리자 판매자 리뷰에서의 댓글 출력
	@RequestMapping(value = "/shop/mng/review/MngUserSelect.do")
	public String selectSellerList(ReviewMngVO mngVO, ModelMap model) throws Exception {
		
		System.out.println("test"+mngVO.getSearchCnd());
		System.out.println("test"+mngVO.getSearchWrd());
		
		mngVO.setPageUnit(propertyService.getInt("pageUnit"));
		mngVO.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(mngVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(mngVO.getPageUnit());
		paginationInfo.setPageSize(mngVO.getPageSize());

		
		int num = mngVO.getFirstIndex();
	    int result = num-1;
	    mngVO.setFirstIndex(result);
	    System.out.println("result---------------->"+result);
		
		mngVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		mngVO.setLastIndex(paginationInfo.getLastRecordIndex());
		mngVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = reviewMngService.selectMngCnt(mngVO);
		paginationInfo.setTotalRecordCount(totCnt);

		System.out.println("totCnt"+ totCnt);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		List<ReviewMngVO> list = reviewMngService.selectMngList(mngVO);
		model.addAttribute("list", list);
		return "/shop/mng/review/EgovUserReview";  
	}
}
