package egovframework.let.shop.mng.testFileUpload.service;

import java.util.List;

import egovframework.let.shop.mng.testFileUpload.service.impl.TestFileUploadVO;

public interface TestFileUploadService {

	int insertTestFileUpload(TestFileUpload vo);

	int selectTestFileUploadCnt(TestFileUploadVO vo);

	List<TestFileUploadVO> listTestFileUpload(TestFileUploadVO vo);

	int deleteTestFileUpload(TestFileUploadVO vo);
	
}
