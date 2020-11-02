package egovframework.let.shop.mng.product.service;

import java.util.List;

import egovframework.let.shop.mng.product.service.impl.ProductMngVO;
import egovframework.let.shop.mng.testFileUpload.service.impl.TestFileUploadVO;

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
public interface ProductMngService {

	public List<ProductMngVO> selectMngProductList(ProductMngVO productVO)
			throws Exception;

	public int selectMngProductListCnt(ProductMngVO productVO) throws Exception;

	public ProductMngVO selectMngProductForm(ProductMngVO vo) throws Exception;

	public int updateMngProductPro(ProductMngVO vo)throws Exception;

	public int insertMngProductPro(ProductMngVO vo)throws Exception;
	
	public int deleteMngProduct(ProductMngVO vo) throws Exception;

}