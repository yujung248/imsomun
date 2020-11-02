package egovframework.let.shop.mng.review.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovReviewMngDAO")
public class ReviewMngDAO extends EgovAbstractDAO {
	
	/*@Autowired
	private SqlSessionTemplate sqlSessionTemplete;*/
	
	//관리자 구매자 리뷰 페이지의 전체 댓글 출력
	@SuppressWarnings("unchecked")
	public List<ReviewMngVO> selectMngList(ReviewMngVO mngVO) throws Exception{
		return (List<ReviewMngVO>) list("EgovMngReviewDAO.selectMngProList",mngVO);
	}
	
	//관리자 구매자 리뷰에서의 댓글 삭제
	public int delMngReview(ReviewMngVO vo){
		return update("EgovMngReviewDAO.updateMngUserReview",vo);
	}
	
	//관리자 구매자 리뷰에서의 댓글 복구
	public int reMngReview(ReviewMngVO vo) {
		return update("EgovMngReviewDAO.reUpdateMngUserReview",vo);
	}
	//관리자 판매자 리뷰 페이지 전체 댓글 출력
	@SuppressWarnings("unchecked")
	public List<ReviewMngVO> selectSellerList(ReviewMngVO vo) throws Exception {
		return (List<ReviewMngVO>) list("EgovMngReviewDAO.selectMngProList",vo);
	}
	//판매자 CNT
	public int selectMngCnt(ReviewMngVO reviewVO){
		return (Integer) select("EgovMngReviewDAO.selectMngReviewListCnt", reviewVO);
	}
}
