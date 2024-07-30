package com.korea.team_1_kdy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.korea.team_1_kdy.mapper.ReservationMapper;
import com.korea.team_1_kdy.vo.CustomerVO;
import com.korea.team_1_kdy.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReservationDAO {
	private final ReservationMapper reservationMapper;
	public List<CustomerVO> mypage(int idx){
		return reservationMapper.mypage(idx);
	}
	public List<ReservationVO> reservation(String date) {
		return reservationMapper.reservation(date);
	}
}
