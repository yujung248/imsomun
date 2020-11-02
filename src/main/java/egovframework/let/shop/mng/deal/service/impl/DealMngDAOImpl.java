package egovframework.let.shop.mng.deal.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.deal.service.DealMngDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("DealMngDAO")
public class DealMngDAOImpl extends EgovAbstractDAO implements DealMngDAO {

/*	@Autowired
    private SqlSession session;
*/	
	@Override
	public int selectListCntDealMng(DealMngVO vo) {
		System.out.println("DealMngDAOImpl selectListCntDealMng Start...");
		int count = 0;
		try {
			count = (int) select("ListCntDealMng", vo);

		} catch (Exception e) {
			System.out.println("ListCntDealMng Exception -> " + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked") // 무점검 경고는, 가능하다면 없애야 한다. 제거할 수 없는 경고 메시지는 형 안정성이 확실할 때만 @SuppressWarnings(“unchecked”) 어노테이션(annotation)을 사용해 억제해야 한다.
	@Override
	public List<DealMngVO> selectListDealMng(DealMngVO vo) {
		System.out.println("DealMngDAOImpl selectListDealMng Start...");
		List<DealMngVO> listDealMng = null;
		try {
			listDealMng = (List<DealMngVO>) list("ListDealMng", vo);

		} catch (Exception e) {
			System.out.println("ListDealMng Exception -> " + e.getMessage());
		}
		return listDealMng;
	}

	@Override
	public DealMngVO selectDealMngBuyerDetail(DealMngVO vo) {
		System.out.println("DealMngDAOImpl selectDealMngBuyerDetail Start...");
		try {
			vo = (DealMngVO) select("selectDealMngBuyerDetail", vo);
			
		} catch (Exception e) {
			System.out.println("selectDealMngBuyerDetail Exception -> " + e.getMessage());
		}
		return vo;
	}

	@Override
	public DealMngVO selectDealMngBuyerScore(DealMngVO vo) {
		System.out.println("DealMngDAOImpl selectDealMngBuyerScore Start...");
		try {
			vo = (DealMngVO) select("selectDealMngBuyerScore", vo);
			
		} catch (Exception e) {
			System.out.println("selectDealMngBuyerScore Exception -> " + e.getMessage());
		}
		return vo;
	}
	
	@Override
	public int updateDealMngIng(DealMngVO vo) {
		System.out.println("DealMngDAOImpl updateDealMngIng Start...");
		int result = 0;
		try {
			result = update("updateDealMngIng", vo);
			
		} catch (Exception e) {
			System.out.println("updateDealMngIng Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateDealMngBuyerCancel(DealMngVO vo) {
		System.out.println("DealMngDAOImpl updateDealMngBuyerCancel Start...");
		int result = 0;
		try {
			result = update("updateDealMngBuyerCancel", vo);
			
		} catch (Exception e) {
			System.out.println("updateDealMngBuyerCancel Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public DealMngVO selectDealMngSellerDetail(DealMngVO vo) {
		System.out.println("DealMngDAOImpl selectDealMngSellerDetail Start...");
		try {
			vo = (DealMngVO) select("selectDealMngSellerDetail", vo);
			
		} catch (Exception e) {
			System.out.println("selectDealMngSellerDetail Exception -> " + e.getMessage());
		}
		return vo;
	}

	@Override
	public int updateDealMngBuyerD_edate(DealMngVO vo) {
		System.out.println("DealMngDAOImpl updateDealMngBuyerD_edate Start...");
		int result = 0;
		try {
			result = update("updateDealMngBuyerD_edate", vo);
			
		} catch (Exception e) {
			System.out.println("updateDealMngBuyerD_edate Exception -> " + e.getMessage());
		}
		return result;
	}



}
