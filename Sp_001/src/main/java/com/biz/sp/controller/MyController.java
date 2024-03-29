package com.biz.sp.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.sp.service.HelloService;
/*
 * 스프링아 지금부터 MyController를 네가 관리해달라 하고 요청
 */
@Controller
public class MyController {
	/*
	 * bean으로 설정된 클래스(객체)를 사용하도록 연결해달라고 해달라.
	 */
	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="aa", method=RequestMethod.GET)
	public String myHome(Model model) {
			
	 LocalDate ld = LocalDate.now();
	 LocalTime lt = LocalTime.now();
	 model.addAttribute("date", ld.toString());
	 model.addAttribute("time", lt.toString());
	 String helloMsg= helloService.getHello();
	 model.addAttribute("hello",helloMsg);
	 
	 return "aahome";
	}
		
	
	/*
	 *	/sp/stfor으로 요청을 하면
	 *	/views/stform.jsp를 보여주고
	 *
	 */
	@RequestMapping(value="stfor", method=RequestMethod.GET)
	public String st(Model model) {
		return "st";
		}
	
	/*
	 * stform.jsp의 input tag값에 입력을 한후 전송을 누르면
	 *  /sp/st 요청에 값이 실어서 서버로 전송이 되며
	 * 각각의 데이터는 st_name, st_tel 매개변수에서 받는다.
	 */
	@RequestMapping(value="st", method=RequestMethod.GET)
	public String st(String st_name, String st_tel, Model model) {
		
		System.out.println("여기는 GET수신하는 곳");
		 model.addAttribute("name", st_name);
		 model.addAttribute("tel", st_tel);
		return "sthome";
		}
	
	/*
	 * 입력 form에서 method를 post로 지정하면
	 * Requestmathod.POST로 설정한 메서드가 정보를 수신한다.
	 */
	@RequestMapping(value="st", method=RequestMethod.POST)
	public String st_post(String st_name, String st_tel, Model model) {
		
		System.out.println("여기는 POST수신하는 곳");
		 model.addAttribute("name", st_name);
		 model.addAttribute("tel", st_tel);
		return "sthome";
		}
	}

	
	

