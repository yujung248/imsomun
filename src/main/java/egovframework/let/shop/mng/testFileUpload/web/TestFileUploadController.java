package egovframework.let.shop.mng.testFileUpload.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.let.shop.mng.testFileUpload.service.TestFileUpload;
import egovframework.let.shop.mng.testFileUpload.service.TestFileUploadService;
import egovframework.let.shop.mng.testFileUpload.service.impl.TestFileUploadServiceImpl;
import egovframework.let.shop.mng.testFileUpload.service.impl.TestFileUploadVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class TestFileUploadController {

	// 테스트용 파일입니다. 파일 업로드에 참고하세요.

	// 로깅용 로거
	private static final Logger logger = LoggerFactory.getLogger(TestFileUploadController.class);

	// DB 삽입용 서비스
	@Resource(name = "TestFileUploadService")
	TestFileUploadService testFileUploadService;

	// 프로퍼티값을 가져오기 위한 프로퍼티 서비스
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	// 파일 처리를 위한 멀티파트 리졸버
	@Resource(name = "multipartResolver")
	CommonsMultipartResolver multipartResolver;

	// 일반적인 리스팅 처리
	@RequestMapping(value = "/shop/mng/testFileUpload/insertTestFileUploadForm")
	public String insertTestFileUpload(@ModelAttribute("searchVO") TestFileUploadVO vo, HttpServletRequest request,
			Model model) {

		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = testFileUploadService.selectTestFileUploadCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<TestFileUploadVO> list = testFileUploadService.listTestFileUpload(vo);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);

		logger.info("totCnt => " + totCnt);
		logger.info("list size => " + list.size());
		logger.info("vo.getPageIndex => " + vo.getPageIndex());

		return "/shop/mng/testFileUpload/insertTestFileUploadForm";
	}

	// 업로드 및 값 입력
	@RequestMapping(value = "/shop/mng/testFileUpload/insertTestFileUploadPro", method = RequestMethod.POST)
	public String insertTestFileUploadPro(HttpServletRequest request, MultipartFile file, TestFileUploadVO vo,
			String path, Model model) throws Exception {
		// 업로드용 경로 설정
		String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
		// 서버에 업로드할 경우엔 프로퍼티에서 경로를 설정할 예정.
		// String uploadPath =
		// propertyService.getString("Globals.fileStorePath");
		System.out.println("uploadPath => " + uploadPath);
		System.out.println("uploadForm POST Start");

		logger.info("originalName : " + file.getOriginalFilename());
		logger.info("Size : " + file.getSize());
		logger.info("contentType : " + file.getContentType());

		// 업로드하고 파일명을 받아온다.
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		logger.info("savedNames: " + savedName);

		// VO에 파일 관련된 값을 수동으로 넘겨준다. savedName이 가장 중요하다.
		vo.setOriginal_file_name(file.getOriginalFilename());
		vo.setStored_file_name(savedName);
		vo.setFile_size(file.getSize());

		// 저장된 VO를 Insert 처리
		int result = testFileUploadService.insertTestFileUpload(vo);

		// 모델에 결과값을 넘겨준다.
		model.addAttribute("msg", result);
		model.addAttribute("savedName", savedName);

		return "redirect:/shop/mng/testFileUpload/insertTestFileUploadForm.do";
	}

	@RequestMapping("/shop/mng/testFileUpload/deleteTestFileUpload")
	public String deleteTestFileUpload(TestFileUploadVO vo, HttpServletRequest request, Model model, RedirectAttributes redirect) {
		// 업로드용 경로 설정
		String uploadPath = request.getSession().getServletContext().getRealPath("/file/");		
		// 서버에 업로드할 경우엔 프로퍼티에서 경로를 설정할 예정.
		// String uploadPath = propertyService.getString("Globals.fileStorePath");
		
		// 서버 파일 삭제
		String deleteFile = uploadPath + vo.getStored_file_name();
		logger.info("deleteFile : " + deleteFile);
		int delResult = deleteFile(deleteFile);
		
		// DB 반영
		int dbResult = testFileUploadService.deleteTestFileUpload(vo);
		
		logger.info("delResult => " + delResult);
		logger.info("dbResult => " + dbResult);
		redirect.addFlashAttribute("delResult", delResult);
		redirect.addFlashAttribute("dbResult", dbResult);

		return "redirect:/shop/mng/testFileUpload/insertTestFileUploadForm.do";
	}

	private int deleteFile(String deleteFile) {
		int result = 0;
		logger.info("deletefile Path : " + deleteFile);
		File file = new File(deleteFile);
		if(file.exists()){
			if(file.delete()){
				System.out.println("파일 삭제 성공");
				result = 1;
			} else {
				System.out.println("파일 삭제 실패");
				result = 0;
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
			result = -1;
		}
		
		return result;
	}

	// 업로드용 메소드. 저장된 파일명을 반환한다.
	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {

		// 랜덤으로 UUID를 생성해 파일 앞에 붙여줄 예정.
		UUID uid = UUID.randomUUID();
		System.out.println("uploadPath => " + uploadPath);

		// 업로드 경로를 확인하고, 경로에 폴더가 존재하지 않을 경우 생성해준다.
		File fileDiretory = new File(uploadPath);
		if (!fileDiretory.exists()) {
			fileDiretory.mkdirs();
			System.out.println("the directory for uploading : " + uploadPath);
		}

		// UUID를 스트링으로 변환해 원래 이름 앞에 붙여준다.
		String savedName = uid.toString() + "_" + originalName;

		String[] invalidName = { "\\\\", "/", ":", "\"", "<", ">", "\\[", "\\]" }; // 윈도우
																					// 파일명으로
																					// 사용할수
																					// 없는
																					// 문자

		for (int i = 0; i < invalidName.length; i++)
			savedName = savedName.replaceAll(invalidName[i], "_"); // 언더바로 치환

		// 저장될 파일 경로를 지정.
		File target = new File(uploadPath, savedName);

		// FileCopyUtils로 경로에 저장해 복사한다.
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
}
