package egovframework.let.shop.user.like.service;

import java.util.List;

import egovframework.let.shop.user.like.service.impl.LikeUserVO;

public interface LikeUserDAO  {

	List<LikeUserVO> selectLikeUserList(LikeUserVO vo);

	int selectLikeUserListCnt(LikeUserVO vo);

	int insertUserLike(LikeUserVO vo);

	int insertUserLikeSelect(LikeUserVO vo);

	int deleteUserLike(LikeUserVO vo);

}
