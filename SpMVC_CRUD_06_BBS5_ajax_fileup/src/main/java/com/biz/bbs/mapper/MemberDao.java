package com.biz.bbs.mapper;

import org.apache.ibatis.annotations.Select;

import com.biz.bbs.model.MemberVO;

public interface MemberDao {

	/*
	 * userid로 데이터를 조회할 때
	 * 한사람의 데이터만 추출하기 위해
	 * 반드시 m_userid 칼럼이 pk되어있어야 한다.
	 */
	@Select(" select * from tbl_member where m_userid = #{m_userid}")
	public MemberVO login_id_check(String m_userid);
}
