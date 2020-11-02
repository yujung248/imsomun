package egovframework.let.shop.mng.notice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.notice.service.NoticeMngDAO;
import egovframework.let.shop.mng.notice.service.NoticeMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("NoticeMngService")
public class NoticeMngServiceImpl extends EgovAbstractServiceImpl implements NoticeMngService{
	
	@Resource(name ="NoticeMngDAO")
	private NoticeMngDAO NoticeDAO;
	
	@Override
	public int selectMngNoticeListCnt(NoticeMngVO vo) {
		int cnt = NoticeDAO.selectMngNoticeListCnt(vo);
		return cnt;
	}

	@Override
	public List<NoticeMngVO> selectMngNoticeList(NoticeMngVO vo) {
		List<NoticeMngVO> list = NoticeDAO.selectMngNoticeList(vo);
		return list;
	}

	@Override
	public NoticeMngVO selectMngNoticeForm(NoticeMngVO vo) {
		vo = NoticeDAO.selectMngNoticeForm(vo);
		return vo;
	}


	@Override
	public int updateMngNoticePro(NoticeMngVO vo) {
		int result = NoticeDAO.updateMngNoticePro(vo);
		return result;
	}

	@Override
	public int insertMngNoticePro(NoticeMngVO vo) {
		int result = NoticeDAO.insertMngNoticePro(vo);
		return result;
	}

	@Override
	public int deleteMngNotice(NoticeMngVO vo) {
		return NoticeDAO.deleteMngNotice(vo.getN_idx());
	}

}
