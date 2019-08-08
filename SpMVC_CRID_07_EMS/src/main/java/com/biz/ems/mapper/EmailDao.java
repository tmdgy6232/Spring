package com.biz.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.ems.model.EmailVO;

public interface EmailDao {
	
	@Select(" select * from tbl_ems ")
	public List<EmailVO> selectAll();
	public EmailVO fineBySeq(long ems_seq);
	
	public List<EmailVO> fileByFrom(String ems_from_email);
	public List<EmailVO> fileByTo(String ems_to_email);
	/*
	 * 매개변수가 2개 이상일 경우는
	 * 반드시 @Param으로 변수이름을 명시해 주어야한다.
	 */
	public List<EmailVO> fileByFromAndTo(
			@Param("ems_to_email")String ems_to_email,
			@Param("ems_from_email")String ems_from_email);
	
	
	public int insert(EmailVO emailVO);
	public int update(EmailVO emailVO);
	public int delete(long ems_seq);
	
}
