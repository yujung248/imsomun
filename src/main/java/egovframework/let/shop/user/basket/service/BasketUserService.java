package egovframework.let.shop.user.basket.service;

import java.util.List;

import egovframework.let.shop.user.basket.service.impl.BasketProductUserVO;
import egovframework.let.shop.user.basket.service.impl.BasketUserVO;

public interface BasketUserService {

	BasketUserVO selectBasketUser(BasketUserVO vo);

	List<BasketProductUserVO> listBasketUser(BasketProductUserVO vo); 
	
	int listCntBasketUser(BasketProductUserVO vo);

	int insertBasketUserPro(BasketUserVO vo);

	int updateBasketUserQty(BasketUserVO vo);

	int deleteBasketUser(BasketUserVO vo);

	int insertBasketUserCnt(BasketUserVO vo);

	BasketUserVO selectByP_IdxBasketUser(BasketUserVO vo);

}
