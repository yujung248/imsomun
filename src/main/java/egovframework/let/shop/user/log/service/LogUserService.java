package egovframework.let.shop.user.log.service;

import java.util.List;

import egovframework.let.shop.user.log.service.impl.LogUserVO;

public interface LogUserService {
	
	List<LogUserVO> selectUserLogList(LogUserVO logVO) throws Exception;
	
	int selectUserLogListCnt(LogUserVO logVO) throws Exception;
	
	int updateUserLogPro(LogUserVO vo) throws Exception;
	
	String insertUserLogPro(LogUserVO vo) throws Exception;
	

}
