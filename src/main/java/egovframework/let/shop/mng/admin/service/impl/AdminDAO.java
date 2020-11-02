package egovframework.let.shop.mng.admin.service.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("AdminDAO")
public class AdminDAO extends EgovAbstractDAO{

	public String selectLoginCheck(AdminVO adminvo) {

		return (String) select("AdminDAO.selectLoginCheck",adminvo);
	}

	public List<AdminVO> selectListLoginCheck(AdminVO adminvo) {
		
		return (List<AdminVO>) list("AdminDAO.selectListLoginCheck",adminvo);
	}

	public int adminListCnt(AdminVO vo) {
		System.out.println("adminListCnt");
		int count = 0;
		try{
			count = (int)select("AdminDAO.adminListCnt", vo);
		} catch(Exception e) {
			System.out.println("adminListCnt Exception " + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<AdminVO> selectList(AdminVO vo) {
		System.out.println("selectList");
		return (List<AdminVO>) list ("AdminDAO.adminList",vo);
	}

	public int adminDelete(AdminVO adminVO) {
		int result = 1;
		try {
			result = delete("AdminDAO.adminDelete",adminVO);
		} catch (Exception e) {
			System.out.println();
		}
		return result;
	}

	public AdminVO adminSelect(AdminVO adminVO) {
		try {
			adminVO = (AdminVO) select("AdminDAO.adminSelect",adminVO);
		} catch (Exception e) {
			System.out.println("adminSelect Exception"+e.getMessage());
		}
		return adminVO;
	}

	public int adminUpdate(AdminVO adminVO) {
		int result = 1;
		try {
			result = update("AdminDAO.adminUpdate",adminVO); 
		} catch (Exception e) {
			System.out.println("adminUpdate Exception" + e.getMessage());
		}
		return result;
	}

	public int adminInsert(AdminVO vo) {
		int result = 0;
		try {
			result = (int) insert("AdminDAO.adminInsert",vo);
		} catch (Exception e) {
			System.out.println("adminInsert Exception" + e.getMessage());
		}
		return result;
	}
   

	

	

}
