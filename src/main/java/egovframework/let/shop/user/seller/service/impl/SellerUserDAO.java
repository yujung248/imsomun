package egovframework.let.shop.user.seller.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.admin.service.impl.AdminVO;
import egovframework.let.shop.mng.product.service.impl.ProductMngVO;
import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.product.service.impl.ProductUserVO;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.let.shop.user.seller.service.impl.SellerUserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SellerUserDAO")
public class SellerUserDAO extends EgovAbstractDAO {


	public String selectLoginCheck(SellerUserVO sellerVO) throws Exception{
		System.out.println("들감2");
    	System.out.println(sellerVO);
    	return (String) select("EgovSellerDAO.selectLoginCheck1",sellerVO);
	}

	@SuppressWarnings("unchecked")
	public List<SellerUserVO> selectLoginCheck2(SellerUserVO sellervo) {
		System.out.println("list dao");
		return (List<SellerUserVO>) list("EgovSellerDAO.selectLoginListCheck",sellervo);
	}


	public String sellerinsertPro(SellerUserVO vo) {
		 
		return (String) insert("EgovSellerDAO.sellerinsertPro",vo);
	}



	
	public int selectSellerUserListCnt(SellerMngVO vo) {
		System.out.println("selectSellerUserListCnt");
		int count = 0;
		try {
			count = (int) select("selectSellerUserListCnt", vo);
		} catch (Exception e) {
			System.out.println("selectSellerUserListCnt" + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<SellerMngVO> selectSellerUserList(SellerMngVO vo) {
		List<SellerMngVO> SelectSellerUserList = null;
		try {
			SelectSellerUserList = (List<SellerMngVO>) list("SelectSellerUserList", vo);
		} catch (Exception e) {
			System.out.println("SelectSellerUserList Exception" + e.getMessage());
		}
		return SelectSellerUserList;
	}

	public SellerUserVO sellerSearchIdPro(SellerUserVO vo) {
		
		return (SellerUserVO) select("EgovSellerDAO.sellerSearchIdPro",vo);
	}

	public int sellerIdChk(SellerUserVO vo) {
		int result = (int) select("EgovSellerDAO.sellerIdChk",vo);
		return result;
	}

	public int sellerNameEmailChk(SellerUserVO vo) {
		int result = (int) select("EgovSellerDAO.sellerNameEmailChk",vo);
		return result;
	}

	public int sellerAgreeNum(SellerUserVO vo) {
		
		return update("EgovSellerDAO.sellerAgreeNum",vo);
	}

	public int sellerCertificationNumberchk(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return (int) select("EgovSellerDAO.sellerCertificationNumberchk",vo);
	}

	public String sellerFindId(SellerUserVO vo) {
		String result = (String) select("EgovSellerDAO.sellerFindId",vo);
		return result;
	}

	public int sellerRePass(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return (int) update("EgovSellerDAO.sellerRePass",vo);
	}

	 public SellerUserVO selectUserSeller(SellerUserVO vo) {
	      try {
	         vo = (SellerUserVO) select("selectUserSeller", vo);
	      } catch (Exception e) {
	         System.out.println("SellerUserDAO selectUserSeller Exception : " + e.getMessage());
	      }
	      return vo;
	   }

	public int sellerNicknameChk(SellerUserVO vo) {
		
		
		
		return (int) select("EgovSellerDAO.sellerNicknameChk",vo);
	}

	public int sellerEmailChk(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return (int) select("EgovSellerDAO.sellerEmailChk",vo);
	}

	public void updateAgreenum(SellerUserVO vo) {
		update("EgovSellerDAO.updateAgreenum",vo);
		
	}

	public SellerUserVO sellerUserSelect(SellerUserVO vo) {
		try {
			vo = (SellerUserVO) select("sellerUserSelect", vo);
		} catch (Exception e) {
			System.out.println("sellerUserSelect Exception" + e.getMessage());
		}
		return vo;
	}

	public int sellerUserUpdate(SellerUserVO vo) {
		System.out.println("sellerUserUpdate");
		int result = 0;
		try {
			result = update("sellerUserUpdate", vo);
		} catch (Exception e) {
			System.out.println("sellerUserUpdate Exception" + e.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<ProductUserVO> sellerSelectProductList(ProductUserVO vo3) { 
		List<ProductUserVO> list = null;
		try {
			list = (List<ProductUserVO>) list("sellerSelectProductList", vo3);
			System.out.println("sellerSelectProductList list size => "+list.size());
		} catch (Exception e) {
			System.out.println("sellerSelectProductList Exception : " + e.getMessage());
		}
		
		return list;
    }

	@SuppressWarnings("unchecked")
	public List<DealUserVO> sellerSelectDealList(DealUserVO vo2) {
		List<DealUserVO> listDealUserBuyer = null;
		try {
			listDealUserBuyer = (List<DealUserVO>) list("sellerSelectDealList", vo2);
		} catch (Exception e) {
			System.out.println("sellerSelectDealList Exception -> " + e.getMessage());
		}
		return listDealUserBuyer;
	}

	public List<ReviewUserVO> sellerSelectReviewList(ReviewUserVO vo1) {
		return (List<ReviewUserVO>) list("sellerSelectReviewListt",vo1);
	}
    



}
