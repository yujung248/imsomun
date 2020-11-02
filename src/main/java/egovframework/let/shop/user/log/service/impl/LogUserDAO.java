package egovframework.let.shop.user.log.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovUserLogDAO")
public class LogUserDAO extends EgovAbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<LogUserVO> selectUserLogList(LogUserVO logVO) throws Exception {
		return (List<LogUserVO>) list("EgovUserLogDAO.selectUserLogList", logVO);
	}
	
	public int selectUserLogListCnt(LogUserVO logVO) throws Exception {
		return (Integer)select("EgovUserLogDAO.selectUserLogListCnt", logVO);
	}
	
	public int updateUserLogPro(LogUserVO vo) throws Exception {
		int result = update("EgovUserLogDAO.updateUserLogPro", vo);
		return result;
	}
	
	public String insertUserLogPro(LogUserVO vo) throws Exception {
		String result = (String) insert("EgovUserLogDAO.insertUserLogPro", vo);
		return result;
	}

}
