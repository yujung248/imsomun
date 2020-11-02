package egovframework.let.shop.mng.snsprofile.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.snsprofile.service.SnsProfileMngService;
import egovframework.let.shop.mng.snsprofile.service.SnsProfileMngVO;

@Service("SnsProfileMngService")
public class SnsProfileMngServiceImpl implements SnsProfileMngService{
	
	@Resource(name = "SnsProfileMngDAO")
	SnsProfileMngDAO sd;

	@Override
	public SnsProfileMngVO selectMngSnsprofile(SnsProfileMngVO vo) {

		return sd.selectSnsprofileMng(vo);
	}
	

}
