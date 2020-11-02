package egovframework.let.shop.user.deal.service;

import java.util.List;

import egovframework.let.shop.user.deal.service.impl.DealUserVO;

public interface DealUserService {

	int selectListCntDealUserBuyer(DealUserVO vo);

	List<DealUserVO> selectListDealUserBuyer(DealUserVO vo);
	
	DealUserVO selectDealUserBuyerDetail(DealUserVO vo);

	DealUserVO selectDealUserBuyerScore(DealUserVO vo);

	int updateDealUserBuyerDetail(DealUserVO vo);

	int updateDealUserBuyerCancel(DealUserVO vo);

	int updateDealUserBuyerComplete(DealUserVO vo);
	
	int updateDealUserBuyerD_edate(DealUserVO vo);

	
	// 판매자
	int selectListCntDealUserSeller(DealUserVO vo);
	
	List<DealUserVO> selectListDealUserSeller(DealUserVO vo);
	
	DealUserVO selectDealUserSellerDetail(DealUserVO vo);
	
	int updateDealUserSellerAccept(DealUserVO vo);

	int updateDealUserSellerCancel(DealUserVO vo);

	int updateDealUserSellerDeliver(DealUserVO vo);
	
	// 구매 시
	DealUserVO selectDealUserBuyerRequest(DealUserVO vo);
	
	DealUserVO selectDealUserBuyerRequestPro(DealUserVO vo);
	
	int selectDealUserBuyerD_idx(DealUserVO vo);
	
}
