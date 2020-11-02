package egovframework.let.shop.user.buyer.service;


import java.util.List;

import egovframework.let.shop.user.basket.service.impl.BasketProductUserVO;

import egovframework.let.shop.user.buyer.service.impl.BuyerUserVO;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.like.service.impl.LikeUserVO;

public interface BuyerUserService {

	BuyerUserVO selectUserBuyer(BuyerUserVO vo);

	int updateUserBuyer(BuyerUserVO vo);

	List<BasketProductUserVO> listBuyerUserBasket(int sessionSns_idx);

	List<DealUserVO> listBuyerUserDeal(int sessionSns_idx);

	List<LikeUserVO> listBuyerUserLike(int sessionSns_idx);

}
