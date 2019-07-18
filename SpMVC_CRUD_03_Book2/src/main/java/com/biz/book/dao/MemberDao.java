package com.biz.book.dao;

import java.util.List;

import com.biz.book.model.MemberVO;

public interface MemberDao {

	public List<MemberVO> selectAll();
	public MemberVO findByUserId(String m_userid);
	
	public List<MemberVO> findByName(String m_name);
	public List<MemberVO> findByTel(String m_tel);
	
	public int insert(MemberVO memverVO);
	public int update(MemberVO memverVO);
	
	/*
	 * 회원정보를 함부로 삭제하기 보다는
	 * 어떤삭제되었다는 표시를하고
	 * 정보를 남겨두는것도 좋은 방법
	 *
	 */
	public int delete(String m_userid);
	
}
