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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Member;
import com.closet.great.service.MemberManagerment;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
<<<<<<< HEAD:great closet/src/main/java/com/closet/great/HomeController.java
	
	
=======

	//모델뷰 전역
>>>>>>> e36c0513289350a1e93027fb53f6e746122ba9c5:great closet/java/com/closet/great/HomeController.java
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
<<<<<<< HEAD:great closet/src/main/java/com/closet/great/HomeController.java
	

	
	
		
=======


>>>>>>> e36c0513289350a1e93027fb53f6e746122ba9c5:great closet/java/com/closet/great/HomeController.java
}
