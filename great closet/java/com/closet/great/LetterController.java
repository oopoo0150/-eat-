package com.closet.great;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.service.LetterManagerment;

/**
 * Servlet implementation class LetterController
 */
@Controller



public class LetterController {   
    
	@Autowired
	HttpSession session;
	
	ModelAndView mav;
	
	@Autowired
	LetterManagerment lm;
	
	@RequestMapping(value = "/letterbox", method = RequestMethod.GET)
	public ModelAndView letterbox(HttpServletRequest req){
		
		String id = req.getParameter("id");
		
		mav = lm.letterbox(id);
		
		return mav;
	}

}
