package com.korea.team_1_kdy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.team_1_kdy.vo.CustomerVO;
import com.korea.team_1_kdy.vo.PayVO;
import com.korea.team_1_kdy.vo.ReservationVO;

@Mapper
public interface ReservationMapper {
	public List<CustomerVO> mypage(int idx);
	public List<ReservationVO> reservation(String date);
	public List<PayVO> pay();
}
