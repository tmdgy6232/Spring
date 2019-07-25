package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.biz.bbs.model.BbsVO;

public interface BbsDao {

	@Select(" select * from tbl_bbs ")
	public List<BbsVO> selectAll();

	@InsertProvider(type = BbsSQL.class,method = "bbs_insert_sql")
	@SelectKey(keyProperty = "bbs_seq",
	statement = " select SEQ_BBS.NEXTVALl from dual ",
	resultType = Long.class,
	before = true)
	public int insert(BbsVO bbsVO);
	
	
	
	@Select(" select * from tbl_bbs where bbs_seq = #{bbs_seq} ")
	public BbsVO findBySeq(long bbs_seq);

	
	
}
