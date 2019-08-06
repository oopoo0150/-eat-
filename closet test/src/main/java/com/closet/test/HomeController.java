package com.closet.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.closet.test.HomeController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//모델뷰 전역
	ModelAndView mav;
	
	
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
	
	//회원가입 화면
		@RequestMapping(value = "/login")
		public String login(Model model) {
			logger.info("로그인 페이지를 열었음");
			
			return "login";
		}
}
