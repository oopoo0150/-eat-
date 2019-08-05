package com.closet.great;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("request")
public class RBoardController {
	
	ModelAndView mav;
	
	
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String request(Model mode) {
		
		return "request";
	}

}
