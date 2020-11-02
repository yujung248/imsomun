package egovframework.let.shop.user.snsprofile.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.user.snsprofile.service.SnsProfileUserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovSnsUserDAO")
public class SnsProfileUserDAO extends EgovAbstractDAO {

	public int insertSnsUser(SnsProfileUserVO snsProfileVo) throws Exception{
		return (Integer)update("EgovSnsUserDAO.insertSnsUser", snsProfileVo);
	}

	@SuppressWarnings("unchecked")
	public List<SnsProfileUserVO> selectSnsUserList(SnsProfileUserVO snsProfileVo) {
		return (List<SnsProfileUserVO>) list("EgovSnsUserDAO.selectSnsUserList", snsProfileVo);
	}
	public int checkUserLogin(SnsProfileUserVO vo){
		System.out.println("dao.getUserid() : "+vo.getUserid());
		int result=(Integer)select("EgovSnsUserDAO.checkUserLogin", vo);
		return result;
	}

	public SnsProfileUserVO selectSnsidx(String userid) {
		
		return (SnsProfileUserVO) select("EgovSnsUserDAO.selectSnsidx",userid);
	}
}
