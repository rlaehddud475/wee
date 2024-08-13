package com.korea.test.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.korea.test.mapper.ReservationMapper;
import com.korea.test.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReservationDAO {

	private final ReservationMapper reservationMapper;
	
	public int res_insert(ReservationVO vo) {
		return reservationMapper.res_insert(vo);
	}
	  public List<String> findReservedSeatsByDate(String date) {
	        return reservationMapper.findReservedSeatsByDate(date);
	    }

	
}
