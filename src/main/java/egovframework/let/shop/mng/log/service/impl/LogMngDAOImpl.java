package egovframework.let.shop.mng.log.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.log.service.LogMngDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovMngLogDAO")
public class LogMngDAOImpl extends EgovAbstractDAO implements LogMngDAO {

	@Override
	public int selectMngLogListCnt(LogMngVO vo) {
		System.out.println("selectMngLogListCnt");
		int count = 0;
		try {
			count = (int) select("selectMngLogListCnt", vo);

		} catch (Exception e) {
			System.out.println("selectMngLogListCnt Exception " + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogMngVO> selectMngLogList(LogMngVO vo) {
		List<LogMngVO> Loglist = null;
		try {
			Loglist = (List<LogMngVO>) list("selectLogMngList", vo);

		} catch (Exception e) {
			System.out.println("selectLogMngList Exception " + e.getMessage());
		}
		return Loglist;
	}

	@Override
	public String insertMngLogPro(LogMngVO vo) {
		String result = "false";
		try {
			insert("insertMngLogPro",vo);
			result="true";
		} catch (Exception e) {
			System.out.println("insertMngLogPro Exception " + e.getMessage());
		}
		return result;

	}
	
}
