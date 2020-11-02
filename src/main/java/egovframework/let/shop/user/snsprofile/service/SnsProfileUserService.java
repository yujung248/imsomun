package egovframework.let.shop.user.snsprofile.service;

import java.util.List;

public interface SnsProfileUserService {
	
	public List<SnsProfileUserVO> selectSnsUserList(SnsProfileUserVO snsProfileVo) throws Exception;
	
	public int insertSnsUser(SnsProfileUserVO snsProfileVo)throws Exception;
	
	public int checkUserLogin(SnsProfileUserVO vo)throws Exception;

	public SnsProfileUserVO selectSnsidx(String userid);
}
