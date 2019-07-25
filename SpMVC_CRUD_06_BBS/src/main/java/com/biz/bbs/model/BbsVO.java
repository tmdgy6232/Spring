package com.biz.bbs.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BbsVO {

	private long bbs_seq;	//	number
	private long bbs_main_seq;	//	number
	private int  bbs_layer;	//	number
	private String bbs_date;	//	varchar2(10 byte)
	private String bbs_time;	//	varchar2(20 byte)
	private String bbs_auth;	//	nvarchar2(50 char)
	private String bbs_title;	//	nvarchar2(255 char)
	private String bbs_content;	//	nvarchar2(1000 char)
}
