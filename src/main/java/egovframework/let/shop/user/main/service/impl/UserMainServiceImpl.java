package egovframework.let.shop.user.main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.main.service.UserMainService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("userMainService")
public class UserMainServiceImpl extends EgovAbstractServiceImpl  implements UserMainService{

	
	@Resource(name="userMainDAO")
	private UserMainDAO MainDAO;

	@Override
	public List<UserMainVO> selectMainList(UserMainVO vo) {
		System.out.println("UserMainServiceImpl");
		List<UserMainVO> list = MainDAO.selectMainList(vo);
				
		return list;
	}

	@Override
	public int selectCount() {
		System.out.println("UserMainServiceImpl");
		int count = MainDAO.selectCount();
		return count;
	}
/*
	@Override
	public List<UserMainVO> selectMainList2(List<Integer> list2) {
		List<UserMainVO> list = MainDAO.selectMainList2(list2);
		return null;
	}*/

	/*@Override
	public List<UserMainVO> MainSearch(String keyword) {
		List<UserMainVO> list = MainDAO.MainSearch(keyword);
		return list;
	}
*/
	@Override
	public List<UserMainVO> MainSearch(UserMainVO vo) {
		List<UserMainVO> list = MainDAO.MainSearch(vo);
		return list;
	}
}
