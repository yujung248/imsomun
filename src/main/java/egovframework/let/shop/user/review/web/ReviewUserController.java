package egovframework.let.shop.user.review.web;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import egovframework.let.shop.mng.testFileUpload.web.TestFileUploadController;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.review.service.ReviewUserService;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class ReviewUserController {

	private static final Logger logger = LoggerFactory.getLogger(TestFileUploadController.class);
	
	@Resource(name = "EgovReviewUserService")
	private ReviewUserService egovReviewService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	// 파일 처리를 위한 멀티파트 리졸버
		@Resource(name = "multipartResolver")
		CommonsMultipartResolver multipartResolver;
	
	/*@Resource(name ="logFileUtils")
	private LogFileUtils logFileUtils;
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
	//리뷰 후기 전체보기 , 페이징 처리
	@RequestMapping(value = "/shop/user/review/reviewList.do")
	public String selectReviewList(ReviewUserVO vo, ModelMap model) throws Exception{
		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		//vo.setP_idx(1);
		List<String> AVG = egovReviewService.selectReviewAvg(vo);
		/*int num = vo.getFirstIndex();
		int result= num -1;
		System.out.println("result-------------->"+result);
		vo.setFirstIndex(result);*/
		List<ReviewUserVO> list = egovReviewService.selectReviewList(vo);
		
		
		
		model.addAttribute("list", list);
		model.addAttribute("r_div", vo.getR_div());
		model.addAttribute("AVG", AVG);
		model.addAttribute("paginationInfo", paginationInfo);
		return "/shop/user/review/EgovShopReview";
	}
	//마이바티스,아이바티스에서는 업데이트할때 결과값을 int(0 , 1) 로 받아주기때문에
	//int 로 받아주어야한다. (0은 실패 1은 성공)
	
	//사용자가 작성한 후기 삭제
	@RequestMapping(value ="/shop/user/review/delUserReview.do")
	public String delUserReview(ReviewUserVO reviewVO) throws Exception{
		
		int result = egovReviewService.delUserReview(reviewVO);
		if (result == 0) {
			System.out.println("후기 삭제 실패");
		}else{
			System.out.println("후기 삭제 성공");
		}
		return "forward:/shop/user/review/EgovUserSellerListForm.do";
	}
	//사용자가 작성한 후기 수정
	@RequestMapping(value ="/shop/user/review/updateUserReview.do")
	public String updateUserReview(ReviewUserVO reviewVO, ModelMap model, HttpServletRequest request) throws Exception{

		HttpSession session = request.getSession();
		String sessionSta = (String)session.getAttribute("s_id");
		
		int result = egovReviewService.updateUserReview(reviewVO);
		if (result == 0) {
			System.out.println("후기 수정 실패");
		}else{
			System.out.println("후기 수정 성공");
		}
		model.addAttribute("s_id", sessionSta);
		return "forward:/shop/user/review/EgovUserSellerListForm.do";
	}
	
	//상품상세애대한 리뷰 작성
	@RequestMapping(value = "/shop/user/review/insertUserReview.do", method = RequestMethod.POST)
	public String list(ReviewUserVO reviewVO, ModelMap model, HttpServletRequest request, String path, MultipartFile file) throws Exception {
		System.out.println("---------------------------mainReview insert Start");
		
		HttpSession session = request.getSession();
		int sessionStatus =(int)session.getAttribute("status");
		
		// 업로드용 경로 설정
		String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
		// 서버에 업로드할 경우엔 프로퍼티에서 경로를 설정할 예정.
		// String uploadPath =
		// propertyService.getString("Globals.fileStorePath");
		System.out.println("uploadPath => " + uploadPath);
		System.out.println("uploadForm POST Start");

		logger.info("originalName : " + file.getOriginalFilename());
		logger.info("Size : " + file.getSize());
		logger.info("contentType : " + file.getContentType());

		// 업로드하고 파일명을 받아온다.
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		logger.info("savedNames: " + savedName);

		// VO에 파일 관련된 값을 수동으로 넘겨준다. savedName이 가장 중요하다.
		reviewVO.setOriginal_file_name(file.getOriginalFilename());
		reviewVO.setStored_file_name(savedName);
		reviewVO.setFile_size(file.getSize());

		egovReviewService.insertMainUserReview(reviewVO);
		
		return "redirect:/shop/user/deal/dealUserBuyerList.do";

	}
	@RequestMapping(value = "/shop/user/review/insertSellerReview2.do", method = RequestMethod.POST)
	public String list2(ReviewUserVO reviewVO, ModelMap model, HttpServletRequest request, String path, MultipartFile file) throws Exception {
		System.out.println("---------------------------mainReview insert Start");
		
		System.out.println(reviewVO.getS_id());
		
		HttpSession session = request.getSession();
		int sessionStatus =(int)session.getAttribute("status");
		
		// 업로드용 경로 설정
		String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
		// 서버에 업로드할 경우엔 프로퍼티에서 경로를 설정할 예정.
		// String uploadPath =
		// propertyService.getString("Globals.fileStorePath");
		System.out.println("uploadPath => " + uploadPath);
		System.out.println("uploadForm POST Start");

		logger.info("originalName : " + file.getOriginalFilename());
		logger.info("Size : " + file.getSize());
		logger.info("contentType : " + file.getContentType());

		// 업로드하고 파일명을 받아온다.
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		logger.info("savedNames: " + savedName);

		// VO에 파일 관련된 값을 수동으로 넘겨준다. savedName이 가장 중요하다.
		reviewVO.setOriginal_file_name(file.getOriginalFilename());
		reviewVO.setStored_file_name(savedName);
		reviewVO.setFile_size(file.getSize());

		egovReviewService.insertMainUserReview(reviewVO);
		
		return "redirect:/shop/user/deal/dealUserSellerList.do";
	}
	
	@SuppressWarnings("unused")
	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {

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
		String savedName = uid.toString() + "_" + originalName;

		String[] invalidName = { "\\\\", "/", ":", "\"", "<", ">", "\\[", "\\]" }; // 윈도우
																					// 파일명으로
																					// 사용할수
																					// 없는
																					// 문자

		for (int i = 0; i < invalidName.length; i++)
			savedName = savedName.replaceAll(invalidName[i], "_"); // 언더바로 치환

		// 저장될 파일 경로를 지정.
		File target = new File(uploadPath, savedName);

		// FileCopyUtils로 경로에 저장해 복사한다.
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	//리뷰 작성 폼
	@RequestMapping(value = "/shop/user/review/EgovBuyerInsertForm.do")
	public String insertReview(DealUserVO vo, ModelMap model){
		System.out.println("abcdefghijklmnop");
		model.addAttribute("dealUserVO", vo);
		return "/shop/user/review/EgovBuyerReviewInsert";
	}
	
	@RequestMapping(value = "/shop/mng/review/EgovSellerInsertForm2.do")
	public String insertReview2(DealUserVO vo, ModelMap model){
		System.out.println("abcdefghijklmnop");
		
		System.out.println("vo------>s_id"+vo.getS_id());
		System.out.println("vo------>p_idx"+vo.getP_idx());
		model.addAttribute("dealUserVO", vo);
			
		return "shop/mng/review/EgovSellerReviewInset";
	}
	
	
	//판매자 리뷰 리스트
	@RequestMapping(value = "/shop/user/review/EgovUserSellerListForm.do")
	public String UserSellerReview(ReviewUserVO reviewVO, ModelMap model) throws Exception{
		
		PaginationInfo paginationInfo = new PaginationInfo();

		String aa = reviewVO.getS_id();
		System.out.println("aaaaaaaaaaaaaaaa"+aa);
		paginationInfo.setCurrentPageNo(reviewVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(reviewVO.getPageUnit());
		paginationInfo.setPageSize(reviewVO.getPageSize());

		reviewVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		reviewVO.setLastIndex(paginationInfo.getLastRecordIndex());
		reviewVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		List<ReviewUserVO> list =egovReviewService.UserSellerReview(reviewVO);
		
		model.addAttribute("list" , list);
		model.addAttribute("s_id", aa);
		model.addAttribute("paginationInfo", paginationInfo);
		return "shop/user/review/EgovUserSellerReview";
	}
	
	@RequestMapping(value = "/shop/mng/review/miniGame.do")
	public String mingGame() throws Exception{
		
		return "shop/mng/review/reviewMini";
	}
	
	@RequestMapping(value = "/shop/mng/review/daumMap.do")
	public String daumMap() throws Exception{
		
		return "shop/mng/review/daumMap";
	}
}
