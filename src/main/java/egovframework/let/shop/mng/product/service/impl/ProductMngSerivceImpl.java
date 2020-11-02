package egovframework.let.shop.mng.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.product.service.ProductMngService;
import egovframework.let.shop.mng.testFileUpload.service.impl.TestFileUploadVO;
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
@Service("EgovMngProductService")
public class ProductMngSerivceImpl extends EgovAbstractServiceImpl implements ProductMngService {

    @Resource(name = "EgovMngProductDAO")
    private ProductMngDAO mngProductDAO;

	/**
     * 조건에 맞는 게시물 목록을 조회 한다.
     * 
     * @see egovframework.let.cop.bbs.brd.service.EgovBBSManageService#selectBoardArticles(egovframework.let.cop.bbs.brd.service.BoardVO)
     */
    @Override
    public List<ProductMngVO> selectMngProductList(ProductMngVO productVO) throws Exception {
    	List<ProductMngVO> list = mngProductDAO.selectMngProductList(productVO);
    	return list;
    }

	@Override
	public int selectMngProductListCnt(ProductMngVO productVO) throws Exception {
		int cnt = mngProductDAO.selectMngProductListCnt(productVO);
		return cnt;
	}

	@Override
	public ProductMngVO selectMngProductForm(ProductMngVO vo) throws Exception {
		vo = mngProductDAO.selectMngProductForm(vo);
		return vo;
	}

	@Override
	public int updateMngProductPro(ProductMngVO vo)throws Exception {
		int result = mngProductDAO.updateMngProductPro(vo);
		return result;
	}

	@Override
	public int insertMngProductPro(ProductMngVO vo)throws Exception {
		int result = mngProductDAO.insertMngProductPro(vo);
		return result;
	}

	@Override
	public int deleteMngProduct(ProductMngVO vo) throws Exception {
		int result = mngProductDAO.deleteMngProduct(vo);
		return result;
	}

}
