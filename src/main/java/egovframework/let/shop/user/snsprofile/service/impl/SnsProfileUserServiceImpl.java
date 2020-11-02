package egovframework.let.shop.user.snsprofile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.snsprofile.service.SnsProfileUserService;
import egovframework.let.shop.user.snsprofile.service.SnsProfileUserVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovSnsUserService")
public class SnsProfileUserServiceImpl extends EgovAbstractServiceImpl implements SnsProfileUserService {

	@Resource(name = "EgovSnsUserDAO")
	private SnsProfileUserDAO snsUserDAO;

	@Override
	public List<SnsProfileUserVO> selectSnsUserList(SnsProfileUserVO snsProfileVo) throws Exception {
		List<SnsProfileUserVO> list = snsUserDAO.selectSnsUserList(snsProfileVo);
		return list;
	}

	@Override
	public int checkUserLogin(SnsProfileUserVO vo) throws Exception {
		System.out.println("userid : "+vo.getUserid());
		int result = snsUserDAO.checkUserLogin(vo);
		return result;
	}

	@Override
	public int insertSnsUser(SnsProfileUserVO snsProfileVo) throws Exception {
		int result = snsUserDAO.insertSnsUser(snsProfileVo);
		return result;
	}

	@Override
	public SnsProfileUserVO selectSnsidx(String userid) {
		
		return snsUserDAO.selectSnsidx(userid);
	}

}
