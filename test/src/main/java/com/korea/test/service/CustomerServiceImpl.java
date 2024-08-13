package com.korea.test.service;

import org.springframework.stereotype.Service;

import com.korea.test.dao.CustomerDAO;
import com.korea.test.vo.CustomerVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerDAO customerDAO;

	@Override
	public CustomerVO checkId(String id) {
		return customerDAO.checkId(id);
	}
	
	public int signUpPage(CustomerVO vo) {
		return customerDAO.signUpPage(vo);
	}

	@Override
	public CustomerVO loginchek(String id) {
		return customerDAO.loginCheck(id);
	}
	

}
