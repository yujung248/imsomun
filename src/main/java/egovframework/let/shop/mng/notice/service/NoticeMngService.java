package egovframework.let.shop.mng.notice.service;

import java.util.List;

import egovframework.let.shop.mng.notice.service.impl.NoticeMngVO;

public interface NoticeMngService {
	
	int selectMngNoticeListCnt(NoticeMngVO vo);

	List<NoticeMngVO> selectMngNoticeList(NoticeMngVO vo);
	
	NoticeMngVO selectMngNoticeForm(NoticeMngVO vo);

	int updateMngNoticePro(NoticeMngVO vo);

	int insertMngNoticePro(NoticeMngVO vo);

	int deleteMngNotice(NoticeMngVO vo);


}
