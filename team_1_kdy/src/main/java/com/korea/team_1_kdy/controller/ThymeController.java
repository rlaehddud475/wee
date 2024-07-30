package com.korea.team_1_kdy.controller;

	import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

	@Controller
	public class ThymeController {
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
		
	}

