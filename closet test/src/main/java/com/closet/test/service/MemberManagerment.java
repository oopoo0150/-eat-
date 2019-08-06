package com.closet.test.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.test.bean.Member;
import com.closet.test.dao.MemberDao;

@Service
public class MemberManagerment {
    
    private ModelAndView mav;
    //서블릿 콘텍스트.xml의mDao 객체와 연결
    @Autowired
    private MemberDao mDao;

    @Autowired
    private HttpSession session;
    
    //로그인시 세션에 로그인 정보 저장할거임
    
    public ModelAndView MemberInsert(Member mb) {
        mav = new ModelAndView();
        String view;
        
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        
        //비밃너호 암호화
        mb.setS_pass(pwdEncoder.encode(mb.getS_pass()));
        //DB처리
        if(mDao.MemberInsert(mb)) {

            view = "home";
            mav.addObject("check", 1);
        }else {
            //가입 실패
            view = "/signup";
        }
        
            
        mav.setViewName(view);
        return mav;
    }
    
    
        // 중복 아이디 체크
        public int userIdCheck(String s_id) {
            
            return mDao.checkOverId(s_id);
        }


        //닉네임 중복 체크
        public int usernickCheck(String s_nick) {
            
            return mDao.checkOvernick(s_nick);
        }


        public int usermailCheck(String s_mail) {
            // TODO Auto-generated method stub
            return mDao.checkOvermail(s_mail);
        }


		public ModelAndView memberLogin(Member mb) {

			mav = new ModelAndView();
			String view = null;
			
			BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
			
			String endpwd = mDao.getSecurityPwd(mb.getS_id());
			
			if(endpwd != null) {
				if(pwdEncoder.matches(mb.getS_pass(), endpwd)) {
					session.setAttribute("id", mb.getS_id());
					//메인 화면으로 전환
					// -> 게시판 목록 (이후 처리)
					// 로그인한 회원의 일부 정보
					mb = mDao.getMemberInfo(mb.getS_id());
					mav.addObject("mb", mb);
					view = "redirect:/home";
				}else {
					view = "home";
					mav.addObject("check", 2);
				}
			}else {
				view = "home";
				mav.addObject("check", 2);
			}
			
			mav.setViewName(view);
			return mav;
		}
    
    
}