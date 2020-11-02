package egovframework.let.shop.mng.basket.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.basket.service.BasketMngDAO;
import egovframework.let.shop.mng.basket.service.BasketMngService;

@Service("BasketMngService")
public class BasketMngServiceImpl implements BasketMngService {
	
	@Resource(name = "BasketMngDAO")
	private BasketMngDAO bd;

	@Override
	public int selectListCnt(BasketBuyerMngVO vo) {
		return bd.selectListCnt(vo);
	}

	@Override
	public List<BasketBuyerMngVO> selectList(BasketBuyerMngVO vo) {
		// TODO Auto-generated method stub
		return bd.selectList(vo);
	}

	@Override
	public int updateMngBasket(BasketBuyerMngVO vo) {
		// TODO Auto-generated method stub
		return bd.updateMngBasket(vo);
	}

	@Override
	public int deleteMngBasket(BasketMngVO vo) {

		return bd.deleteMngBasket(vo.getBa_idx());
	}

	@Override
	public int updateMngBasketQty(BasketMngVO vo) {
		return bd.updateMngBasketQty(vo);
	}


}
