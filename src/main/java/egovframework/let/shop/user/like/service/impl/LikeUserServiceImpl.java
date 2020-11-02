package egovframework.let.shop.user.like.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.like.service.LikeUserDAO;
import egovframework.let.shop.user.like.service.LikeUserService;

@Service("LikeUserService")
public class LikeUserServiceImpl implements LikeUserService{
	
	@Resource(name="LikeUserDAO")
	LikeUserDAO ld;


	@Override
	public List<LikeUserVO> selectLikeUserList(LikeUserVO vo) {
		List<LikeUserVO> list = ld.selectLikeUserList(vo);
		return list;
	}


	@Override
	public int selectLikeUserListCnt(LikeUserVO vo) {
		int cnt = ld.selectLikeUserListCnt(vo);
		return cnt;
	}


	@Override
	public int insertUserLikeSelect(LikeUserVO vo) {
		
		return ld.insertUserLikeSelect(vo);
	}


	@Override
	public int insertUserLike(LikeUserVO vo) {
		
		return ld.insertUserLike(vo);
	}


	@Override
	public int deleteUserLike(LikeUserVO vo) {
		
		return ld.deleteUserLike(vo);
	}


	


	
}
