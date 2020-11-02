package egovframework.let.shop.user.deal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.deal.service.DealUserDAO;
import egovframework.let.shop.user.deal.service.DealUserService;

@Service("DealUserService")
public class DealUserServiceImpl implements DealUserService {
	@Resource(name = "DealUserDAO")
	private DealUserDAO dealUserDAO;
	
	@Override
	public int selectListCntDealUserBuyer(DealUserVO vo) {
		int cnt = dealUserDAO.selectListCntDealUserBuyer(vo);
		return cnt;
	}

	@Override
	public List<DealUserVO> selectListDealUserBuyer(DealUserVO vo) {
		List<DealUserVO> list = dealUserDAO.selectListDealUserBuyer(vo);
		return list;
	}

	@Override
	public DealUserVO selectDealUserBuyerDetail(DealUserVO vo) {
		System.out.println("DealUserServiceImpl selectDealUserBuyerDetail Start...");
		vo = dealUserDAO.selectDealUserBuyerDetail(vo);
		return vo;
	}


	@Override
	public DealUserVO selectDealUserBuyerScore(DealUserVO vo) {
		System.out.println("DealUserServiceImpl selectDealUserBuyerScore Start...");
		vo = dealUserDAO.selectDealUserBuyerScore(vo);
		return vo;
	}
	
	@Override
	public int updateDealUserBuyerDetail(DealUserVO vo) {
		System.out.println("DealUserServiceImpl updateDealUserBuyerDetail Start...");
		vo.setD_ing("2");
		int result = dealUserDAO.updateDealUserIng(vo);
		return result;
	}

	@Override
	public int updateDealUserBuyerCancel(DealUserVO vo) {
		System.out.println("DealUserServiceImpl updateDealUserBuyerCancel Start...");
		vo.setD_ing("5");
		int result = dealUserDAO.updateDealUserIng(vo);
		return result;
	}

	@Override
	public int updateDealUserBuyerComplete(DealUserVO vo) {
		System.out.println("DealUserServiceImpl updateDealUserBuyerComplete Start...");
		vo.setD_ing("4");
		int result = dealUserDAO.updateDealUserIng(vo);
		return result;
	}

	@Override
	public int updateDealUserBuyerD_edate(DealUserVO vo) {
		System.out.println("DealUserServiceImpl updateDealUserBuyerD_edate Start...");
		int result = dealUserDAO.updateDealUserBuyerD_edate(vo);
		return result;
	}

	// 판매자
	@Override
	public int selectListCntDealUserSeller(DealUserVO vo) {
		int cnt = dealUserDAO.selectListCntDealUserSeller(vo);
		return cnt;
	}

	@Override
	public List<DealUserVO> selectListDealUserSeller(DealUserVO vo) {
		List<DealUserVO> list = dealUserDAO.selectListDealUserSeller(vo);
		return list;
	}

	@Override
	public DealUserVO selectDealUserSellerDetail(DealUserVO vo) {
		System.out.println("DealUserServiceImpl selectDealUserSellerDetail Start...");
		vo = dealUserDAO.selectDealUserSellerDetail(vo);
		return vo;
	}

	@Override
	public int updateDealUserSellerAccept(DealUserVO vo) {
		System.out.println("DealUserServiceImpl updateDealUserBuyerCancel Start...");
		vo.setD_ing("2");
		int result = dealUserDAO.updateDealUserIng(vo);
		return result;
	}

	@Override
	public int updateDealUserSellerCancel(DealUserVO vo) {
		System.out.println("DealUserServiceImpl updateDealUserBuyerCancel Start...");
		vo.setD_ing("6");
		int result = dealUserDAO.updateDealUserIng(vo);
		return result;
	}

	@Override
	public int updateDealUserSellerDeliver(DealUserVO vo) {
		System.out.println("DealUserServiceImpl updateDealUserSellerDeliver Start...");
		vo.setD_ing("3");
		int result = dealUserDAO.updateDealUserIng(vo);
		return result;
	}

	@Override
	public DealUserVO selectDealUserBuyerRequest(DealUserVO vo) {
		System.out.println("DealUserServiceImpl selectDealUserBuyerRequest Start...");
		vo = dealUserDAO.selectDealUserBuyerRequest(vo);
		return vo;
	}

	@Override
	public DealUserVO selectDealUserBuyerRequestPro(DealUserVO vo) {
		System.out.println("DealUserServiceImpl selectDealUserBuyerRequestPro Start...");
		vo = dealUserDAO.selectDealUserBuyerRequestPro(vo);
		return vo;
	}

	@Override
	public int selectDealUserBuyerD_idx(DealUserVO vo) {
		System.out.println("DealUserServiceImpl selectDealUserBuyerD_idx Start...");
		int d_idx = dealUserDAO.selectDealUserBuyerD_idx(vo);
		return d_idx;
	}



}
