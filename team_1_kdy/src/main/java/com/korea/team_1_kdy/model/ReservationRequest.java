package com.korea.team_1_kdy.model;

import java.util.List;

import lombok.Data;

@Data
public class ReservationRequest {
	  private String date;
	    private List<Integer> seats;
}
