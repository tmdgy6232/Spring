package com.biz.iolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	
	private String p_code; //	varchar2(7 byte)
	private String p_name; //	nvarchar2(50 char)
	private int p_iprice; //	number
	private int p_oprice; //	number
	
	
	
}
