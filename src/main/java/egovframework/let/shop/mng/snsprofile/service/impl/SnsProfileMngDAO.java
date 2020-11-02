package egovframework.let.shop.mng.snsprofile.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.snsprofile.service.SnsProfileMngVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SnsProfileMngDAO")
public class SnsProfileMngDAO extends EgovAbstractDAO {

	public SnsProfileMngVO selectSnsprofileMng(SnsProfileMngVO vo) {
		try {
			vo = (SnsProfileMngVO) select("selectSnsprofileMng", vo);
		} catch (Exception e) {
			System.out.println("SnsProfileUserDAO selectUserSnsprofile Exception : " + e.getMessage());
		}
		return vo;
	}
}
