package egovframework.let.shop.user.review.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.review.service.ReviewUserService;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovReviewUserService")
public class ReviewUserServiceImpl extends EgovAbstractServiceImpl implements ReviewUserService {

	@Resource(name="EgovReviewUserDAO")
	private ReviewUserDAO egovReviewDAO;
	
	//리뷰 후기 전체보기
	@Override
	public List<ReviewUserVO> selectReviewList(ReviewUserVO reviewVO) throws Exception {
		System.out.println("reviewVOreviewVODAODAO"+reviewVO);
		List<ReviewUserVO> list = egovReviewDAO.selectReviewList(reviewVO);
		return list;
	}

	//사용자가 작성한 후기 삭제
	@Override
	public int delUserReview(ReviewUserVO reviewVO) throws Exception {
		int result = egovReviewDAO.delUserReview(reviewVO);
		return result;
	}

	//사용자가 작성한 후기 수정
	@Override
	public int updateUserReview(ReviewUserVO reviewVO) throws Exception {
		int result = egovReviewDAO.updateUserReview(reviewVO);
		return result;
	}
	//상품상세에대한 리뷰
	@Override
	public int insertMainUserReview(ReviewUserVO reviewVO) throws Exception {
		int reuslt = egovReviewDAO.insertMainUserReview(reviewVO);
		return reuslt;
	}
	//상품 후기사진 올리기
	@Override
	public int insertPicReview(HttpServletRequest request) throws Exception {
		int result = egovReviewDAO.insertPicReview(request);
		return result ;
	}
	
	//상품 후기 평점
	@Override
	public List<String> selectReviewAvg(ReviewUserVO reviewVO) throws Exception {
		List<String> list = egovReviewDAO.selectReviewAvg(reviewVO);
		return list;
	}

	@Override
	public List<ReviewUserVO> UserSellerReview(ReviewUserVO reviewVO) throws Exception {
		List<ReviewUserVO> list = egovReviewDAO.UserSellerReview(reviewVO);
		return list;
	}

	

}
