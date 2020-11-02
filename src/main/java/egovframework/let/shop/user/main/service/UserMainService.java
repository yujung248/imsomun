package egovframework.let.shop.user.main.service;

import java.util.List;

import egovframework.let.shop.user.main.service.impl.UserMainVO;


public interface UserMainService {

	List<UserMainVO> selectMainList(UserMainVO vo);

	int selectCount();

	List<UserMainVO> MainSearch(UserMainVO vo);

	/*List<UserMainVO> selectMainList2(List<Integer> list2);*/

}
