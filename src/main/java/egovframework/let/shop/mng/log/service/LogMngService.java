package egovframework.let.shop.mng.log.service;

import java.util.List;

import egovframework.let.shop.mng.log.service.impl.LogMngVO;

public interface LogMngService {
	
	int selectMngLogListCnt(LogMngVO vo);
	
	List<LogMngVO> selectMngLogList(LogMngVO vo);
	
	String insertMngLogPro(LogMngVO vo);

/*	int updateMngLogPro(LogMngVO vo);

	int insertMngLogPro(LogMngVO vo);*/


}
