package egovframework.let.shop.mng.testFileUpload.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.testFileUpload.service.TestFileUpload;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("TestFileUploadDAO")
public class TestFileUploadDAO extends EgovAbstractDAO {

	public int insertTestFileUpload(TestFileUpload vo) {
		int result = 0;
		try {
			insert("insertTestFileUpload",vo);
			
		} catch (Exception e) {
			System.out.println("TestFileUploadDAO insertTestFileUpload Exception: " + e.getMessage());
		}
		
		return result;
	}

	public int selectTestFileUploadCnt(TestFileUploadVO vo) {
		int cnt = 0;
		
		try {
			cnt = (int) select("selectTestFileUploadCnt",vo);
		} catch (Exception e) {
			System.out.println("TestFileUploadDAO selectTestFileUploadCnt Exception: " + e.getMessage());
		}
		
		return cnt;
	}

	@SuppressWarnings("unchecked")
	public List<TestFileUploadVO> listTestFileUpload(TestFileUploadVO vo) {
		List<TestFileUploadVO> list = null;
		try {
			list = (List<TestFileUploadVO>) list("listTestFileUpload", vo);
		} catch (Exception e) {
			System.out.println("TestFileUploadDAO listTestFileUpload Exception: " + e.getMessage());
		}
		return list;
	}

	public int deleteTestFileUpload(TestFileUploadVO vo) {
		int result = 0;
		try {
			delete("deleteTestFileUpload", vo);
			result = 1;
		} catch (Exception e) {
			System.out.println("TestFileUploadDAO deleteTestFileUpload Exception: " + e.getMessage());
		}
		return result;
	}

}
