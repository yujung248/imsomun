package egovframework.let.shop.mng.basket.service;

import java.util.List;

import egovframework.let.shop.mng.basket.service.impl.BasketBuyerMngVO;
import egovframework.let.shop.mng.basket.service.impl.BasketMngVO;

public interface BasketMngService {

	int selectListCnt(BasketBuyerMngVO vo);

	List<BasketBuyerMngVO> selectList(BasketBuyerMngVO vo);

	int updateMngBasket(BasketBuyerMngVO vo);

	int deleteMngBasket(BasketMngVO vo);

	int updateMngBasketQty(BasketMngVO vo);
}
