package egovframework.let.shop.user.like.service;

import java.util.List;

import egovframework.let.shop.user.like.service.impl.LikeUserVO;

public interface LikeUserService {

	public List<LikeUserVO> selectLikeUserList(LikeUserVO vo);

	public int selectLikeUserListCnt(LikeUserVO vo);

	public int insertUserLike(LikeUserVO vo);

	public int insertUserLikeSelect(LikeUserVO vo);

	public int deleteUserLike(LikeUserVO vo);

	

}
