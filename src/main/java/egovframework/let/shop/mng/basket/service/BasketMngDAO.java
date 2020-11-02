package egovframework.let.shop.mng.basket.service;

import java.util.List;

import egovframework.let.shop.mng.basket.service.impl.BasketBuyerMngVO;
import egovframework.let.shop.mng.basket.service.impl.BasketMngVO;

public interface BasketMngDAO {

	int selectListCnt(BasketBuyerMngVO vo);

	List<BasketBuyerMngVO> selectList(BasketBuyerMngVO vo);

	int updateMngBasket(BasketBuyerMngVO vo);

	int deleteMngBasket(int ba_idx);

	int updateMngBasketQty(BasketMngVO vo);

}
