package com.biz.memo.model;

public class MemoVO {

	   private long mo_seq;	//q	NUMBER	PRIMARY KEY	NOT NULL,
	   private String mo_date;	//	VARCHAR2(10)		NOT NULL,
	   private String mo_aute;	//	nVARCHAR2(50)		,
	   private String mo_subject;	//	nVARCHAR2(125)	,	
	   private String mo_memo;	//	nVARCHAR2(1000)		);
	   private String mo_time;
	   
	   
	public MemoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemoVO(long mo_seq, String mo_date, String mo_aute, String mo_subject, String mo_memo, String mo_time) {
		super();
		this.mo_seq = mo_seq;
		this.mo_date = mo_date;
		this.mo_aute = mo_aute;
		this.mo_subject = mo_subject;
		this.mo_memo = mo_memo;
		this.mo_time = mo_time;
	}
	public long getMo_seq() {
		return mo_seq;
	}
	public void setMo_seq(long mo_seq) {
		this.mo_seq = mo_seq;
	}
	public String getMo_date() {
		return mo_date;
	}
	public void setMo_date(String mo_date) {
		this.mo_date = mo_date;
	}
	public String getMo_aute() {
		return mo_aute;
	}
	public void setMo_aute(String mo_aute) {
		this.mo_aute = mo_aute;
	}
	public String getMo_subject() {
		return mo_subject;
	}
	public void setMo_subject(String mo_subject) {
		this.mo_subject = mo_subject;
	}
	public String getMo_memo() {
		return mo_memo;
	}
	public void setMo_memo(String mo_memo) {
		this.mo_memo = mo_memo;
	}
	public String getMo_time() {
		return mo_time;
	}
	public void setMo_time(String mo_time) {
		this.mo_time = mo_time;
	}
	@Override
	public String toString() {
		return "MemoVO [mo_seq=" + mo_seq + ", mo_date=" + mo_date + ", mo_aute=" + mo_aute + ", mo_subject="
				+ mo_subject + ", mo_memo=" + mo_memo + ", mo_time=" + mo_time + "]";
	}
	   
	   
	   
}
