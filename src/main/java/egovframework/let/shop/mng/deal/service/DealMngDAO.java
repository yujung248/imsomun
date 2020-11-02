package egovframework.let.shop.mng.deal.service;

import java.util.List;

import egovframework.let.shop.mng.deal.service.impl.DealMngVO;

public interface DealMngDAO {
	
	int selectListCntDealMng(DealMngVO vo);

	List<DealMngVO> selectListDealMng(DealMngVO vo);
	
	DealMngVO selectDealMngBuyerDetail(DealMngVO vo);

	DealMngVO selectDealMngBuyerScore(DealMngVO vo);

	int updateDealMngIng(DealMngVO vo);
	
	int updateDealMngBuyerCancel(DealMngVO vo);

	DealMngVO selectDealMngSellerDetail(DealMngVO vo);
	
	int updateDealMngBuyerD_edate(DealMngVO vo);
}
