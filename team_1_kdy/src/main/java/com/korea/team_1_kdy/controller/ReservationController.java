package com.korea.team_1_kdy.controller;

	import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.korea.team_1_kdy.service.ReservationService;
import com.korea.team_1_kdy.vo.ReservationVO;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

	@Controller
	@RequiredArgsConstructor
	public class ReservationController {
		private final ReservationService reservationService;
		@GetMapping("/main")
		public String mian(Model model) {
			return "main";
		}
		
		@GetMapping("/reservation_form")
		public String reservation(Model model) {	
			return "reservation_form";
		}
		
		@GetMapping("/reservation_insert_form")
		public String reservation_insert_form() {
			return "reservation_insert_form";
		}
		
		@PostMapping("/reservation_insert")
		public RedirectView reservation_insert(Model model, String date) {
			List<ReservationVO> list = reservationService.reservation(date);
			model.addAttribute("list",list);
			return new RedirectView("main");
		}
		
		@GetMapping("/pay")
		public String pay() {
			return "pay";
		}
		
		@GetMapping("/weather")
		public String weather(){
			return "weather";
		}
		@GetMapping("/res")
		public String res(){
			return "res";
		}
		
}

