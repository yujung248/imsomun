package egovframework.let.shop.mng.seller.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.seller.service.SellerMngDAO;
import egovframework.let.shop.mng.seller.service.SellerMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("SellerMngService")
public class SellerMngServiceImpl extends EgovAbstractServiceImpl implements SellerMngService{

	@Resource(name = "SellerMngDAO")
	private SellerMngDAO SellerDAO;
	
	
	@Override
	public int selectSellerMngListCnt(SellerMngVO vo) {
		int cnt = SellerDAO.selectSellerMngListCnt(vo);
		return cnt;
	}

	@Override
	public List<SellerMngVO> selectSellerMngList(SellerMngVO vo) {
		List<SellerMngVO> list = SellerDAO.selectSellerMngList(vo);
		return list;
	}

	@Override
	public SellerMngVO sellerSelect(SellerMngVO vo) {
		vo = SellerDAO.sellerSelect(vo);
		return vo;
	}

	@Override
	public int sellerUpdate(SellerMngVO vo) {
		int result = SellerDAO.sellerUpdate(vo);
		return result;
	}

	@Override
	public int updateMngSellerStateChange(SellerMngVO vo) {
		int result = SellerDAO.updateMngSellerStateChange(vo);
		return result;
	}
	
	@Override
	public String InsertMngSellerPro(SellerMngVO vo) {
		return SellerDAO.InsertMngSellerPro(vo);
	}

	@Override
	public int delMngSeller(SellerMngVO vo) {
		int result = SellerDAO.delMngSeller(vo);
		return result;
	}

}
