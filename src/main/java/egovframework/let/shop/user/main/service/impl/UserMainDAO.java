package egovframework.let.shop.user.main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("userMainDAO")
public class UserMainDAO extends EgovAbstractDAO{

	@SuppressWarnings("unchecked")
	public List<UserMainVO> selectMainList(UserMainVO vo) {
		System.out.println("UserMainDAO");
		List<UserMainVO> list = null;
		try {
			list = (List<UserMainVO>) list("UserMainDAO.selectMainList", vo);

		} catch (Exception e) {
			System.out.println("BuyerSelectList Exception " + e.getMessage());
		}
		
		return list;
	}

	public int selectCount() {
		int count=0;
		try {
			count = (int) select("UserMainDAO.selectCount");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<UserMainVO> MainSearch(UserMainVO vo) {
		
		return (List<UserMainVO>) list("UserMainDAO.MainSearch",vo);
	}

/*	@SuppressWarnings("unchecked")
	public List<UserMainVO> selectMainList2(List<Integer> list2) {
		List<UserMainVO> list = null;
		try {
			list= (List<UserMainVO>) list("UserMainDAO.selectMainList2",list2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}*/

		
}
