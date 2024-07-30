package com.korea.team_1_kdy.service;

import org.springframework.stereotype.Service;

import com.korea.team_1_kdy.dao.ReservationDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
	private final ReservationDAO reservationDAO;
}
