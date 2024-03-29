package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.model.MenuDto;

public interface MenuDao {

		@Select(" select * from tbl_menu where main_id is null ")
		@Results(
				value= {
				@Result(property = "menu_id", column = "menu_id"),
				@Result(property = "menu_subs", column="menu_id",
						javaType = List.class,
						many=@Many(select = "getSubMenu"))
				}
				
				)
		public List<MenuDto> getAllMenu();
		
		@Select(" select * from tbl_menu where main_id = #{menu_id} ")
		public List<MenuDto> getSubMenu(String menu_id);
}
