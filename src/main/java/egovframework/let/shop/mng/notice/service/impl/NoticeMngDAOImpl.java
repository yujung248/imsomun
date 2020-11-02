package egovframework.let.shop.mng.notice.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.notice.service.NoticeMngDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("NoticeMngDAO")
public class NoticeMngDAOImpl extends EgovAbstractDAO implements NoticeMngDAO {

	@Override
	public int selectMngNoticeListCnt(NoticeMngVO vo) {
		System.out.println("selectMngNoticeListCnt");
		int count = 0;
		try {
			count = (int) select("selectMngNoticeListCnt", vo);

		} catch (Exception e) {
			System.out.println("selectMngNoticeListCnt Exception" + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeMngVO> selectMngNoticeList(NoticeMngVO vo) {
		List<NoticeMngVO> NoticeList = null;

		try {
			NoticeList = (List<NoticeMngVO>) list("selectMngNoticeList", vo);

		} catch (Exception e) {
			System.out.println("selectMngNoticeList Exception" + e.getMessage());
		}

		return NoticeList;
	}

	@Override
	public NoticeMngVO selectMngNoticeForm(NoticeMngVO vo) {
		try {
			vo = (NoticeMngVO) select("selectMngNoticeForm", vo);
		} catch (Exception e) {
			System.out.println("selectMngNoticeForm Exception" + e.getMessage());

		}
		return vo;
	}
	

	@Override
	public int updateMngNoticePro(NoticeMngVO vo) {
		System.out.println("NoticeMngDaoImpl updateMngNoticePro()");
		int result = 0;
		try {
			result = update("updateMngNoticePro", vo);
		} catch (Exception e) {
			System.out.println("updateMngNoticePro Exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int insertMngNoticePro(NoticeMngVO vo) {
		System.out.println("NoticeMngDaoImpl insertMngNoticePro()");
		int result = 0;
		try {
			result = (int) insert("insertMngNoticePro",vo);
		} catch (Exception e) {
			System.out.println("insertMngNoticePro Exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int deleteMngNotice(int n_idx) {
		System.out.println("NoticeMngDAOImpl deleteMngNotice");
		int result = 0;
		try {
			result = delete("deleteMngNotice", n_idx);
		} catch (Exception e) {
			System.out.println("deleteMngNotice Exception" + e.getMessage());
		}
		return result;
	}
}
