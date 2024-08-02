package com.korea	.test.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.korea.test.service.ReservationService;
import com.korea.test.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class reservationController {
	private final ReservationService reservationService;
	
	@GetMapping("/main")
	public String main(Model model) {	
		return "main";
	}
	
	@GetMapping("/reservation_form")						// 예약 페이지 이동
	public String reservation(Model model) {
		
		model.addAttribute("vo", new ReservationVO());
		
		return "reservation_form";
	}
	
	@PostMapping("/reservation_insert")						// 예약 테이블에 저장
	public RedirectView res_insert(ReservationVO vo, Model model)
	{
		// 넘어온 데이터
		// 작성자, 제목, 내용, 비밀번호
		try {
			int res = reservationService.res_insert(vo);
			
			if(res > 0) {
				return new RedirectView("main");
			}
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("errorMessage", "이미 예약이 되어있습니다.");
			return new RedirectView("reservation_form");  // 오류 발생 시 /reservation_form으로 이동
		}
		return new RedirectView("reservation_form");
	}
}