package egovframework.let.shop.user.seller.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.admin.service.impl.AdminVO;
import egovframework.let.shop.mng.product.service.impl.ProductMngVO;
import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.product.service.impl.ProductUserVO;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.let.shop.user.seller.service.SellerUserService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("SellerUserService")
public class SellerUserSerivceImpl extends EgovAbstractServiceImpl implements SellerUserService {

    @Resource(name = "SellerUserDAO")
    private SellerUserDAO SellerDAO;

	
	
	public String selectLoginCheck(SellerUserVO sellerVO) throws Exception{
		System.out.println("들감 1");
		System.out.println(sellerVO.getS_id());
		System.out.println(sellerVO.getS_pass());
		
		
		
		return SellerDAO.selectLoginCheck(sellerVO);
	}



	@Override
	public List<SellerUserVO> selectListLoginCheck(SellerUserVO sellervo) throws Exception {
			System.out.println("list impl");
		return (List<SellerUserVO>) SellerDAO.selectLoginCheck2(sellervo);
	}



	@Override
	public String sellerinsertPro(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerinsertPro(vo);
	}


	

	public int selectSellerUserListCnt(SellerMngVO vo) {
		int cnt = SellerDAO.selectSellerUserListCnt(vo);
		return cnt;
	}


	@Override
	public SellerUserVO sellerSearchIdPro(SellerUserVO vo) {
		
		return SellerDAO.sellerSearchIdPro(vo);
	}



	@Override
	public int sellerIdChk(SellerUserVO vo) {
		int result = SellerDAO.sellerIdChk(vo);
		return result;
	}



	@Override
	public int sellerNameEmailChk(SellerUserVO vo) {
		int result = SellerDAO.sellerNameEmailChk(vo);
		return result;
	}



	@Override
	public int sellerAgreeNum(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerAgreeNum(vo);
	}



	@Override
	public int sellerCertificationNumberchk(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return  SellerDAO.sellerCertificationNumberchk(vo);
	}



	@Override
	public String sellerFindId(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerFindId(vo);
	}



	@Override
	public int sellerRePass(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerRePass(vo);
	}



	 @Override
	   public SellerUserVO selectUserSeller(SellerUserVO vo) {
	     return SellerDAO.selectUserSeller(vo);
	   }



	@Override
	public int sellerNicknameChk(SellerUserVO vo) {
		
		return SellerDAO.sellerNicknameChk(vo);
	}



	@Override
	public int sellerEmailChk(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerEmailChk(vo);
	}



	@Override
	public void updateAgreenum(SellerUserVO vo) {
		SellerDAO.updateAgreenum(vo);
		
	}



	@Override
	public SellerUserVO sellerUserSelect(SellerUserVO vo) {
		vo = SellerDAO.sellerUserSelect(vo);
		return vo;
	}



	@Override
	public int sellerUserUpdate(SellerUserVO vo) {
		int result = SellerDAO.sellerUserUpdate(vo);
		return result;
	}


	@Override
	public List<ProductUserVO> sellerSelectProductList(ProductUserVO vo3) {
		List<ProductUserVO> list = SellerDAO.sellerSelectProductList(vo3);
		return list;
	}



	@Override
	public List<DealUserVO> sellerSelectDealList(DealUserVO vo2) {
		List<DealUserVO> list = SellerDAO.sellerSelectDealList(vo2);
		return list;
	}



	@Override
	public List<ReviewUserVO> sellerSelectReviewList(ReviewUserVO vo1) {
		List<ReviewUserVO> list = SellerDAO.sellerSelectReviewList(vo1);
		return list;
	}



}
