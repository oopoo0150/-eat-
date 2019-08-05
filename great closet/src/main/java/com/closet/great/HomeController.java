package com.closet.great;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//모델뷰 전역
	ModelAndView mav;
	
	//회원 정보 저장
	@Autowired
	HttpSession session;
	
	
	//홈 메인 화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "home";
	}
	
	//회원가입 화면
	@RequestMapping(value = "/signup")
	public String signup(Model model) {
		logger.info("회원가입 페이지를 열었음");
		
		return "signup";
	}
	
	//로그인 화면
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login() {
		
		
		return mav;
	}
}
