package com.biz.iolist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.iolist.model.MemberVO;

public interface MemberDao {

	@Select(" select m_userid "
			+ " from tbl_member where m_userid = #{m_userid} ")
	public String check_id(String m_userid);

	@InsertProvider(type=MemberSQL.class, method="member_insert_sql")
	public int insert(MemberVO memberVO);

	@Select(" select * FROM tbl_member ")
	public List<MemberVO> selectAll();

	@Select(" select * from tbl_member where m_userid = #{m_userid} ")
	public MemberVO login_id_check(MemberVO memberVO);

//	@Select(" select * from tbl_member where m_userid = #{m_userid} ")
//	public MemberVO login_id_check(String m_userid);
	
}

