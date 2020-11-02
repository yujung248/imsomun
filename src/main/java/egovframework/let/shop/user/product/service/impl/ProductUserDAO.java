package egovframework.let.shop.user.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * 게시물 관리를 위한 데이터 접근 클래스
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
@Repository("EgovUserProductDAO")
public class ProductUserDAO extends EgovAbstractDAO {

    /**
     * 조건에 맞는 게시물 목록을 조회 한다.
     *
     * @param boardVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<ProductUserVO> selectUserProductList(ProductUserVO productVO) throws Exception {
	return (List<ProductUserVO>) list("EgovUserProductDAO.selectUserProductList", productVO);
    }
    
    public int selectUserProductListCnt(ProductUserVO productVO) throws Exception {
    	return (Integer)select("EgovUserProductDAO.selectUserProductListCnt", productVO);
    }
    
   public ProductUserVO selectUserProductForm(ProductUserVO vo) throws Exception {
	   return (ProductUserVO) select("EgovUserProductDAO.selectUserProductForm", vo);
   }
    public int updateUserProductPro(ProductUserVO vo) throws Exception {
    	int result = update("EgovUserProductDAO.updateUserProductPro", vo);
    	return result;
    }

	public String insertUserProductPro(ProductUserVO vo) throws Exception {
		String result = (String) insert("EgovUserProductDAO.insertUserProductPro", vo);
		return result;
	}
	public int deleteUserProduct(ProductUserVO vo) throws Exception{
		return update("EgovUserProductDAO.deleteUserProduct", vo);
	}
	
	public ProductUserVO selectBuyerProduct(ProductUserVO vo) throws Exception{
		return (ProductUserVO) select("EgovBuyerProductDAO.selectBuyerProduct",vo);
	}
    
}
