package egovframework.let.shop.mng.testFileUpload.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.testFileUpload.service.TestFileUpload;
import egovframework.let.shop.mng.testFileUpload.service.TestFileUploadService;

@Service("TestFileUploadService")
public class TestFileUploadServiceImpl implements TestFileUploadService {
	
	@Resource(name = "TestFileUploadDAO")
	TestFileUploadDAO testFileUploadDAO;

	@Override
	public int insertTestFileUpload(TestFileUpload vo) {

		return testFileUploadDAO.insertTestFileUpload(vo);
	}

	@Override
	public int selectTestFileUploadCnt(TestFileUploadVO vo) {
		// TODO Auto-generated method stub
		return testFileUploadDAO.selectTestFileUploadCnt(vo);
	}

	@Override
	public List<TestFileUploadVO> listTestFileUpload(TestFileUploadVO vo) {
		// TODO Auto-generated method stub
		return testFileUploadDAO.listTestFileUpload(vo);
	}

	@Override
	public int deleteTestFileUpload(TestFileUploadVO vo) {
		// TODO Auto-generated method stub
		return testFileUploadDAO.deleteTestFileUpload(vo);
	}


}
