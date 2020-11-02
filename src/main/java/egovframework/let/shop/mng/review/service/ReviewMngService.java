package egovframework.let.shop.mng.review.service;

import java.util.List;

public interface ReviewMngService {

	
	//관리자 리뷰 페이지의 전체 댓글 출력
	public List<ReviewMngVO> selectMngList(ReviewMngVO reviewVO) throws Exception;
	//관리자 리뷰에서의 댓글 삭제
	public int delMngReview(ReviewMngVO vo) throws Exception;
	//관리자 리뷰에서의 댓글 복구
	public int reMngReview(ReviewMngVO vo) throws Exception;
	//관리자 판매자 리뷰에서의 댓글 출력
	public List<ReviewMngVO>selectSellerList(ReviewMngVO vo) throws Exception;
	//판매자 CNT
	public int selectMngCnt(ReviewMngVO vo) throws Exception;
}
