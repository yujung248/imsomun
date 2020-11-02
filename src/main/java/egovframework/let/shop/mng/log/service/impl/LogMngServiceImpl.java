package egovframework.let.shop.mng.log.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.log.service.LogMngDAO;
import egovframework.let.shop.mng.log.service.LogMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;



@Service("EgovMngLogService")
public class LogMngServiceImpl extends EgovAbstractServiceImpl implements LogMngService {

	@Resource(name = "EgovMngLogDAO")
	private LogMngDAO logMngDAO;

	@Override
	public int selectMngLogListCnt(LogMngVO vo) {
		int cnt = logMngDAO.selectMngLogListCnt(vo);
		return cnt;
	}

	@Override
	public List<LogMngVO> selectMngLogList(LogMngVO vo) {
		List<LogMngVO> list = logMngDAO.selectMngLogList(vo);

		return list;
	}

	@Override
	public String insertMngLogPro(LogMngVO vo) {
		return logMngDAO.insertMngLogPro(vo);
	}

/*	@Override
	public LogMngVO selectMngLog(LogMngVO logVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
*/
/*	@Override
	public int updateMngLogPro(LogMngVO vo) {
		int result = logMngDAO.updateMngLog(vo);
		return result;
	}

	@Override
	public int insertMngLogPro(LogMngVO vo) {
		int result = logMngDAO.insertMngLog(vo);
		return result;
	}*/

}
