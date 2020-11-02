package egovframework.let.shop.user.product.service;

import java.util.List;

import egovframework.let.shop.mng.product.service.impl.ProductMngVO;
import egovframework.let.shop.user.product.service.impl.ProductUserVO;

/**
 * 게시물 관리를 위한 서비스 인터페이스  클래스
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009.03.19
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.19  이삼섭          최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성 
 *  
 *  </pre>
 */
public interface ProductUserService {

	public List<ProductUserVO> selectUserProductList(ProductUserVO productVO)
			throws Exception;

	public int selectUserProductListCnt(ProductUserVO productVO) throws Exception;

	public ProductUserVO selectUserProductForm(ProductUserVO vo) throws Exception;

	public int updateUserProductPro(ProductUserVO vo) throws Exception;

	public String insertUserProductPro(ProductUserVO vo) throws Exception;
	
	public int deleteUserProduct(ProductUserVO vo) throws Exception;
	
	public ProductUserVO selectBuyerProduct(ProductUserVO vo) throws Exception;
}