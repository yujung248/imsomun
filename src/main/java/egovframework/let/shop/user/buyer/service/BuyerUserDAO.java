package egovframework.let.shop.user.buyer.service;

import java.util.List;

import egovframework.let.shop.user.basket.service.impl.BasketProductUserVO;
import egovframework.let.shop.user.basket.service.impl.BasketUserVO;
import egovframework.let.shop.user.buyer.service.impl.BuyerUserVO;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.like.service.impl.LikeUserVO;

public interface BuyerUserDAO {

	BuyerUserVO selectUserBuyer(BuyerUserVO vo);

	int updateUserBuyer(BuyerUserVO vo);

	List<LikeUserVO> listBuyerUserLike(int sns_idx);

	List<DealUserVO> listBuyerUserDeal(int sns_idx);

	List<BasketProductUserVO> listBuyerUserBasket(int sns_idx);
	
}
