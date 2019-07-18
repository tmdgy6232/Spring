package com.biz.book.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/*
	 * logger level
	 * ALL, TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF
	 * 
	 * log4j.xml에서
	 * 만약 log level을 warn 설정하면 
	 * ALL,TRACE,DEBURG,INFO를 무시하라
	 * 
	 * 		만약 level을 info 설정을 하면
	 * 		ALL, TRACE, DEBUG를 무시하라
	 */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//콘솔을 통해서 어떤 메시지를 표시하거나
		//변수의 값을 확인하고자 할때는
		//sysout을 사용하지 말고
		//logger를 사용해라.
		logger.debug("나의 메세지");
		logger.debug("log debug");
		logger.debug("log debug");
		logger.debug(""+(30+40));
		logger.debug("표시할 값 {}",30+40);
		logger.debug("표시할 값 {} +{} = {}",30,40);
		logger.info("log info");
		logger.warn("log warn");
		
		//model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
