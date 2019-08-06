package com.closet.great.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Member;
import com.closet.great.dao.MemberDao;

@Service
public class MemberManagerment {
	
	private ModelAndView mav;
	//?�블�?콘텍?�트.xml?�mDao 객체?� ?�결
	@Autowired
	private MemberDao mDao;

	
	//로그?�시 ?�션??로그???�보 ?�?�할거임
	
	public ModelAndView MemberInsert(Member mb) {
		mav = new ModelAndView();
		String view;
		
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		
		//비밃?�호 ?�호??
		mb.setS_pass(pwdEncoder.encode(mb.getS_pass()));
		//DB처리
		if(mDao.MemberInsert(mb)) {

			view = "home";
			mav.addObject("check", 1);
		}else {
			//가???�패
			view = "/signup";
		}
		
			
		mav.setViewName(view);
		return mav;
	}
	
	
		// 중복 ?�이??체크
		public int userIdCheck(String s_id) {
			
			return mDao.checkOverId(s_id);
		}


		//?�네??중복 체크
		public int usernickCheck(String s_nick) {
			
			return mDao.checkOvernick(s_nick);
		}


		public int usermailCheck(String s_mail) {
			// TODO Auto-generated method stub
			return mDao.checkOvermail(s_mail);
		}
	
	
}
