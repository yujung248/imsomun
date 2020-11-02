package egovframework.let.shop.user.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.product.service.impl.ProductMngVO;
import egovframework.let.shop.user.product.service.ProductUserService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * 게시물 관리를 위한 서비스 구현 클래스
 * @author 공통 서비스 개발팀 한성곤
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
@Service("EgovUserProductService")
public class ProductUserSerivceImpl extends EgovAbstractServiceImpl implements ProductUserService {

    @Resource(name = "EgovUserProductDAO")
    private ProductUserDAO userProductDAO;

	/**
     * 조건에 맞는 게시물 목록을 조회 한다.
     * 
     * @see egovframework.let.cop.bbs.brd.service.EgovBBSManageService#selectBoardArticles(egovframework.let.cop.bbs.brd.service.BoardVO)
     */
    @Override
    public List<ProductUserVO> selectUserProductList(ProductUserVO productVO) throws Exception {
    	List<ProductUserVO> list = userProductDAO.selectUserProductList(productVO);
    	return list;
    }

	@Override
	public int selectUserProductListCnt(ProductUserVO productVO) throws Exception {
		int cnt = userProductDAO.selectUserProductListCnt(productVO);
		return cnt;
	}

	@Override
	public ProductUserVO selectUserProductForm(ProductUserVO vo) throws Exception {
		vo = userProductDAO.selectUserProductForm(vo);
		return vo;
	}

	@Override
	public int updateUserProductPro(ProductUserVO vo) throws Exception {
		int result = userProductDAO.updateUserProductPro(vo);
		return result;
	}

	@Override
	public String insertUserProductPro(ProductUserVO vo) throws Exception {
		String result = userProductDAO.insertUserProductPro(vo);
		return result;
	}

	@Override
	public int deleteUserProduct(ProductUserVO vo) throws Exception {
		int result = userProductDAO.deleteUserProduct(vo);
		return result;
	}

	@Override
	public ProductUserVO selectBuyerProduct(ProductUserVO vo) throws Exception {
		vo = userProductDAO.selectBuyerProduct(vo);
		return vo;
	}

}
