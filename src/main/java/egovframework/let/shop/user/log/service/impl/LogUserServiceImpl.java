package egovframework.let.shop.user.log.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.log.service.LogUserService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovUserLogService")
public class LogUserServiceImpl extends EgovAbstractServiceImpl implements LogUserService {
	
	@Resource(name = "EgovUserLogDAO")
	private LogUserDAO userLogDAO;
	
	@Override
	public List<LogUserVO> selectUserLogList(LogUserVO logVO) throws Exception {
		List<LogUserVO> list = userLogDAO.selectUserLogList(logVO);
		return list;
	}

	@Override
	public int selectUserLogListCnt(LogUserVO logVO) throws Exception {
		int cnt = userLogDAO.selectUserLogListCnt(logVO);
		return cnt;
	}

	@Override
	public int updateUserLogPro(LogUserVO vo) throws Exception {
		int result = userLogDAO.updateUserLogPro(vo);
		return result;
	}

	@Override
	public String insertUserLogPro(LogUserVO vo) throws Exception {
		String result = userLogDAO.insertUserLogPro(vo);
		return result;
	}
	
}
