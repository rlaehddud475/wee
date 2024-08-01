package com.korea.team_1_kdy.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.korea.team_1_kdy.service.ReservationService;
import com.korea.team_1_kdy.vo.PayVO;
import com.korea.team_1_kdy.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
	public class ReservationController{
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
		@GetMapping("/payment-form")
		public String paymemtForm() {
			return "payment-form";
		}
		
		
		 @PostMapping("/process-payment")
		    public ModelAndView processPayment(
		            @RequestParam("cardNumber") String cardNumber,
		            @RequestParam("cardExpiry") String cardExpiry,
		            @RequestParam("cardCvc") String cardCvc,
		            @RequestParam("amount") int amount,Model model) {
		        // 결제 요청 시뮬레이션
		        System.out.println("결제 요청 수신:");
		        System.out.println("카드 번호: " + cardNumber);
		        System.out.println("유효기간: " + cardExpiry);
		        System.out.println("CVC: " + cardCvc);
		        System.out.println("금액: " + amount);
		        List<PayVO> list = reservationService.pay();
		        model.addAttribute("list", list);
		        // 결과 페이지를 반환합니다.
		        ModelAndView mav = new ModelAndView("payment-result");
		        mav.addObject("amount", amount);
		        return mav;
		      }
		 
		 @GetMapping("/payment")
		 public String patment() {
			 return "payment";
		 }
}