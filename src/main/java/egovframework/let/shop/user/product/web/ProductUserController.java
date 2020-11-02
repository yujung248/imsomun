package egovframework.let.shop.user.product.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.let.shop.user.product.service.ProductUserService;
import egovframework.let.shop.user.product.service.impl.ProductUserVO;
import egovframework.let.shop.user.review.service.ReviewUserService;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * 템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)
 * 
 * @author 실행환경 개발팀 JJY
 * @since 2011.08.31
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.08.31  JJY            최초 생성
 *
 *      </pre>
 */
@Controller
public class ProductUserController {

	/**
	 * EgovBBSManageService
	 */
	@Resource(name = "EgovUserProductService")
	private ProductUserService userProductService;

	@Resource(name = "EgovReviewUserService")
	private ReviewUserService egovReviewService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	// 파일 처리를 위한 멀티파트 리졸버
	@Resource(name = "multipartResolver")
	CommonsMultipartResolver multipartResolver;
	 

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

	/**
	 * 상품 정보
	 *
	 * @param request
	 * @param commandMap
	 * @exception Exception
	 *                Exception
	 */
	@RequestMapping(value = "/shop/user/product/EgovUserProductlist")
	public String forwardPageWithMenuNo(@ModelAttribute("searchVO") ProductUserVO vo, HttpServletRequest request,
			ModelMap model,ReviewUserVO vo2) throws Exception {
		System.out.println("test"+vo.getSearchCnd());
		System.out.println("test"+vo.getSearchWrd());
		vo.setPageUnit(8);
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());
	
		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = userProductService.selectUserProductListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<ProductUserVO> list = userProductService.selectUserProductList(vo);

		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);

		if(list.size()==0){
			System.out.println("검색결과가없습니다");
			model.addAttribute("msg","검색결과가 없습니다.");
		}else{
			System.out.println("totCnt"+ totCnt);
			model.addAttribute("totCnt", totCnt);
			model.addAttribute("list", list);
			model.addAttribute("paginationInfo", paginationInfo);
		}
			
//		리뷰 관련  			//
		
		/*List<ReviewVO> list2 = reviewService.selectReviewList(vo2);
		model.addAttribute("list2", list);*/
		
//		리뷰 관련  			//		
		return "/shop/user/product/EgovUserProductlist";
	}
	
	@RequestMapping(value = "/shop/user/product/EgovUserProductlistForSeller")
	public String EgovUserProductlistForSeller(@ModelAttribute("searchVO") ProductUserVO vo, HttpServletRequest request,
			ModelMap model,ReviewUserVO vo2) throws Exception {
		System.out.println("test"+vo.getSearchCnd());
		System.out.println("test"+vo.getSearchWrd());
		vo.setPageUnit(8);
		vo.setPageSize(propertyService.getInt("pageSize"));

		HttpSession session = request.getSession();
		String S_ID = (String) session.getAttribute("S_ID");
		vo.setS_id(S_ID);
		
		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());
	
		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = userProductService.selectUserProductListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);
		
		List<ProductUserVO> list = userProductService.selectUserProductList(vo);
		
		System.out.println("totCnt"+ totCnt);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
			
//		리뷰 관련  			//
		
		/*List<ReviewVO> list2 = reviewService.selectReviewList(vo2);
		model.addAttribute("list2", list);*/
		
//		리뷰 관련  			//		
		return "/shop/user/product/EgovUserProductlist";
}
//수정 형식 작성
	@RequestMapping(value="/shop/user/product/EgovUserProductUpdateForm")
	public String egovProductUpdateForm(@ModelAttribute("searchVO") ProductUserVO vo,  HttpServletRequest request,
			ModelMap model) throws Exception {
	
	    vo = userProductService.selectUserProductForm(vo);
	    System.out.println("EgovUserProductUpdateForm"+vo);
	    model.addAttribute("ProductUserVO",vo);
	    return "/shop/user/product/EgovUserProductUpdateForm";
	}
