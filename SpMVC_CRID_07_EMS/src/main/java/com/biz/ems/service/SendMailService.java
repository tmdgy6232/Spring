package com.biz.ems.service;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.biz.ems.model.EmailVO;

@Service
public class SendMailService {

	@Autowired
	JavaMailSender xMail;
	
	@Autowired
	ServletContext context;
	private final String uploadFolder="c:/bizwork/upload/";

	public void sendMail(EmailVO mailVO) {
			
		String from_email = mailVO.getEms_from_email();
		String from_name = mailVO.getEms_from_name();
		String to_email = mailVO.getEms_to_email();
		String subject = mailVO.getEms_subject();
		String content = mailVO.getEms_content();
		
		String file1 = mailVO.getEms_file1();
		String file2 = mailVO.getEms_file2();
		//email에 사용되는 문서구조 생성 : MineMessage라고 한다.
		MimeMessage message = xMail.createMimeMessage();
		
		//메일을 보낼때 사용할 보조도구 선언 
		MimeMessageHelper mHelper;
		
		try {
			//파일을 첨부하기 위해선 반드시 MimeMessageHelper 안에 true 설정을 해주어야한다.
			//false로 했을 시에는 순수한 text만 전송이 된다.
		
			mHelper = new MimeMessageHelper(message,false,"UTF-8");	
			
			
			mHelper.setFrom(from_email,from_name);
			mHelper.setTo(to_email);
			mHelper.setSubject(subject);
			
			//2번째 항목을 true로 하면
			//html방식으로 메일보내기
			//생략하거나 false로하면 text방식으로 메일 보내기
			mHelper.setText(content, true);
			
			//서버의 저장소에 저장된 파일을
			// 메일에 첨부할 수 있도록 변환하는 과정
			//파일첨부를 도와주기 위해 스프링에서 제공하는 메서드
			FileSystemResource fr = null;
			if(!file1.isEmpty()) {
			fr= new FileSystemResource(new File(uploadFolder,file1));
			
			//fr 파일리소스를 file1의 이름으로 첨부하겠다.
			mHelper.addAttachment(file1, fr);
			}
			if(!file2.isEmpty()) {
			fr= new FileSystemResource(new File(uploadFolder,file2));
			
			//fr 파일리소스를 file1의 이름으로 첨부하겠다.
			mHelper.addAttachment(file2, fr);
			}
			xMail.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
