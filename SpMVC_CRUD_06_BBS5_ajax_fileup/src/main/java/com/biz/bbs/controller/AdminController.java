package com.biz.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@RequestMapping(value = "/system")
	public String system() {
		return "home";
	}
	@RequestMapping(value = "/member")
	public String system1() {
		return "home";
	}
	@RequestMapping(value = "/bbs")
	public String system2() {
		return "home";
	}
}
