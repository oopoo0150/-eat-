package com.closet.great;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("mb")

public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	HttpSession session;
	
	//모델뷰 전역
	ModelAndView mav;

	
	//홈 메인 화면
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model, HttpServletRequest req) {
		
		System.out.println(session.getAttribute("id"));
		logger.info("메인 페이지를 열었음");
		
		return "home";
	}
	
	
	
	//회원가입 화면
	@RequestMapping(value = "/signup")
	public String signup(Model model) {
		logger.info("회원가입 페이지를 열었음");
		
		return "signup";
	}
	//회원가입 화면
		@RequestMapping(value = "/signup2")
		public String signup2(Model model) {
			logger.info("회원가입 페이지를 열었음");
			
			return "signup2";
		}
	//로그인 화면
		@RequestMapping(value = "/login")
		public String login(Model model) {
			logger.info("로그인 페이지를 열었음");
			
			return "login";
		}
		
		//마이페이지 이동
		
		//페이지 구현을 위한 임시 페이지 넘김
		@RequestMapping(value = "/mypage")
		public String mypage(Model model) {
			System.out.println(session.getAttribute("id"));			
			return "mypage";
			
		}
}
