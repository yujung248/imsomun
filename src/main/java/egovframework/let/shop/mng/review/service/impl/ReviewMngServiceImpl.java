package egovframework.let.shop.mng.review.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.review.service.ReviewMngService;
import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovMngReview")
public class ReviewMngServiceImpl extends EgovAbstractServiceImpl implements ReviewMngService {

	@Resource(name = "EgovReviewMngDAO")
	private ReviewMngDAO reviewMngDAO;
	//관리자 리뷰 페이지의 전체 댓글 출력
	@Override
	public List<ReviewMngVO> selectMngList(ReviewMngVO reviewVO) throws Exception {
		List<ReviewMngVO> list = reviewMngDAO.selectMngList(reviewVO);
		return list;
	}
	//관리자 리뷰에서의 댓글 삭제
	@Override
	public int delMngReview(ReviewMngVO vo) throws Exception {
		int result = reviewMngDAO.delMngReview(vo);
		return result;
	}
	//관리자 리뷰에서의 댓글 복구
	@Override
	public int reMngReview(ReviewMngVO vo) throws Exception {
		int result = reviewMngDAO.reMngReview(vo);
		return result;
	}
	//관리자 판매자 리뷰에서의 댓글 출력
	@Override
	public List<ReviewMngVO> selectSellerList(ReviewMngVO vo) throws Exception {
		List<ReviewMngVO> list = reviewMngDAO.selectSellerList(vo);
		return list;
	}
	@Override
	public int selectMngCnt(ReviewMngVO vo) throws Exception {
		int result = reviewMngDAO.selectMngCnt(vo);
		return result;
	}
}
