package com.biz.bbs.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.mapper.FileDao;
import com.biz.bbs.model.BbsVO;
import com.biz.bbs.model.FileVO;

@Service
public class FileService {
		
	@Autowired
		FileDao fDao;
	/*
		 * 파일들의 이름을 UUID 이름으로 변경하고 
		 * 변경된 파일들의 이름을 VO에 담아서 리턴하는 메서드
		 */
		public List<FileVO> getFileList(List<MultipartFile> files){
			
			
			
			List<FileVO> fileList = new ArrayList<FileVO>();
			for(MultipartFile file : files) {
				
				String originName = file.getOriginalFilename();
				String uuString = UUID.randomUUID().toString();
				String saveName = uuString + "_" + originName;
			fileList.add(FileVO.builder()
			.file_origin_name(originName)
			.file_name(saveName).build());
			
			}
			
			
			return fileList;
			
		}
		public List<FileVO> getFileList(BbsVO bbsVO){
			String upLoadFolder ="c:/bizwork/upload/";
			List<MultipartFile> files = bbsVO.getBbs_files();
			long bbs_seq = bbsVO.getBbs_seq();
			
			List<FileVO> fileList = new ArrayList<FileVO>();
			for(MultipartFile file : files) {
				String originName = file.getOriginalFilename();
				String uuString = UUID.randomUUID().toString();
				String saveName = uuString +"_"+originName;
				
				fileList.add(
						FileVO.builder()
				.file_bbs_seq(bbs_seq)
				.file_name(saveName)
				.file_origin_name(originName).build());

				File uploadFile
				 	= new File(upLoadFolder, saveName);
				
				try {
					file.transferTo(uploadFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return fileList;
		}
		
		public void fileListInsert(List<FileVO> files) {
			for(FileVO fileVO : files) {
				fDao.insert(fileVO);
			}
		}
		
}
