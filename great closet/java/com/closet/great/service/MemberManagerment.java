package com.closet.great.service;

import java.io.InputStream;
import java.util.HashMap;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Member;
import com.closet.great.bean.User;
import com.closet.great.dao.MemberDao;

@Service
public class MemberManagerment {
    
    private ModelAndView mav;
    //서블릿 콘텍스트.xml의mDao 객체와 연결
    @Autowired
    private MemberDao mDao;
    
    
    //로그인시 세션에 로그인 정보 저장할거임
    @Autowired
    private HttpSession sesstion;
    
//    @Autowired
//    private JavaMailSender mailSender;
    
    public ModelAndView UserInsert(User us) {
        mav = new ModelAndView();
        String view;
        
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        
        //비밃너호 암호화
        us.setU_pass(pwdEncoder.encode(us.getU_pass()));
        //DB처리
        if(mDao.UserInsert(us)) {
        	//이메일인증 처리
        
            view = "mailCheck";
            mav.addObject("check", 1);
        }else {
            //가입 실패
            view = "/signup";
        }
        
            
        mav.setViewName(view);
        return mav;
    }

	public ModelAndView MemberInsert(Member mb) {
		 mav = new ModelAndView();
	        String view;
	        
	        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
	        
	        //비밃너호 암호화
	        mb.setS_pass(pwdEncoder.encode(mb.getS_pass()));
	        //DB처리
	        if(mDao.MemberInsert(mb)) {
	        	//이메일인증 처리
	        
	            view = "home";
	            mav.addObject("check", 1);
	        }else {
	            //가입 실패
	            view = "signup";
	        }
	        
	            
	        mav.setViewName(view);
	        return mav;
	}
    
        // 중복 아이디 체크
    	@Transactional
        public int userIdCheck(String u_id) {
        	int r = 0;
        	int r2 = 0;
            r = mDao.checkOverId(u_id);
            //r2 = mDao.checkOverId2(u_id);

            System.out.println(r);
            System.out.println(r2);
            int re = r + r2;
            
            System.out.println(re);
            return re;
        }


        //닉네임 중복 체크
        @Transactional
        public int usernickCheck(String u_nick) {
        	int r = 0;
        	int r2 = 0;
        	
            r = mDao.checkOvernick(u_nick);
            //r2 = mDao.checkOvernick2(u_nick);
            
            int re = r + r2;
            
            return re;
        }

        //메일 중복체크
        @Transactional
        public int usermailCheck(String u_mail) {
        	int r = 0;
        	int r2 = 0;
        	r = mDao.checkOvermail(u_mail);
        	//r2 = mDao.checkOvermail2(u_mail);
        
            int re = r + r2;
            
            return re;
        }

        //로그인 처리
		public ModelAndView memberLogin(Member mb) {

			mav = new ModelAndView();
			String view = null;
			
			BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
			
			String endpwd = mDao.getSecurityPwd(mb.getS_id());
			
			if(endpwd != null) {
				if(pwdEncoder.matches(mb.getS_pass(), endpwd)) {
					sesstion.setAttribute("id", mb.getS_id());
					System.out.println(sesstion);
					//메인 화면으로 전환
					// -> 게시판 목록 (이후 처리)
					// 로그인한 회원의 일부 정보
					mb = mDao.getMemberInfo(mb.getS_id());
					mav.addObject("id", sesstion.getAttribute("id"));
					mav.addObject("mb", mb);
					view = "redirect:/";
		            mav.addObject("check", 2);
				}else {
					view = "login";
					mav.addObject("check", 3);
				}
			}else {
				view = "login";
				mav.addObject("check", 4);
			}
			
			mav.setViewName(view);
			return mav;
		}

		public ModelAndView MemberDelete(String id) {
			// TODO Auto-generated method stub
			mav = new ModelAndView();
			String view = null;
			
			mDao.MemberDelete(id);
			
			mav.setViewName("home");
			return mav;
		}

		public ModelAndView findid(String name, String mail ) {
			mav = new ModelAndView();
			String view = null;
			
			Member mb = null;
			
			HashMap<String, String> map = new HashMap<String, String>();
			
			map.put("NAME", name);
			map.put("MAIL", mail);
			
			mb = mDao.Seletefindid(map);
			
			
				if(mb.getS_id() != null) {
					mav.addObject("mb", mb);
					mav.addObject("ch", 1);		
					view = "findedID";
				}else {
					mav.addObject("ch", 2);	
					view = "findid";
				}
				
				mav.setViewName(view);
			
			return mav;
		}

		public ModelAndView findpass(String name, String id, String mail) {
			mav = new ModelAndView();
			String view = null;
			
			Member mb = null;
			
			HashMap<String, String> map = new HashMap<String, String>();
			
			map.put("name", name);
			map.put("id", id);
			map.put("mail", mail);
			
			mb = mDao.Seletefindpass(map);
			if(mb.getS_pass() != null) {
				mav.addObject("che", 1);
				mav.addObject("id", id);
				//view = "mailCheck";
				view = "findedPASS";
			}else {
				mav.addObject("che", 2);
				view = "findpass";
			}
			
			mav.setViewName(view);
			return mav;
		}

		public ModelAndView updatepass(String s_pass, String id) {

			mav = new ModelAndView();
			String view = null;
			BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
			
			HashMap<String, String> map = new HashMap<String, String>();			
	        //비밃너호 암호화
	        pwdEncoder.encode(s_pass);
	        
	        map.put("pass", s_pass);
	        map.put("id", id);
	        
			mDao.updatepass(map);
			mav.addObject("passche", 1);
			view = "login";
			mav.setViewName(view);
			return mav;
		}


    
    
}