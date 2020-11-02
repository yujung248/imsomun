package egovframework.let.shop.mng.deal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.deal.service.DealMng;
import egovframework.let.shop.mng.deal.service.DealMngDAO;
import egovframework.let.shop.mng.deal.service.DealMngService;

@Service("DealMngService")
public class DealMngServiceImpl implements DealMngService {

	@Resource(name = "DealMngDAO")
	private DealMngDAO dealMngDAO;
	
	@Override
	public int selectListCntDealMng(DealMngVO vo) {
		int cnt = dealMngDAO.selectListCntDealMng(vo);
		return cnt;
	}

	@Override
	public List<DealMngVO> selectListDealMng(DealMngVO vo) {
		List<DealMngVO> list = dealMngDAO.selectListDealMng(vo);
		return list;
	}

	@Override
	public DealMngVO selectDealMngBuyerDetail(DealMngVO vo) {
		System.out.println("DealMngServiceImpl selectDealMngBuyerDetail Start...");
		vo = dealMngDAO.selectDealMngBuyerDetail(vo);
		return vo;
	}


	@Override
	public DealMngVO selectDealMngBuyerScore(DealMngVO vo) {
		System.out.println("DealMngServiceImpl selectDealMngBuyerScore Start...");
		vo = dealMngDAO.selectDealMngBuyerScore(vo);
		return vo;
	}
	
	@Override
	public int updateDealMngBuyerDetail(DealMngVO vo) {
		System.out.println("DealMngServiceImpl updateDealMngBuyerDetail Start...");
		vo.setD_ing("2");
		int result = dealMngDAO.updateDealMngIng(vo);
		return result;
	}

	@Override
	public int updateDealMngBuyerCancel(DealMngVO vo) {
		System.out.println("DealMngServiceImpl updateDealMngBuyerCancel Start...");
		vo.setD_ing("5");
		int result = dealMngDAO.updateDealMngIng(vo);
		return result;
	}

	@Override
	public int updateDealMngBuyerComplete(DealMngVO vo) {
		System.out.println("DealMngServiceImpl updateDealMngBuyerComplete Start...");
		vo.setD_ing("4");
		int result = dealMngDAO.updateDealMngIng(vo);
		return result;
	}

	@Override
	public DealMngVO selectDealMngSellerDetail(DealMngVO vo) {
		System.out.println("DealMngServiceImpl selectDealMngSellerDetail Start...");
		vo = dealMngDAO.selectDealMngSellerDetail(vo);
		return vo;
	}

	@Override
	public int updateDealMngSellerAccept(DealMngVO vo) {
		System.out.println("DealMngServiceImpl updateDealMngBuyerCancel Start...");
		vo.setD_ing("2");
		int result = dealMngDAO.updateDealMngIng(vo);
		return result;
	}

	@Override
	public int updateDealMngSellerCancel(DealMngVO vo) {
		System.out.println("DealMngServiceImpl updateDealMngBuyerCancel Start...");
		vo.setD_ing("6");
		int result = dealMngDAO.updateDealMngIng(vo);
		return result;
	}

	@Override
	public int updateDealMngSellerDeliver(DealMngVO vo) {
		System.out.println("DealMngServiceImpl updateDealMngSellerDeliver Start...");
		vo.setD_ing("3");
		int result = dealMngDAO.updateDealMngIng(vo);
		return result;
	}

	@Override
	public int updateDealMngBuyerD_edate(DealMngVO vo) {
		System.out.println("DealMngServiceImpl updateDealMngBuyerD_edate Start...");
		int result = dealMngDAO.updateDealMngBuyerD_edate(vo);
		return result;
	}


}
