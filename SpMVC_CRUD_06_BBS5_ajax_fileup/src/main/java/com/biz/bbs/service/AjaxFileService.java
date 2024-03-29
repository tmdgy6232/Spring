package com.biz.bbs.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.bbs.mapper.FileDao;
import com.biz.bbs.model.BBsReqDto;
import com.biz.bbs.model.FileVO;

@Service
public class AjaxFileService {
	
	@Autowired
	FileDao fDao;
	
	/*
	 * 어떤변수에 final 키워드가 붙으면
	 * 이변수의 값을 변경할 수 없다.
	 */
	private final String upLoadFolder = "c:/bizwork/upload/";
	

	/*
	 * 파일 한개를 업로드하는 매서드
	 */
	public String upLoad(MultipartFile file) {
		

		//업로드할 파일 정보다 없으면
		//더이상 코드진행 금지
		if(file.isEmpty() || file == null) return null;
		
		String originName = file.getOriginalFilename();
		String uuString = UUID.randomUUID().toString();
		String saveName = uuString + "_" + originName;
		
		//새로운 디렉토리 생성
		File saveDir = new File(upLoadFolder);
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		File saveFile = new File(upLoadFolder, saveName);
		
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return saveName;
	}
	/*
	 * d여러개의 파일을 업로드하는 매서드
	 */
	public List<FileVO> uploads(MultipartHttpServletRequest files) {
		List<MultipartFile> fileList = files.getFiles("files");
		List<FileVO> fileVOList = new ArrayList<FileVO>();
		
		for(MultipartFile file : fileList) {
			String saveName = this.upLoad(file);
			
			fileVOList.add(FileVO.builder()
			.file_origin_name(file.getOriginalFilename())
			.file_name(saveName).build());
			
		}
		return fileVOList;
	}
	public boolean file_delete(long file_seq) {

		//1. 파일 정보 추출
		FileVO fileVO = fDao.findBySeq(file_seq);
		
		//2. 파일의 물리적 경로 생성
		File delFile = new File(upLoadFolder, fileVO.getFile_name());
		
		// 3. 파일이 있는지 확인 한 후
		if(delFile.exists()) {
			
			// 4. 파일 삭제
			delFile.delete();
			
			// 5. DB 정보 삭제
			fDao.delete(file_seq);
		
			return true;
		}
		
		return false;
		
		
	}
	
	
	
}
