package egovframework.let.shop.user.seller.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.let.shop.mng.admin.service.impl.AdminVO;
import egovframework.let.shop.mng.product.service.impl.ProductMngVO;
import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.let.shop.mng.testFileUpload.web.TestFileUploadController;
import egovframework.let.shop.user.deal.service.DealUserService;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.product.service.ProductUserService;
import egovframework.let.shop.user.product.service.impl.ProductUserVO;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.let.shop.user.seller.service.SellerUserService;
import egovframework.let.shop.user.seller.service.impl.SellerUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class SellerUserController {

	/**
	 * EgovBBSManageService
	 */
	private static final Logger logger = LoggerFactory.getLogger(TestFileUploadController.class);
	
	@Resource(name = "SellerUserService")
	private SellerUserService SellerService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	@Resource(name = "multipartResolver")
	CommonsMultipartResolver multipartResolver;
	
	@Autowired
	private JavaMailSender mailSender;

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
	
	/*@RequestMapping(value = "/shop/seller/EgovsellerLoginFrom.do")
	public String login( ModelMap model) throws Exception {
		
		return "shop/sellerLogin/sellerLoginFrom";
	}*/
	
	@RequestMapping(value = "/shop/user/seller/EgovsellerLoginPro.do")
	public String login( @RequestParam("id") String id,  @RequestParam("passwd") String passwd, Model model, HttpServletRequest request,@ModelAttribute("searchVO") SellerUserVO vo) throws Exception {
		
		HttpSession session= request.getSession();
		
		System.out.println("user_id"+id);
		System.out.println("password"+passwd);
		
		SellerUserVO sellervo = new SellerUserVO();
		sellervo.setS_id(id);
		sellervo.setS_pass(passwd);
		
		String user_name = (String)SellerService.selectLoginCheck(sellervo);
		List<SellerUserVO> list = SellerService.selectListLoginCheck(sellervo);
		System.out.println("나옴"+user_name);
		
		System.out.println("s_id"+sellervo.getS_id());
		if (user_name != null && user_name !=""){
			session.setAttribute("user", list.get(0));// ${sessionScope.user.s_id}  list말고 vo로 받았어야함/
			session.setAttribute("S_ID", list.get(0).getS_id());
			session.setAttribute("S_NICKNAME",list.get(0).getS_nickname() );
			session.setAttribute("S_EMAIL", list.get(0).getS_email());
			session.setAttribute("S_ADDR", list.get(0).getS_addr());
			session.setAttribute("S_GENDER",list.get(0).getS_gender());
			session.setAttribute("status", 2);
			/*request.getSession().setAttribute("user_id", id);*/
			model.addAttribute("msg","성공");
			model.addAttribute("chk",1);
		
		}else {
			System.out.println("오류 남");
			model.addAttribute("msg","사용자 올바르지 않음");
			model.addAttribute("chk",0);
			return "forward:/shop/user/EgovUserLoginForm.do";
		}
		
		return "shop/user/seller/sellerLogin/sellerLoginPro";
	}
	
	
	
	
	@RequestMapping(value="/shop/user/seller/sellerLogout.do")
	public String egovSellerLogout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/shop/user/main/EgovUserMain.do";
	}
	@RequestMapping(value="/shop/user/seller/sellerAgree.do")
	public String sellerinsert(){
		System.out.println("회원가입");
		
		return "/shop/user/seller/sellerinsert/sellerAgreeForm";
	}
	@RequestMapping(value="/shop/user/seller/sellerinsert.do")
	public String sellerUserinsert(){
		System.out.println("회원가입2");
		return "/shop/user/seller/sellerinsert/sellerinsertForm";
	}
	@RequestMapping(value="/shop/user/seller/sellerinsertPro.do", method = RequestMethod.POST )
	public String sellerinsertPro(HttpServletRequest request, SellerUserVO vo, Model model,MultipartFile file,String path ) throws Exception {
		// 업로드용 경로 설정
				String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
				// 서버에 업로드할 경우엔 프로퍼티에서 경로를 설정할 예정. 
				// String uploadPath = propertyService.getString("Globals.fileStorePath");
				System.out.println("uploadPath => " + uploadPath);
				System.out.println("uploadForm POST Start");
				
				logger.info("originalName : " + file.getOriginalFilename());
				logger.info("Size : " + file.getSize());
				logger.info("contentType : " + file.getContentType());
				System.out.println("file------------------->"+file);
				String savedName= null;
				if(file.getSize() != 0){
				// 업로드하고 파일명을 받아온다. 
				savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
				logger.info("savedNames: " + savedName);
				}
				// VO에 파일 관련된 값을 수동으로 넘겨준다. savedName이 가장 중요하다. 
				
				vo.setS_photo(savedName);
				if(savedName == null){
					if(vo.getS_gender().equals("남자")){
						vo.setS_photo("m.jpg");
					}else{
						vo.setS_photo("g.jpg");
					}
				}
				System.out.println("이미지"+vo.getS_photo());
		System.out.println("회원가입3");
		System.out.println("은행선택"+vo.getS_account_n());
		String addr1 =vo.getAddr1();
		String addr2 =vo.getAddr2();
		String S_addr= addr1 + addr2; 
		System.out.println("S_ADDR" + S_addr);
		String email1 =vo.getEmail1();
		String email2 =vo.getEmail2();
		String s_email = email1+"@"+email2;
		System.out.println("s_email"+s_email);
		vo.setS_addr(S_addr);
		vo.setS_email(s_email);
		String result = SellerService.sellerinsertPro(vo);
	
		return "redirect:/shop/user/EgovUserLoginForm.do";
	}
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
		
		String[] invalidName = {"\\\\","/",":","\"","<",">","\\[","\\]"}; // 윈도우 파일명으로 사용할수 없는 문자

		for(int i=0;i<invalidName.length;i++)
			savedName = savedName.replaceAll(invalidName[i], "_"); // 언더바로 치환


		// 저장될 파일 경로를 지정.
		File target = new File(uploadPath, savedName);
		
		// FileCopyUtils로 경로에 저장해 복사한다.
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	@RequestMapping(value="/shop/user/seller/sellerIdAgreeFrom.do")
	public String sellerIdAgreeFrom(){
		System.out.println("아이디 찾기 ");
		return "/shop/user/seller/sellerFind/sellerIdAgreeFrom";
	}
	@RequestMapping(value="/shop/user/seller/sellerFindId.do")
	public String sellerFindId(SellerUserVO vo, Model model, @RequestParam("s_name") String s_name,  @RequestParam("s_email") String s_email){
		System.out.println("아이디 찾기2 ");
		
		System.out.println("test"+vo.getS_name());
		System.out.println("testtest"+s_name);
		String name = SellerService.sellerFindId(vo);
		if(name != null){
			SellerService.updateAgreenum(vo);
		}
		model.addAttribute("s_id",name);
		return "/shop/user/seller/sellerFind/sellerFindId";
	}
	@RequestMapping(value="/shop/user/seller/sellerFindPass.do")
	public String sellerFindPass(Model model,SellerUserVO vo){
		
		if(vo.getS_id() != null){
			SellerService.updateAgreenum(vo);
		}
		
		System.out.println("비번 "+vo.getS_id());
		model.addAttribute("s_id",vo.getS_id());
		return "/shop/user/seller/sellerFind/sellerFindPass";
	}
	@RequestMapping(value="/shop/user/seller/sellerSearchId.do")
	public String sellerSearchId(){
		System.out.println("아이디");
		return "/shop/user/seller/sellerFind/sellerSearchId";
	}
	@RequestMapping(value="/shop/user/seller/sellerSearchIdPro.do")
	public String sellerSearchIdPro(SellerUserVO vo,Model model){
			
			vo = SellerService.sellerSearchIdPro(vo);
			if(vo==null){
				System.out.println("null");
				model.addAttribute("msg","아이디 없음");
				model.addAttribute("chk",1);
				return "/shop/user/seller/sellerFind/sellerSearchIdPro";
			}
			System.out.println("vo"+vo);
			model.addAttribute("s_id",vo.getS_id());
		
		return "/shop/user/seller/sellerFind/sellerPassAgreeForm";
	}
	
	
	@RequestMapping(value="/shop/user/seller/sellerPassResetForm.do")
	public String sellerPassResetForm(){
			
		
		return "/shop/user/seller/sellerFind/sellerPassResetForm";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/shop/user/seller/sellerIdChk.do",method = RequestMethod.POST)
	public int sellerIdChk(SellerUserVO vo){
			
		int result = SellerService.sellerIdChk(vo);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/shop/user/seller/sellerNicknameChk.do",method = RequestMethod.POST)
	public int sellerNicknameChk(SellerUserVO vo){
				
		int result = SellerService.sellerNicknameChk(vo);
			System.out.println("test"+result);
		return result;
	}
	@ResponseBody
	@RequestMapping(value="/shop/user/seller/sellerEmailChk.do",method = RequestMethod.POST)
	public int sellerEmailChk(SellerUserVO vo){
		String email1 =vo.getEmail1();
		String email2 =vo.getEmail2();
		String s_email = email1+"@"+email2;
		System.out.println("s_email"+s_email);
		vo.setS_email(s_email);
				
		int result = SellerService.sellerEmailChk(vo);
			System.out.println("test"+result);
		return result;
	}
		
	
	@ResponseBody
	@RequestMapping(value="/shop/user/seller/sellerCertificationNumber.do",method = RequestMethod.POST)
	public int sellerCertificationNumber(SellerUserVO vo, Model model) throws MessagingException {
		int result = 0;
		System.out.println("testNmae"+vo.getS_name());
		System.out.println("testEmail"+vo.getS_email());
		result = SellerService.sellerNameEmailChk(vo);
		if(result == 1){
			
			String setfrom = "edc30039@gmail.com";
			String tomail = vo.getS_email(); // 받는 사람 이메일
			String title = "입소문넷 인증번호"; // 제목
			
			int random = (int)((Math.random()*(999999-100000))+1);
			System.out.println("random"+random);
			vo.setS_agreenum(random);
			int AgreeNum = SellerService.sellerAgreeNum(vo);
			String content = "인증번호는 : "+random; // 내용
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message,true, "UTF-8");
				
				messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
				messageHelper.setTo(tomail); // 받는사람 이메일
				messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
				messageHelper.setText(content); // 메일 내용

				mailSender.send(message);
			} catch (Exception e) {
				System.out.println("오류");
				System.out.println(e);
			}
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/shop/user/seller/sellerCertificationNumberchk.do",method = RequestMethod.POST)
	public int sellerCertificationNumberchk(SellerUserVO vo, Model model){
			
		int result = SellerService.sellerCertificationNumberchk(vo);
		model.addAttribute("s_email",vo.getS_email());
		model.addAttribute("s_name",vo.getS_name());
		
		return result;
	}
	
	@RequestMapping(value="/shop/user/seller/sellerRePass.do")
	public int sellerRePass(SellerUserVO vo){
			System.out.println("비밀번호 재설정"+vo.getS_id()+vo.getS_pass());
			int result=SellerService.sellerRePass(vo);
			System.out.println("test"+result);
		return result;
	}
	
	  @RequestMapping("/shop/user/seller/selectUserSeller.do")
	  public String selectUserSeller(ProductUserVO vo3, DealUserVO vo2, ReviewUserVO vo1, SellerUserVO vo, Model model, HttpServletRequest request) {
		  HttpSession session = request.getSession();
		  String sessionS_id = (String) session.getAttribute("S_ID");
	      System.out.println("s_id->" + sessionS_id);
	      vo.setS_id(sessionS_id);
	      vo = SellerService.selectUserSeller(vo);
	      
	        vo3.setS_id(sessionS_id);
	      	List<ProductUserVO> list = SellerService.sellerSelectProductList(vo3);
			model.addAttribute("list", list);
			
			vo2.setS_id(sessionS_id);
			List<DealUserVO> list1 = SellerService.sellerSelectDealList(vo2);
			System.out.println("list1->" + list1.size());
			model.addAttribute("dealUserlist", list1);
			
			vo1.setS_id(sessionS_id);
			List<ReviewUserVO> list2 = SellerService.sellerSelectReviewList(vo1);
			System.out.println("SellerController --->s_id---->"+ vo1.getS_id());
			model.addAttribute("list1", list2);
			
	      model.addAttribute("SellerVO", vo);
	      return "shop/user/seller/selectUserSeller";
	   }

	  @RequestMapping("/shop/user/seller/updateUserSellerForm")
	  public String updateUserSellerForm(SellerUserVO vo, Model model) {
			System.out.println("updateUserSellerForm()");
			vo = SellerService.sellerUserSelect(vo);
			model.addAttribute("SellerVO", vo);
			return "shop/user/seller/updateUserSellerForm";
		}
	 
	  @RequestMapping(value = " /shop/user/seller/updateUserSellerPro", method = RequestMethod.POST)
		public String updateUserSellerPro(HttpServletRequest request, MultipartFile file, SellerUserVO vo, Model model, RedirectAttributes redirect) throws Exception{
			System.out.println("updateUserSellerPro()");
			System.out.println("vo.getS_nickname() ->" + vo.getS_nickname());
			System.out.println("vo.getS_photo() ->" + vo.getS_photo());
			System.out.println("file.getOriginalFilename() ->" + file.getOriginalFilename());
			
			String addr1 =vo.getAddr1();
			String addr2 =vo.getAddr2();
			String S_addr= addr1 + addr2; 
			System.out.println("S_ADDR" + S_addr);
			vo.setS_addr(S_addr);
			
			if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
			String deleteFilename = uploadPath + vo.getS_photo();
			deleteFile(deleteFilename);

			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
			vo.setS_photo(savedName);
			} 
			
			int result = SellerService.sellerUserUpdate(vo);
			
			if(result > 0) {
				redirect.addFlashAttribute("result", result);
			} else {
				redirect.addFlashAttribute("result", result);
			}
			model.addAttribute("vo");
			
			return "redirect:/shop/user/seller/selectUserSeller.do";
		}
	  private int deleteFile(String deleteFilename) {
			int result = 0;
			File file = new File(deleteFilename);
			if(file.exists()){
				if(file.delete()){
					result = 1;
					System.out.println("삭제 성공");
				}else{
					result = 0;
					System.out.println("삭제 실패");
				}
			} else {
				result = -1;
				System.out.println("파일이 존재하지 않습니다.");
			}
			
			return result;
		}
	  
}