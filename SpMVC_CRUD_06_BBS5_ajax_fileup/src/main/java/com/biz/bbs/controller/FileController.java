package com.biz.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.service.AjaxFileService;

@Controller
@RequestMapping(value = "/file")
public class FileController {
	
	@Autowired
	AjaxFileService aFService;
	
	
	/*
	 * 	produces = "application/text; charset=UTF-8")
	 * ResponseBody에서 한글을 클라이언트로 보낼때
	 * 한글 인코딩을 처리하라
	 */
	@ResponseBody
	@RequestMapping(value = "/file_up", method = RequestMethod.POST,
			produces = "application/text; charset=UTF-8")
	public String file_up(
			@RequestParam("file")
			MultipartFile file) {
		
		//String originName = file.getOriginalFilename();
		String saveName = aFService.upLoad(file);
		return saveName;
	}
	
}
