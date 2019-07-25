package com.biz.iolist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.iolist.model.CompVO;

public interface CompDao {
	
	@Select(" select * from tbl_comp ")
	public List<CompVO> selectAll();
	
	@Select(" select * from tbl_comp where c_code = #{c_code} ")
	public CompVO findByCCode(String c_code);
	
	@Select(" select * from tbl_comp where c_name LIKE '%' || #{c_name} || '%' ")
	public List<CompVO> findByCName(String c_name);
	
	@Select(" select * from tbl_comp where c_tel LIKE '%' || #{c_tel} || '%' ")
	public List<CompVO> findByCTel(String c_tel);
}
