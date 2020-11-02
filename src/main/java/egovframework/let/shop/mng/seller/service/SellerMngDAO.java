package egovframework.let.shop.mng.seller.service;

import java.util.List;

import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;

public interface SellerMngDAO {

	public int selectSellerMngListCnt(SellerMngVO vo);
	public List<SellerMngVO> selectSellerMngList(SellerMngVO vo);
	public SellerMngVO sellerSelect(SellerMngVO vo);
	public int sellerUpdate(SellerMngVO vo);
	public int updateMngSellerStateChange(SellerMngVO vo);
	public String InsertMngSellerPro(SellerMngVO vo);
	public int delMngSeller(SellerMngVO vo);
}
