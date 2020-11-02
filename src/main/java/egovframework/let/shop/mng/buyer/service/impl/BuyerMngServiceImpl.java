package egovframework.let.shop.mng.buyer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.buyer.service.BuyerMngDAO;
import egovframework.let.shop.mng.buyer.service.BuyerMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("BuyerMngService")
public class BuyerMngServiceImpl extends EgovAbstractServiceImpl implements BuyerMngService {

	@Resource(name = "BuyerMngDAO")
	private BuyerMngDAO BuyerDAO;

	@Override
	public int selectListCnt(BuyerMngVO vo) {
		int cnt = BuyerDAO.buyerListCnt(vo);
		return cnt;
	}

	@Override
	public List<BuyerMngVO> selectList(BuyerMngVO vo) {
		List<BuyerMngVO> list = BuyerDAO.buyerList(vo);
		return list;
	}

	@Override
	public BuyerMngVO buyerSelect(BuyerMngVO vo) {
		vo = BuyerDAO.buyerSelect(vo);
		return vo;
	}

	@Override
	public int buyerUpdate(BuyerMngVO vo) {
		int result = BuyerDAO.buyerUpdate(vo);
		return result;
	}

	@Override
	public int updateMngBuyerStateChange(BuyerMngVO vo) {
		int result = BuyerDAO.updateMngBuyerStateChange(vo);
		return result;
	}

}
