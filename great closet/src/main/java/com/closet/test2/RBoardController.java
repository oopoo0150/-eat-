package com.closet.test2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RBoardController {
	
	ModelAndView mav;
	
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String request(Model mode) {
		
		return "request";
	}
	
	@RequestMapping(value = "/rWrite", method = RequestMethod.GET)
	public String rWrite(Model mode) {
		
		return "requestAdd";
	}

}
