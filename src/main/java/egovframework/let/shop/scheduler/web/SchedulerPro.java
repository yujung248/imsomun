package egovframework.let.shop.scheduler.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import egovframework.let.shop.scheduler.service.SchedulerService;

@Controller
public class SchedulerPro {
	
	@Resource(name = "schedulerService")
	private SchedulerService schedulerService;
	
	/*public void insertLog() {
		System.out.println("로그를 저장 합니다.");
	}*/
	
	public void delSch() throws Exception{
		int result=schedulerService.delChk();
		if(result==1){
			System.out.println("삭제완료");
		}else{
			System.out.println("삭제실패");
		}
	}

}
