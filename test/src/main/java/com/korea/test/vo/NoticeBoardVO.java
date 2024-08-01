package com.korea.test.vo;

import lombok.Data;

@Data
public class NoticeBoardVO {
	 private int notice_idx;
	 private String title;
	 private String content;
	 private String date;
	 private String v_count;
	 private String AuthorId;
}
