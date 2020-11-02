package egovframework.let.shop.user.buyer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;
import egovframework.let.shop.user.basket.service.BasketUserDAO;
import egovframework.let.shop.user.basket.service.impl.BasketProductUserVO;
import egovframework.let.shop.user.basket.service.impl.BasketUserVO;
import egovframework.let.shop.user.buyer.service.BuyerUserDAO;
import egovframework.let.shop.user.buyer.service.BuyerUserService;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.like.service.impl.LikeUserVO;

@Service("BuyerUserSerivce")
public class BuyerUserServiceImpl implements BuyerUserService{
	
	@Resource(name = "BuyerUserDAO")
	private BuyerUserDAO bd;
	
	
	@Override
	public BuyerUserVO selectUserBuyer(BuyerUserVO vo) {
		return bd.selectUserBuyer(vo);
	}

	@Override
	public int updateUserBuyer(BuyerUserVO vo) {
		// TODO Auto-generated method stub
		return bd.updateUserBuyer(vo);
	}

	@Override
	public List<BasketProductUserVO> listBuyerUserBasket(int sns_idx) {
		return bd.listBuyerUserBasket(sns_idx);
	}

	@Override
	public List<DealUserVO> listBuyerUserDeal(int sns_idx) {
		// TODO Auto-generated method stub
		return bd.listBuyerUserDeal(sns_idx);
	}

	@Override
	public List<LikeUserVO> listBuyerUserLike(int sns_idx) {
		// TODO Auto-generated method stub
		return bd.listBuyerUserLike(sns_idx);
	}


}
