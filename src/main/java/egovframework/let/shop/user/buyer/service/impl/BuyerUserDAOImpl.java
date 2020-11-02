package egovframework.let.shop.user.buyer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import egovframework.let.shop.user.basket.service.impl.BasketProductUserVO;
import egovframework.let.shop.user.basket.service.impl.BasketUserVO;
import egovframework.let.shop.user.basket.web.BasketUserController;
import egovframework.let.shop.user.buyer.service.BuyerUserDAO;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.like.service.impl.LikeUserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("BuyerUserDAO")
public class BuyerUserDAOImpl extends EgovAbstractDAO implements BuyerUserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(BasketUserController.class);

	@Override
	public BuyerUserVO selectUserBuyer(BuyerUserVO vo) {
		
		try {
			vo = (BuyerUserVO) select("selectUserBuyer", vo);
		} catch (Exception e) {
			System.out.println("BuyerUserDAOImpl selectUserBuyer Exception : " + e.getMessage());
		}
		return vo;
	}

	@Override
	public int updateUserBuyer(BuyerUserVO vo) {
		int result = 0;
		try {
			result = update("updateUserBuyer", vo);
		} catch (Exception e) {
			System.out.println("BuyerUserDAOImpl updateUserBuyer Exception : " + e.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LikeUserVO> listBuyerUserLike(int sns_idx) {
		List<LikeUserVO> list = null;
		try {
			list = (List<LikeUserVO>) list("listBuyerUserLike", sns_idx);
		} catch (Exception e) {
			logger.error("listBuyerUserLike Exception : " + e.getMessage());
			
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DealUserVO> listBuyerUserDeal(int sns_idx) {
		List<DealUserVO> list = null;
		try {
			list = (List<DealUserVO>) list("listBuyerUserDeal", sns_idx);
		} catch (Exception e) {
			logger.error("listBuyerUserDeal Exception : " + e.getMessage());
			
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BasketProductUserVO> listBuyerUserBasket(int sns_idx) {
		List<BasketProductUserVO> list = null;
		try {
			list = (List<BasketProductUserVO>) list("listBuyerUserBasket", sns_idx);
		} catch (Exception e) {
			logger.error("listBuyerUserBasket Exception : " + e.getMessage());
			
		}
		return list;
	}
	

}
