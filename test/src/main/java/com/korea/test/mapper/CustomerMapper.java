package com.korea.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.korea.test.vo.CustomerVO;

@Mapper
public interface CustomerMapper {
	
	public CustomerVO checkId(String id);
	
	public int signUpPage(CustomerVO vo);
	
	public CustomerVO loginCheck(String id);
}
