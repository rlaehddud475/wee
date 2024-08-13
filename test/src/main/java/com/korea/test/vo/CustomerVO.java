package com.korea.test.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerVO {
	// 고객 테이블 
	
	private int idx;
	private String id;
	private String nickname;
	private String password;
	private String phonenumber;
	private String email;
	private String reservationnumber;
	private String birth;
}
