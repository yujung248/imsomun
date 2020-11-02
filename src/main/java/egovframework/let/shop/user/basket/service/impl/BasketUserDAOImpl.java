package egovframework.let.shop.user.basket.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;


import egovframework.let.shop.user.basket.service.BasketUserDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("BasketUserDAO")
public class BasketUserDAOImpl extends EgovAbstractDAO implements BasketUserDAO {

	@Override
	public BasketUserVO selectBasketUser(BasketUserVO vo) {
		try {
			vo = (BasketUserVO) select("selectBasketUser", vo);
		} catch (Exception e) {
			System.out.println("BasketUserDAOImpl selectBasketUser Exception : " + e.getMessage());
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BasketProductUserVO> listBasketUser(BasketProductUserVO vo) {
		List<BasketProductUserVO> list = null;
		try {
			list = (List<BasketProductUserVO>) list("listBasketUser", vo);
		} catch (Exception e) {
			System.out.println("BasketUserDAOImpl listBasketUser Exception : " + e.getMessage());
		}
		return list;
	}

	@Override
	public int listCntBasketUser(BasketProductUserVO vo) {
		int cnt = 0;
		try {
			cnt = (int) select("listCntBasketUser", vo);
		} catch (Exception e) {
			System.out.println("BasketUserDAOImpl listCntBasketUser Exception : " + e.getMessage());
		}
		return cnt;
	}

	@Override
	public int insertBasketUserPro(BasketUserVO vo) {
		int result = 0;
		
		try {
			insert("insertBasketUserPro", vo);
			result = 1;
		} catch (Exception e) {
			System.out.println("BasketUserDAOImpl insertBasketUserPro Exception : " + e.getMessage());
		}
		
		return result;
	}

	@Override
	public int updateBasketUserQty(BasketUserVO vo) {
		int result = 0;
		try {
			result = update("updateBasketUserQty", vo);
			result = 1;
		} catch (Exception e) {
			System.out.println("BasketUserDAOImpl updateBasketUserQty Exception : " + e.getMessage());
		}
		return result;
	}

	@Override
	public int deleteBasketUser(BasketUserVO vo) {
		int result = 0;
		try {
			result = delete("deleteBasketUser", vo);
		} catch (Exception e) {
			System.out.println("BasketUserDAOImpl deleteBasketUser Exception : " + e.getMessage());
		}
		return result;
	}

	@Override
	public int insertBasketUserCnt(BasketUserVO vo) {
		int cnt = 0;
		try {
			cnt = (int) select("insertBasketUserCnt", vo);
		} catch (Exception e) {
			System.out.println("BasketUserDAOImpl insertBasketUserCnt Exception : " + e.getMessage());
		}
		return cnt;
	}

	@Override
	public BasketUserVO selectByP_IdxBasketUser(BasketUserVO vo) {
		try {
			vo = (BasketUserVO) select("selectByP_IdxBasketUser", vo);
		} catch (Exception e) {
			System.out.println("BasketUserDAOImpl selectByP_IdxBasketUser Exception : " + e.getMessage());
		}
		return vo;
	}


	

}
