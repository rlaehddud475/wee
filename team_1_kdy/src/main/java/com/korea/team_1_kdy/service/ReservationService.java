package com.korea.team_1_kdy.service;

import java.util.List;

import com.korea.team_1_kdy.vo.CustomerVO;
import com.korea.team_1_kdy.vo.ReservationVO;

public interface ReservationService {
	public List<CustomerVO> mypage(int idx);
	public List<ReservationVO> reservation(String date);
}
