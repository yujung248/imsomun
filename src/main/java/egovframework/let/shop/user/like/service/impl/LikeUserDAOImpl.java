package egovframework.let.shop.user.like.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.user.like.service.LikeUserDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("LikeUserDAO")
public class LikeUserDAOImpl extends EgovAbstractDAO implements LikeUserDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<LikeUserVO> selectLikeUserList(LikeUserVO vo) {
		return (List<LikeUserVO>) list("LikeUserDAO.selectLikeUserList",vo);
	}

	@Override
	public int selectLikeUserListCnt(LikeUserVO vo) {
		return (Integer) select("LikeUserDAO.selectLikeUserListCnt", vo);
	}


	@Override
	public int insertUserLike(LikeUserVO vo) {
		int result = 0;
		try {
			insert("insertUserLike",vo);
			result=1;
		} catch (Exception e) {
			System.out.println("LikeUserDAOImpl insertUserLike Exception: " + e.getMessage());
		}
		return result;
	}

	@Override
	public int insertUserLikeSelect(LikeUserVO vo) {
		int result = 0;
		try {
			result = (int) select("insertUserLikeSelect",vo);
		} catch (Exception e) {
			System.out.println("LikeUserDAOImpl insertUserLikeSelect Exception: "+e.getMessage());
		}
		return result;
	}

	@Override
	public int deleteUserLike(LikeUserVO vo) {
		int result=0;
		try{
			result = delete("deleteUserLike",vo);
		}catch (Exception e) {
			System.out.println("LikeUserDAOImpl deleteUserLike Exception"+e.getMessage());
		}
		return result;
	}
  
}
