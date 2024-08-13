package com.korea.test.dao;

import org.springframework.stereotype.Repository;

import com.korea.test.mapper.CustomerMapper;
import com.korea.test.vo.CustomerVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomerDAO {
	
	private final CustomerMapper customerMapper;
	
	public CustomerVO loginCheck(String id) {
		return customerMapper.loginCheck(id);
	}
	
	public CustomerVO checkId(String id) {
		return customerMapper.checkId(id);
	}
	
	public int signUpPage(CustomerVO vo) {
		return customerMapper.signUpPage(vo);
	}
}
