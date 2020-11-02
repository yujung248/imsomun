package egovframework.let.shop.user.deal.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.user.deal.service.DealUserDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("DealUserDAO")
public class DealUserDAOImpl extends EgovAbstractDAO implements DealUserDAO {

/*	@Autowired
    private SqlSession session;
*/	
	@Override
	public int selectListCntDealUserBuyer(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectListCntDealUserBuyer Start...");
		int countBuyer = 0;
		try {
			countBuyer = (int) select("ListCntDealUserBuyer", vo);

		} catch (Exception e) {
			System.out.println("ListCntDealUserBuyer Exception -> " + e.getMessage());
		}
		return countBuyer;
	}

	@SuppressWarnings("unchecked") // 무점검 경고는, 가능하다면 없애야 한다. 제거할 수 없는 경고 메시지는 형 안정성이 확실할 때만 @SuppressWarnings(“unchecked”) 어노테이션(annotation)을 사용해 억제해야 한다.
	@Override
	public List<DealUserVO> selectListDealUserBuyer(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectListDealUserBuyer Start...");
		List<DealUserVO> listDealUserBuyer = null;
		try {
			listDealUserBuyer = (List<DealUserVO>) list("ListDealUserBuyer", vo);

		} catch (Exception e) {
			System.out.println("ListDealUserBuyer Exception -> " + e.getMessage());
		}
		return listDealUserBuyer;
	}

	@Override
	public DealUserVO selectDealUserBuyerDetail(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectDealUserBuyerDetail Start...");
		try {
			vo = (DealUserVO) select("selectDealUserBuyerDetail", vo);
			
		} catch (Exception e) {
			System.out.println("selectDealUserBuyerDetail Exception -> " + e.getMessage());
		}
		return vo;
	}

	@Override
	public DealUserVO selectDealUserBuyerScore(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectDealUserBuyerScore Start...");
		try {
			vo = (DealUserVO) select("selectDealUserBuyerScore", vo);
			
		} catch (Exception e) {
			System.out.println("selectDealUserBuyerScore Exception -> " + e.getMessage());
		}
		return vo;
	}
	
	@Override
	public int updateDealUserIng(DealUserVO vo) {
		System.out.println("DealUserDAOImpl updateDealUserIng Start...");
		int result = 0;
		try {
			result = update("updateDealUserIng", vo);
			
		} catch (Exception e) {
			System.out.println("updateDealUserIng Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateDealUserBuyerD_edate(DealUserVO vo) {
		System.out.println("DealUserDAOImpl updateDealUserBuyerD_edate Start...");
		int result = 0;
		try {
			result = update("updateDealUserBuyerD_edate", vo);
			
		} catch (Exception e) {
			System.out.println("updateDealUserBuyerD_edate Exception -> " + e.getMessage());
		}
		return result;
	}
	
	//판매자
	@Override
	public int selectListCntDealUserSeller(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectListCntDealUserSeller Start...");
		int countSeller = 0;
		try {
			countSeller = (int) select("ListCntDealUserSeller", vo);

		} catch (Exception e) {
			System.out.println("ListCntDealUserSeller Exception -> " + e.getMessage());
		}
		return countSeller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DealUserVO> selectListDealUserSeller(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectListDealUserSeller Start...");
		List<DealUserVO> listDealUserSeller = null;
		try {
			listDealUserSeller = (List<DealUserVO>) list("ListDealUserSeller", vo);

		} catch (Exception e) {
			System.out.println("ListDealUserSeller Exception -> " + e.getMessage());
		}
		return listDealUserSeller;
	}

	@Override
	public DealUserVO selectDealUserSellerDetail(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectDealUserSellerDetail Start...");
		try {
			vo = (DealUserVO) select("selectDealUserSellerDetail", vo);
			
		} catch (Exception e) {
			System.out.println("selectDealUserSellerDetail Exception -> " + e.getMessage());
		}
		return vo;
	}
	
	// 구매 시
	@Override
	public DealUserVO selectDealUserBuyerRequest(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectDealUserBuyerRequest Start...");
		try {
			vo = (DealUserVO) select("selectDealUserBuyerRequest", vo);
			
		} catch (Exception e) {
			System.out.println("selectDealUserBuyerRequest Exception -> " + e.getMessage());
		}
		return vo;
	}

	@Override
	public DealUserVO selectDealUserBuyerRequestPro(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectDealUserBuyerRequestPro Start...");
		try {
			vo = (DealUserVO) insert("selectDealUserBuyerRequestPro", vo);
			
		} catch (Exception e) {
			System.out.println("selectDealUserBuyerRequestPro Exception -> " + e.getMessage());
		}
		return vo;
	}

	@Override
	public int selectDealUserBuyerD_idx(DealUserVO vo) {
		int d_idx = 0;
		try {
			d_idx = (int) select("selectDealUserBuyerD_idx", vo);

		} catch (Exception e) {
			System.out.println("selectDealUserBuyerD_idx Exception -> " + e.getMessage());
		}
		return d_idx;
	}



}
