package egovframework.let.shop.user.main.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.let.shop.user.main.service.UserMainService;
import egovframework.let.shop.user.main.service.impl.UserMainVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class UserMainControllor {
	
	
	@Resource(name = "userMainService")
	private UserMainService userMainService;

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
	
	@RequestMapping(value="/shop/user/main/EgovUserMain.do")
	public String main(Model model,UserMainVO vo) throws Exception{
		System.out.println("UserMainControllor");
		/*int count = MainService.selectCount();
		System.out.println("count"+count);
		
		@SuppressWarnings("unused")
		List<Integer> list2 = new ArrayList<>();
		Random r = new Random();
		int nums[] = new int[3];
		for(int i= 0; i<3; i++){
			int num = r.nextInt(count)+1;
			System.out.println("num"+num);
			nums[i]=num;
			 for (int j = 0; j < i; j++) {
                 if (nums[j] == num) {
                     i--;
                     break;
                 }
             }
         }  
		for (int i = 0; i < nums.length; i++) {
             list2.set(i, nums[i]);
         }
		vo.setCount1(list2);
		
		System.out.println(vo.getCount1().get(0));*/
		/*@SuppressWarnings("unused")
		List<UserMainVO> list3= MainService.selectMainList2(list2);*/
		List<UserMainVO> list = userMainService.selectMainList(vo);
		
		/*System.out.println("list"+ list);*/
		model.addAttribute("list",list);
	    return "shop/main/EgovMain";
	}
	


}
