package com.biz.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.book.model.MemberVO;
import com.biz.book.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService mService;

	//JOIN FORM을 보여주기 위한 매서드
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join(Model model) {

		model.addAttribute("BODY", "JOIN");
		return "home";
	}	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(@ModelAttribute MemberVO memberVO, Model model) {
		mService.insert(memberVO);
		model.addAttribute("MEMBER", memberVO);
		model.addAttribute("BODY","MEMBER-VIEW");
		
		return "home";
	}
	
	
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BODY","LOGIN");
		return "home";
	

	}

	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam String m_userid, @RequestParam String m_password
				,Model model, HttpSession httpSession) {
		
		// 아이디와 비번을 서비스에 보내서 디비를 조회ㅐ하여
		//체크(정상 사용자면 트루, 아니면 펄스를 받는다.
		boolean buser =	mService.member_check(m_userid, m_password);
		
		/*
		 * 사용자가 정상적인 로그인을 수행(아이디와 비번이 모두 맞다)하면
		 * memberVO에서는 사용자 정보가 담길것이고
		 * 그렇지 않으면 null값이 담겨있도록 수행
		 * 
		 * 만약 이미 로그인된 사용자의 정보를 탈취하기 위해 
		 * 재 로그인을 수행할 때
		 * 정상 사용자가 아닐 경우 memberVO가 null이 될것이고
		 * 그로인해 session에 담긴값이 null이 될것이다.
		 * 그러면 사용자는 자동으로 logout한 상태가 되어 보안유지에
		 * 다소 유리하게 된다.
		 */
		MemberVO memberVO =null;
		if(buser) {
			memberVO = mService.findByUserId(m_userid);
		}
		//if(buser) model.addAttribute("USERID",m_userid);
		//MemberVO memberVO = mService.findByUserId(m_userid);
		
		/*
		 * HttpSession
		 * 1. 표준 http 프로토콜 규격에서는 
		 * client가 server에게 request(요청)을 보내면
		 * server는 요청에 맞는 결과를 response(응답)하게되고
		 * client와 server에 연결은 즉시 중단된다.
		 * 이러한 protocol을 stateless(상태를 보관하지 않는)라고 한다.
		 * 
		 * 2. stadeless 환경에서는 client가 server와 연결할 때매다
		 * 새로운 연결이 시작되어 이전에 어떤 수행을 했는지 알 수 없다.
		 * 
		 * 3. 요즘에 web service에서는 login이라는 환경이 필수적으로 요구된다.
		 * 		가. 로그인한 사용자가 누구인가.
		 * 		나. 정상적인 로그인 사용자인가.
		 * 		다. 로그인한 사용자가 원하는 request가 정상적인 권한을 갖는가.
		 * 		
		 * 		라. 이러한 정보를 바탕으노 사용자의 request를 처리할것인가.
		 * 			처리하지 않을것인가를 판단해야한다.
		 * 
		 * 4. 초기에는 사용자의 로그인 정보를 web브라우저에 coocke라는 형태로
		 * 	정보를 저장하고, 로그인 관련 일들을 수행했따.
		 * 	하지만 cookie는 불법적인 사용자에 의해 탈취될 수 있고
		 * 	그로인해 보안상 문제가 발생할 수 있다.
		 * 
		 * 5. 지금 사용자가 login을 정상적으로 수행하면 
		 * 서버에 session이라는	특별한 정보를 메모리에 생성하고
		 * 	그 session의 id(key)를 response정보에 실어서
		 * client에게 보내주고 
		 * 이후에 client는 request정보에 이 session id를 같이 포함하여
		 * 서버로 요청을 보낸다.
		 * 
		 * 6. 그러면 서버는 request 정보에 session id가 있는가를 확인하고
		 * 		그 id를 기준으로하여 login된 정보를 취급하게된다.
		 * 
		 * 7. spring framework(java 포함)에서는 HttpSession이라는 클래스를 제공해주어
		 * 	개발자가 session을 쉽게 취급할 수 있도록 도와준다.
		 */
		if(buser) httpSession.setAttribute("USER",memberVO);
		
		//model.addAttribute("BODY","LOGIN");
		return "home";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		//session제거
		
		httpSession.removeAttribute("USER");
		
		//특정 세션만 널값으로 초기화
		httpSession.setAttribute("USER", null);
		
		return "home";
	}
}
