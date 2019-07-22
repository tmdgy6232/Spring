package com.biz.iolist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.iolist.model.IolistVO;

public interface IolistDao {

	@Select(" select * from tbl_iolist ")
	public List<IolistVO> selectAll();
	
	@InsertProvider(type=IolistSql.class,method="iolist_insert_sql")
	public int insert(IolistVO iolistVO);
	
	@UpdateProvider(type = IolistSql.class,method="iolist_insert_sql")
	public int update(IolistVO iolistVO);
	
	@Delete( " DELETE FROM tbl_iolist where io_seq = #{io_seq} ")
	public int delete(long io_seq);
}
  

