package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.BbsDao;
import com.biz.bbs.model.BbsVO;

@Service
public class BBsService {
	@Autowired
	BbsDao bDao;
	
	public List<BbsVO> bbsList(){
		List<BbsVO> bbsList = bDao.selectAll();
		return bbsList;
	}

	public int insert(BbsVO bbsVO) {
		// TODO Auto-generated method stub
		
		System.out.println(bbsVO.toString());
		int ret = bDao.insert(bbsVO);
		return ret;
	}

	public BbsVO getContent(long bbs_seq) {

		BbsVO bbsVO = bDao.findBySeq(bbs_seq);
		return bbsVO;
	}



}
