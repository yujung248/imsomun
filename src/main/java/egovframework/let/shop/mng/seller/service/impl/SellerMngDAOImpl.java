package egovframework.let.shop.mng.seller.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.seller.service.SellerMngDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SellerMngDAO")
public class SellerMngDAOImpl extends EgovAbstractDAO implements SellerMngDAO {

	@Override
	public int selectSellerMngListCnt(SellerMngVO vo) {
		System.out.println("selectSellerMngListCnt");
		int count = 0;
		try {
			count = (int) select("selectSellerMngListCnt", vo);

		} catch (Exception e) {
			System.out.println("selectSellerMngListCnt Exception " + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SellerMngVO> selectSellerMngList(SellerMngVO vo) {
		List<SellerMngVO> Sellerlist = null;
		try {
			Sellerlist = (List<SellerMngVO>) list("selectSellerMngList", vo);

		} catch (Exception e) {
			System.out.println("selectSellerMngList Exception " + e.getMessage());
		}
		return Sellerlist;
	}

	@Override
	public SellerMngVO sellerSelect(SellerMngVO vo) {
		try {
			vo = (SellerMngVO) select("sellerSelect", vo);
		} catch (Exception e) {
			System.out.println("sellerSelect Exception" + e.getMessage());
		}
		return vo;
	}

	@Override
	public int sellerUpdate(SellerMngVO vo) {
		System.out.println("SellerMngDAOImpl sellerUpdate");
		int result = 0;
		try {
			result = update("sellerUpdate", vo);
		} catch (Exception e) {
			System.out.println("sellerUpdate Exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateMngSellerStateChange(SellerMngVO vo) {
		System.out.println("SellerMngDAOImpl updateMngSellerStateChange()");
		int result = 0;
		try {
			result = update("updateMngSellerStateChange", vo.getS_id());
		} catch (Exception e) {
			System.out.println("updateMngSellerStateChange Exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public String InsertMngSellerPro(SellerMngVO vo) {
		return (String) insert("InsertMngSellerPro", vo);
	}

	@Override
	public int delMngSeller(SellerMngVO vo) {
		return update("ck.ckupdateMngSellerStateChange",vo); 
	}

}
