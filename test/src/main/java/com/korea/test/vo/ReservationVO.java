package com.korea.test.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ReservationVO {
	private int idx;
	private String ReservationDate;
	private int num_people;
	private String camping_idx;
	private String amount;
	
}
