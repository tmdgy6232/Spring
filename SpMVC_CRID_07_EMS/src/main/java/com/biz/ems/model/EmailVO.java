package com.biz.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
public class EmailVO {
	private long ems_seq;	//	NUMBER	PRIMARY KEY	,
	
	@NotBlank(message = "*받는 Email은 필수항목입니다.")
	@Email(message ="* Email 형식이 잘못되었습니다.")
	private String ems_to_email;	//	VARCHAR2(50)		not null,

	@NotBlank(message = "*보내는 Email은 필수항목입니다.")
	@Email(message ="* Email 형식이 잘못되었습니다.")
	private String ems_from_email;	//	VARCHAR2(50)		not null,
	
	@NotBlank(message = "*받는 사람이름은 필수항목입니다.")
	private String ems_to_name;	//	nVARCHAR2(50)		not null,
	

	private String ems_from_name;	//	nVARCHAR2(50)		,
	private String ems_send_date;	//	VARCHAR2(10)		not null,
	private String ems_send_time;	//	VARCHAR2(20)		not null,
	

	@NotBlank(message = "* 제목은 필수항목입니다.")
	private String ems_subject;	//	nVARCHAR2(125)		not null,
	
	@NotBlank(message = "* 내용은 필수항목입니다.")
	private String ems_content;	//	nVARCHAR2(1000)		not null,
	private String ems_file1;	//	VARCHAR2(64)		,
	private String ems_file2;	//	VARCHAR2(64)		
}
