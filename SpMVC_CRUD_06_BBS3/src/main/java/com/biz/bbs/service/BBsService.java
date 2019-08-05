package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.BbsDao;
import com.biz.bbs.model.BbsDto;
import com.biz.bbs.model.BbsVO;
import com.biz.bbs.model.FileVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BBsService {
	@Autowired
	BbsDao bDao;
	
	@Autowired
	FileService fileService;
	public List<BbsVO> bbsList(){
		List<BbsVO> bbsList = bDao.selectAll();
		return bbsList;
	}
	

	public List<BbsDto> bbsListForFile(){
		List<BbsDto> bbsList = bDao.selectAllForFile();
		return bbsList;
	}

	/*
	 * 글쓰기를 수행할 때 file을 같이 업로딩을 수행하면
	 * 해당하는 글의 bbS_seq를 조회하여
	 * 파일 table에 저장할 때 같이 저장을 수행해줘야한다.
	 * 
	 * 1. 게시글을 저장하고
	 *    저장후에는 bbsVO.bbs_seq에 새로 형성된 pk값이 담겨잇음
	 * 2. 게시글의 bbs_seq를 조회하여
	 * 3. 파일정보를 insert할 때 해당하는 bbs_seq를 같이 저장해줘야한다.
	 * 4. 게시글을 조회할 때 해당하는 파일들을 같이 조회할 수 있다.
	 */
	public int insert(BbsVO bbsVO) {
		// TODO Auto-generated method stub
		
		//1. 게시글 저장
		int ret = bDao.insert(bbsVO);
		
		if(bbsVO.getBbs_files().size()>0 &&
				!bbsVO.getBbs_files().get(0).getOriginalFilename().isEmpty()) {
			//2. 게시글의
			// 가, bbs_seq가 추가되고
			// 나, uuid 파일이름이 추가된
			// fileList를 생성하고
			List<FileVO> fileList = fileService.getFileList(bbsVO);
			//3. 그 리스트를 모두 insert 수행
			
			fileService.fileListInsert(fileList);
			
			//fileInsert(bbs_seq)
			//long bbs_seq = bbsVO.getBbs_seq();
			//log.debug("게시판 seq : " + bbs_seq);

		}
		return ret;
	}

	public BbsDto getContent(long bbs_seq) {

		BbsDto bbsDto = bDao.findBySeqForFile(bbs_seq);
		return bbsDto;
	}


	



}
