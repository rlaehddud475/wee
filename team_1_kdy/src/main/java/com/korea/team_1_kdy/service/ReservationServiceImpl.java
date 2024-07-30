package com.korea.team_1_kdy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.team_1_kdy.dao.ReservationDAO;
import com.korea.team_1_kdy.vo.CustomerVO;
import com.korea.team_1_kdy.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
	private final ReservationDAO reservationDAO;

	@Override
	public List<ReservationVO> reservation(String date) {
		return reservationDAO.reservation(date);
	}

	@Override
	public List<CustomerVO> mypage(int idx) {
		return reservationDAO.mypage(idx);
	}
}
