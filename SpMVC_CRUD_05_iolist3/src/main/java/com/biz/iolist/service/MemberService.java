package com.biz.iolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.MemberDao;
import com.biz.iolist.model.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {
	
	@Autowired
	MemberDao mDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public String check_id(String m_userid) {
		
		return mDao.check_id(m_userid);
		
	}

	public int insert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		// plan text : 평문
		String strPassword = memberVO.getM_password();
		
		// crypt text : 암호화된 문자열
		String cryptPassword = passwordEncoder.encode(strPassword);
		log.debug("비밀번호 : " + 
				strPassword + " : "
				+ cryptPassword);
		
		memberVO.setM_password(cryptPassword);
		/*
		 * 최초로 가입되는 회원에게 어드민 권한을 부여하고 이후부터는 유저 권한
		 * 을 부여한다.
		 */
		List<MemberVO> memList = mDao.selectAll();
		if(memList.size()>0)memberVO.setM_role("USER");
		else memberVO.setM_role("ADMIN");
		int ret = mDao.insert(memberVO);
		return ret;
	}

	public MemberVO login_check(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
//		MemberVO re_memberVO = mDao.login_id_check(memberVO.getM_userid());
		
		MemberVO re_memberVO = mDao.login_id_check(memberVO);
		if(re_memberVO != null) {//null이면 회원 아이디가 없다.
			// 아이디가 일치하는 회원정보가 있음녀
			// 암호화 되어서 저장된 비밀번호
			String cryptPassword = re_memberVO.getM_password();
			// 로그인할때 입력한 비밀번호
			String strPassword = memberVO.getM_password();
			//평분 비번 암호화 된 비번 비교
			if(passwordEncoder.matches(strPassword, cryptPassword)) {
				return re_memberVO;
			}else {
				return null;
			}
			
		}
		return null;
	}
}
