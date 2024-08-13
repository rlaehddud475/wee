package com.korea.test.service;

import org.springframework.stereotype.Service;

import com.korea.test.vo.CustomerVO;

import lombok.RequiredArgsConstructor;

public interface CustomerService {
	public CustomerVO checkId(String id); 
	
	public CustomerVO loginchek(String id);
}
