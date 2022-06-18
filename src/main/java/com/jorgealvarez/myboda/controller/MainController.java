package com.jorgealvarez.myboda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "users/login";
	}
	
	@GetMapping(value={"/", "index"})
	public String home() {
		return "index";
	}
}
