package com.biz.bbs.mapper;

import org.apache.ibatis.jdbc.SQL;

public class BbsSQL {

	public String bbs_insert_sql() {
		SQL sql = new SQL() {{
			INSERT_INTO("tbl_bbs");
			//INTO_COLUMNS("bbs_seq").INTO_VALUES("SEQ_BBS.NEXTVAL");
			INTO_COLUMNS("bbs_seq").INTO_VALUES("#{bbs_seq}");
			INTO_COLUMNS("bbs_main_seq").INTO_VALUES("#{bbs_main_seq}");
			INTO_COLUMNS("bbs_layer").INTO_VALUES("#{bbs_layer}");
			INTO_COLUMNS("bbs_date").INTO_VALUES("#{bbs_date}");
			INTO_COLUMNS("bbs_time").INTO_VALUES("#{bbs_time}");
			INTO_COLUMNS("bbs_auth").INTO_VALUES("#{bbs_auth}");
			INTO_COLUMNS("bbs_title").INTO_VALUES("#{bbs_title}");
			INTO_COLUMNS("bbs_content").INTO_VALUES("#{bbs_content}");
		}};
		
		return sql.toString();
	}
}
