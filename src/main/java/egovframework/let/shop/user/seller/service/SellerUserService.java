package egovframework.let.shop.user.seller.service;

import java.util.List;

import egovframework.let.shop.mng.product.service.impl.ProductMngVO;
import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.let.shop.user.product.service.impl.ProductUserVO;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.let.shop.user.seller.service.impl.SellerUserVO;

public interface SellerUserService {

	/*
	public List<SellerMngVO> selectSellerList(SellerMngVO sellerVO) throws Exception;

	public int selectSellerListCnt(SellerMngVO sellerVO) throws Exception;
	
	public String selectLoginCheck(SellerMngVO sellerVO) throws Exception;*/

	public String selectLoginCheck(SellerUserVO sellervo)throws Exception;

	public List<SellerUserVO> selectListLoginCheck(SellerUserVO sellervo)throws Exception;

	public String sellerinsertPro(SellerUserVO vo);

	public int selectSellerUserListCnt(SellerMngVO vo);

	public SellerUserVO sellerSearchIdPro(SellerUserVO vo);

	public int sellerIdChk(SellerUserVO vo);

	public int sellerNameEmailChk(SellerUserVO vo);

	public int sellerAgreeNum(SellerUserVO vo);

	public int sellerCertificationNumberchk(SellerUserVO vo);

	public String sellerFindId(SellerUserVO vo);

	public int sellerRePass(SellerUserVO vo);

	public SellerUserVO selectUserSeller(SellerUserVO vo);

	public int sellerNicknameChk(SellerUserVO vo);

	public int sellerEmailChk(SellerUserVO vo);

	public void updateAgreenum(SellerUserVO vo);

	public SellerUserVO sellerUserSelect(SellerUserVO vo);

	public int sellerUserUpdate(SellerUserVO vo);

	public List<ProductUserVO> sellerSelectProductList(ProductUserVO vo3);

	public List<DealUserVO> sellerSelectDealList(DealUserVO vo2);

	public List<ReviewUserVO> sellerSelectReviewList(ReviewUserVO vo1);


}