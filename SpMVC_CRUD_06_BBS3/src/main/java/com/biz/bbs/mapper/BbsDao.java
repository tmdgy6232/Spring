package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.biz.bbs.model.BbsDto;
import com.biz.bbs.model.BbsVO;
import com.biz.bbs.model.FileVO;

public interface BbsDao {

	@Select(" select * from tbl_bbs order by bbs_date DESC, bbs_time DESC ")
	public List<BbsVO> selectAll();

	
	/*
	 * @SelectKey를 사용하여 insert이전에 미리
	 * bbs_Seq값을 생성해두면
	 * service나 controller에서 bbsVO로 부터 bbs_seq를 추출할 수 있다.
	 */
	@InsertProvider(type = BbsSQL.class,method = "bbs_insert_sql")
	@SelectKey(keyProperty = "bbs_seq",
	statement = " select SEQ_BBS.NEXTVAL from dual ",
	resultType = Long.class,
	before = true)
	public int insert(BbsVO bbsVO);
	
	
	//내용확인만을 위한 select문
	@Select(" select * from tbl_bbs where bbs_seq = #{bbs_seq} ")
	public BbsVO findBySeq(long bbs_seq);
	
	//파일 list까지 묶어서 확인을 위한 select
		@Select(" select * from tbl_bbs order by bbs_date desc , bbs_time desc")
		@Results(	value = {
						@Result(property = "bbs_seq", column = "bbs_seq"),
						@Result(property = "bbs_files"
						, column = "bbs_seq",
						many = @Many(select ="getFileList"))
				})
		public List<BbsDto> selectAllForFile();
	
	
	
	//파일 list까지 묶어서 확인을 위한 select
	@Select(" select * from tbl_bbs where bbs_seq = #{bbs_seq} ")
	@Results(
			value = {
					@Result(property = "bbs_seq", column = "bbs_seq"),
					@Result(property = "bbs_files"
					, column = "bbs_seq",
					many = @Many(select ="getFileList"))
			}
			)
	
	public BbsDto findBySeqForFile(long bbs_seq);

	
	@Select(" select * from tbl_bbs_file where file_bbs_seq = #{bbs_seq} ")
	public List<FileVO> getFileList(long bbs_seq);
	
	
}
