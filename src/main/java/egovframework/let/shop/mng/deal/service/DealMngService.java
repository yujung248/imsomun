package egovframework.let.shop.mng.deal.service;

import java.util.List;

import egovframework.let.shop.mng.deal.service.impl.DealMngVO;

public interface DealMngService {

	int selectListCntDealMng(DealMngVO vo);

	List<DealMngVO> selectListDealMng(DealMngVO vo);
	
	DealMngVO selectDealMngBuyerDetail(DealMngVO vo);

	DealMngVO selectDealMngBuyerScore(DealMngVO vo);

	int updateDealMngBuyerDetail(DealMngVO vo);

	int updateDealMngBuyerCancel(DealMngVO vo);

	int updateDealMngBuyerComplete(DealMngVO vo);
	
	DealMngVO selectDealMngSellerDetail(DealMngVO vo);
	
	int updateDealMngSellerAccept(DealMngVO vo);

	int updateDealMngSellerCancel(DealMngVO vo);

	int updateDealMngSellerDeliver(DealMngVO vo);
	
	int updateDealMngBuyerD_edate(DealMngVO vo);
}
