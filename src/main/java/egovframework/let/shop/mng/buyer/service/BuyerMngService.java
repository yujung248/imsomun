package egovframework.let.shop.mng.buyer.service;

import java.util.List;

import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;
public interface BuyerMngService {

	int selectListCnt(BuyerMngVO vo);

	List<BuyerMngVO> selectList(BuyerMngVO vo);

	BuyerMngVO buyerSelect(BuyerMngVO vo);

	int buyerUpdate(BuyerMngVO vo);

	int updateMngBuyerStateChange(BuyerMngVO vo);

}
