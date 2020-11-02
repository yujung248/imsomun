package egovframework.let.shop.mng.basket.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.basket.service.BasketMngDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("BasketMngDAO")
public class BasketMngDAOImpl extends EgovAbstractDAO implements BasketMngDAO{
	
	Logger logger = LoggerFactory.getLogger(BasketMngDAOImpl.class);

	@Override
	public int selectListCnt(BasketBuyerMngVO vo) {
		// TODO Auto-generated method stub
		return (int) select("BasketMngListCnt", vo);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<BasketBuyerMngVO> selectList(BasketBuyerMngVO vo) {
		// TODO Auto-generated method stub
		return (List<BasketBuyerMngVO>) list("BasketMngList", vo);
	}

	@Override
	public int updateMngBasket(BasketBuyerMngVO vo) {
		int result = 0;
		try {
			result = update("updateMngBasket", vo);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}


	@Override
	public int deleteMngBasket(int ba_idx) {
		int result = 0;
		try {
			result = delete("deleteMngBasket", ba_idx);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}


	@Override
	public int updateMngBasketQty(BasketMngVO vo) {
		int result = 0;
		try {
			result = update("updateMngBasketQty", vo);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}

}