//수정하기 가능하도록	
	@RequestMapping(value ="/shop/user/product/EgovUserProductUpdatePro", method = RequestMethod.POST)
	public String egovUserProductUpdatePro(@ModelAttribute("ProductUserVO")ProductUserVO vo, HttpServletRequest request,Model model, RedirectAttributes redirect, MultipartFile file) throws Exception{
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		//
	    String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
	    // 서버에 업로드할 경우엔 프로퍼티에서 경로를 설정할 예정.
	 	// String uploadPath = propertyService.getString("Globals.fileStorePath");
	    // 서버 파일 삭제
	    String deleteFile = uploadPath + vo.getPreImage(); //
	    int delResult = deleteFile(deleteFile);
	    // 서버 업로드를 위한 절차
	    String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		vo.setP_image(savedName);
		vo.setP_status("Y");
		}
	    // DB 반영
	    int dbResult = userProductService.updateUserProductPro(vo);
	    
	    if(dbResult > 0) {
			redirect.addFlashAttribute("result3", dbResult);
		} else {
			redirect.addFlashAttribute("result3", dbResult);
		}
		model.addAttribute("vo");

		return "redirect:/shop/user/product/EgovUserProductlist.do" +"?pageIndex="+vo.getPageIndex();

	}
	
	private int deleteFile(String deleteFile) {
		int result = 0;
		File file = new File(deleteFile);
		if(file.exists()){
			if(file.delete()){
				System.out.println("파일 삭제 성공");
				result = 1;
			} else {
				System.out.println("파일 삭제 실패");
				result = 0;
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
			result = -1;
		}
		
		return result;
}

	@RequestMapping(value = "/shop/user/product/EgovUserProductInsertForm")
	public String EgovUserProductInsertForm() {
		return "/shop/user/product/EgovUserProductInsertForm";
	}
	
	@RequestMapping(value = "/shop/user/product/EgovUserProductInsertPro", method = RequestMethod.POST)
	public String EgovUserProductInsertPro(ProductUserVO vo,Model model, HttpServletRequest request, MultipartFile file, String path, RedirectAttributes redirect) throws Exception {
		
		HttpSession session = request.getSession();
		String s_id = (String) session.getAttribute("S_ID");
		vo.setS_id(s_id);
	
		//
		String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
		//String uploadPath = propertyService.getString("Globals.fileStorePath");
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		vo.setP_image(savedName);
		//
		System.out.println(vo.getP_content());
		String result = userProductService.insertUserProductPro(vo);
		
		if(result != "" && result != null) {
			redirect.addFlashAttribute("result1", result);
			System.out.println("result1->" + result);
		} else {
			redirect.addFlashAttribute("result1", result);
			System.out.println("result1->" + result);
		}
		
		return "redirect:/shop/user/product/EgovUserProductlist.do";
	}
	
	private String uploadFile(String originalFilename, byte[] fileData, String uploadPath) throws Exception {
		// 랜덤으로 UUID를 생성해 파일 앞에 붙여줄 예정.
		UUID uid = UUID.randomUUID();
		System.out.println("uploadPath => " + uploadPath);
		
		// 업로드 경로를 확인하고, 경로에 폴더가 존재하지 않을 경우 생성해준다. 
		File fileDiretory = new File(uploadPath);
		if (!fileDiretory.exists()) {
			fileDiretory.mkdirs();
			System.out.println("the directory for uploading : " + uploadPath);
		}
		
		// UUID를 스트링으로 변환해 원래 이름 앞에 붙여준다.
		String savedName = uid.toString() + "_" + originalFilename;
		
		String[] invalidName = {"\\\\","/",":","\"","<",">","\\[","\\]"}; // 윈도우 파일명으로 사용할수 없는 문자

		for(int i=0;i<invalidName.length;i++)
			savedName = savedName.replaceAll(invalidName[i], "_"); // 언더바로 치환


		// 저장될 파일 경로를 지정.
		File target = new File(uploadPath, savedName);
		
		// FileCopyUtils로 경로에 저장해 복사한다.
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}

	@RequestMapping(value = "/shop/user/product/EgovUserProductDelete") 
	public String EgovUserProductDelete(ProductUserVO vo, HttpServletRequest request, Model model, RedirectAttributes redirect)throws Exception {
		
		String[] check = request.getParameterValues("check");
		if (check != null) {
			for (int i = 0; i < check.length; i++) {
				System.out.println("chk : " +check[i]);
				vo.setP_idx(check[i]);
				int result = userProductService.deleteUserProduct(vo);
				if(result > 0) {
					redirect.addFlashAttribute("result", result);
				} else {
					redirect.addFlashAttribute("result", result);
				}
			}
		} else {
			int result = 0;
			redirect.addFlashAttribute("result2", result);
		}
		return "redirect:/shop/user/product/EgovUserProductlist.do";
	}
	
	@RequestMapping(value = "/shop/user/product/EgovBuyerProductForm")
	public String EgovBuyerProduct(ProductUserVO vo, ModelMap model,ReviewUserVO reviewVO) throws Exception {
		
		 vo = userProductService.selectBuyerProduct(vo);
		    System.out.println("EgovBuyerProduct"+vo);
		    vo.setP_content(vo.getP_content().replaceAll("\r\n", "<br>"));
		    model.addAttribute("ProductUserVO",vo);
		    
		    int num = reviewVO.getFirstIndex();
		    int result = num-1;
		    reviewVO.setFirstIndex(result);
		    System.out.println("result______________________>"+result);
		    List<String> AVG = egovReviewService.selectReviewAvg(reviewVO);
		    List<ReviewUserVO> list = egovReviewService.selectReviewList(reviewVO);
		    model.addAttribute("list",list);
		    model.addAttribute("r_div", reviewVO.getR_div());
			model.addAttribute("AVG", AVG);
		    return "/shop/user/product/EgovBuyerProductForm";
	}


}