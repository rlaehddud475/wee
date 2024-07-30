package com.korea.team_1_kdy.dao;

import org.springframework.stereotype.Repository;

import com.korea.team_1_kdy.mapper.ReservationMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReservationDAO {
	private final ReservationMapper reservationMapper;
}
