package com.biz.iolist.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberDao {

	@Select(" select m_userid "
			+ " from tbl_member where m_userid = #{m_userid} ")
	public String check_id(String m_userid);
	
}
