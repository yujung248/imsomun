package egovframework.let.shop.mng.admin.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.let.shop.mng.admin.service.AdminService;
import egovframework.let.shop.mng.admin.service.impl.AdminVO;
import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;
import egovframework.let.shop.mng.seller.service.SellerMngService;
import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class AdminController {

	@Resource(name="AdminService")
	private AdminService adminService;
	
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
	
	@RequestMapping(value="/shop/mng/admin/AdminLogin.do")
	public String EgovMngAdminLoginForm() {
	   
	    return "/shop/mng/admin/adminLogin/EgovMngAdminLoginForm";
	}
	
	@RequestMapping(value="/shop/mng/admin/EgovMngAdminLoginPro.do")
public String EgovMngAdminLoginPro( @RequestParam("id") String id,  @RequestParam("passwd") String passwd, Model model, HttpServletRequest request,@ModelAttribute("searchVO") AdminVO vo) throws Exception {
		
		HttpSession session= request.getSession();
		
		System.out.println("user_id"+id);
		System.out.println("password"+passwd);
		
		AdminVO adminvo = new AdminVO();
		adminvo.setA_id(id);
		adminvo.setA_pass(passwd);
		
		String user_name = (String)adminService.selectLoginCheck(adminvo);
		List<AdminVO> list = adminService.selectListLoginCheck(adminvo);
		
		System.out.println("나옴"+user_name);
		
//		System.out.println("list"+list.get(0).getA_id());
//		System.out.println("list2"+list.get(0).getA_email());
		
		
		if (user_name != null){
			session.setAttribute("A_ID", list.get(0).getA_id());
			session.setAttribute("A_EMAIL", list.get(0).getA_email());
			session.setAttribute("A_NAME", list.get(0).getA_name());
			session.setAttribute("status", 0);
			/*request.getSession().setAttribute("user_id", id);*/
			System.out.println("성공");
			
		}else {
			System.out.println("실패");
			model.addAttribute("msg","사용자 올바르지 않음");
			model.addAttribute("chk",0);
			return "forward:/shop/mng/admin/AdminLogin.do";
		}
		
		return "redirect:/shop/mng/admin/adminMainForm.do";
	}
	
	
	@RequestMapping(value="/shop/mng/seller/adminLogout.do")
	public String adminLogout(HttpSession session) {
		System.out.println("관리자 로그아웃");
	    session.invalidate();
	    return "redirect:/shop/user/main/EgovUserMain.do";
	}
	
	@RequestMapping(value = "/shop/mng/admin/adminControl/listMngAdminControl")
	public String EgovMngListAdminControl(@ModelAttribute("searchVO")AdminVO vo, HttpServletRequest request, Model model,
		   @RequestParam(value="pageIndex", required=false, defaultValue="1") int pageIndex) {
		vo.setPageIndex(pageIndex);
		System.out.println("listAdminControl pageIndex => " + vo.getPageIndex()); 
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		int totCnt = adminService.selectListCnt(vo); //
		System.out.println("vo"+vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<AdminVO> list = adminService.selectList(vo); //

		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		System.out.println("pagecount"+totCnt);
		
		return "/shop/mng/admin/adminControl/listMngAdminControl";
		
	}
	
	@RequestMapping("/shop/mng/admin/adminControl/delMngAdminControl")
	public String EgovDelMngAdminControl(AdminVO adminVO) throws Exception {
			int result = adminService.adminDelete(adminVO);
			System.out.println("a_id: "+adminVO.getA_id());
			if (result == 0 ) {
				System.out.println("삭제 실패");
				System.out.println("result"+result);
				System.out.println("a_id: "+adminVO.getA_id());
			}else {
				System.out.println("삭제 성공");
				System.out.println("result"+result);

			}
		
		return "redirect:/shop/mng/admin/adminControl/listMngAdminControl.do";
		
	}
	
	@RequestMapping("/shop/mng/admin/adminControl/updateMngAdminControl")
	public String updateMngAdminControlForm(AdminVO adminVO, Model model)  {
		System.out.println("AdminMngModifyForm()");
		adminVO = adminService.adminSelect(adminVO);
		System.out.println("adminVO"+adminVO);
		model.addAttribute("AdminVO", adminVO);
		return "shop/mng/admin/adminControl/updateMngAdminControl";
		
	}
	
	@RequestMapping(value = "/shop/mng/admin/adminControl/updateMngAdminControlPro.do")
	public String updateMngAdminControlPro(AdminVO adminVO, Model model) {
		System.out.println("updateMngAdminForm()");
		int result = adminService.adminUpdate(adminVO);
		if(result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		model.addAttribute("adminVO", adminVO);
		
		return "forward:updateMngAdminControl.do";
		
	}
	
	@RequestMapping(value = "/shop/mng/admin/adminControl/insertMngAdminControlForm")
	public String insertMngAdminForm() {
		return "/shop/mng/admin/adminControl/insertMngAdminControlForm";
	}
	
	@RequestMapping(value = "/shop/mng/admin/adminControl/insertMngAdminControlPro", method = RequestMethod.POST)
	public String insertMngAdminPro(AdminVO vo, Model model) {
		int result = adminService.adminInsert(vo);
		if(result==0) {
			model.addAttribute("msg", "등록 성공!");
		}else {
			model.addAttribute("msg", "등록 실패");
		}
		return "forward:insertMngAdminControlForm.do";
		
	}
		
}
