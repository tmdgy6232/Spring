package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.model.FileVO;



public interface FileDao {
	
		@Select(" selet * from tbl_bbs_file ")
		public List<FileVO> selectAll();
		
		@Select(" selet * from tbl_bbs_file where file_seq = #{file_seq}")
		public FileVO fineBySeq(long file_seq);
		
		@InsertProvider(type = FileSQL.class, method = "file_insert_sql")
		public int insert(FileVO fileVO);
}
