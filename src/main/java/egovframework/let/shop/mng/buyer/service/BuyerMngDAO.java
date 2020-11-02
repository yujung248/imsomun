package egovframework.let.shop.mng.buyer.service;

import java.util.List;

import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;

public interface BuyerMngDAO {
	
	public int buyerListCnt(BuyerMngVO vo);
	public List<BuyerMngVO> buyerList(BuyerMngVO vo);
	public BuyerMngVO buyerSelect(BuyerMngVO vo);
	public int buyerUpdate(BuyerMngVO vo);
	public int updateMngBuyerStateChange(BuyerMngVO vo);

}
