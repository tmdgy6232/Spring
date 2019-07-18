package com.biz.book.dao;

import java.util.List;

import com.biz.book.model.BookVO;

public interface BookDao {

	public List<BookVO> selectAll();
	public BookVO findBySeq(long b_seq);
	
	//도서명, 출판사, 저자로 검색하기
	public BookVO findByTitle(String b_title);
	public BookVO findByComp(String b_comp);
	public BookVO findByAute(String b_aute);
	public int insert(BookVO bookVO);
	public int update(BookVO bookVO);
	public int delete(long b_seq);
	
}
