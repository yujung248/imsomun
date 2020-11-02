package egovframework.let.shop.user.deal.service;

import java.util.List;

import egovframework.let.shop.user.deal.service.impl.DealUserVO;

public interface DealUserDAO {
	
	int selectListCntDealUserBuyer(DealUserVO vo);

	List<DealUserVO> selectListDealUserBuyer(DealUserVO vo);
	
	DealUserVO selectDealUserBuyerDetail(DealUserVO vo);

	DealUserVO selectDealUserBuyerScore(DealUserVO vo);

	//상태 변경 공용
	int updateDealUserIng(DealUserVO vo);
	
	int updateDealUserBuyerD_edate(DealUserVO vo);
	
	//판매자
	int selectListCntDealUserSeller(DealUserVO vo);
	
	List<DealUserVO> selectListDealUserSeller(DealUserVO vo);
	
	DealUserVO selectDealUserSellerDetail(DealUserVO vo);
	
	//구매 시
	DealUserVO selectDealUserBuyerRequest(DealUserVO vo);
	
	DealUserVO selectDealUserBuyerRequestPro(DealUserVO vo);
	
	int selectDealUserBuyerD_idx(DealUserVO vo);
}
