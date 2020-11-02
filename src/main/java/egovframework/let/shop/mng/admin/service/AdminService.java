package egovframework.let.shop.mng.admin.service;

import java.util.List;

import egovframework.let.shop.mng.admin.service.impl.AdminVO;
import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;


public interface AdminService {

	public String selectLoginCheck(AdminVO adminvo)  throws Exception;

	public List<AdminVO> selectListLoginCheck(AdminVO adminvo)throws Exception;

	public int selectListCnt(AdminVO vo);

	public List<AdminVO> selectList(AdminVO vo);

	public AdminVO adminSelect(AdminVO adminVO);

	public int adminUpdate(AdminVO adminVO);

	public int adminInsert(AdminVO vo);

	public int adminDelete(AdminVO adminVO);
}
