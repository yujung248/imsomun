package egovframework.let.shop.mng.log.service;

import java.util.List;

import egovframework.let.shop.mng.log.service.impl.LogMngVO;

public interface LogMngDAO {
	
	int selectMngLogListCnt(LogMngVO vo);
	List<LogMngVO> selectMngLogList(LogMngVO vo);
	String insertMngLogPro(LogMngVO vo);

	
}
	
	