package com.korea.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.korea.test.service.CustomerService;
import com.korea.test.service.CustomerServiceImpl;
import com.korea.test.vo.CustomerVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CustomerController {
	@Autowired
	HttpSession session;
	
	private final CustomerService customerService;
	private final CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("vo", new CustomerVO());
		return "signup";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("vo", new CustomerVO());
		return "login";
	}
	
	@PostMapping("/signup_page")
    public RedirectView signUpPage(CustomerVO vo) {
		int res = customerServiceImpl.signUpPage(vo);
		
		if(res > 0) {
			return new RedirectView("/main");
		}
		return null;
	} 
	
	
	@PostMapping("/check_id")
	@ResponseBody
	public String check_id(@RequestBody String id, CustomerVO vo) {
		ObjectMapper om = new ObjectMapper();
		
		Map<String, String> data = null;			// key 값을 통해서 value를 얻어옴
		
		try {
			data = om.readValue(id, new TypeReference<Map<String, String>>() {});
		} catch (Exception e) {
			
		}
		
		id = data.get("id");	
		
		vo = customerService.checkId(id);
		
		if(vo == null) {
			return "{\"param\":\"yes\"}";
		}
		session.setAttribute("id", vo);
		return "{\"param\":\"no\"}";
	}
	
	@PostMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(@RequestBody String body) {
		ObjectMapper om = new ObjectMapper();
		
		Map<String, String> data = null;			// key 값을 통해서 value를 얻어옴
		
		try {
			data = om.readValue(body, new TypeReference<Map<String, String>>() {});
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String id = data.get("id");
		String password = data.get("password");
		
		System.out.println(id);
		
		CustomerVO vo = customerService.loginchek(id);
		
		if(vo == null || !vo.getPassword().equals(password)) {
			return "{\"param\":\"no\"}";
		}
		session.setAttribute("id", vo);
		return "{\"param\":\"yes\"}";
		
	}
	
	@GetMapping("/logout")
	public RedirectView logout() {
		session.removeAttribute("id");
		return new RedirectView("/main");
	}
	@GetMapping("/checkLoginStatus")
	@ResponseBody
	public Map<String, Boolean> checkLoginStatus() {
	        Map<String, Boolean> response = new HashMap<>();
	        boolean isLoggedIn = session.getAttribute("id") != null;
	        response.put("loggedIn", isLoggedIn);
	        return response;
	    }
	
}
