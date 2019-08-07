package com.closet.great;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SBoardController {
	
	ModelAndView mav;
	
	@RequestMapping(value = "/share", method = RequestMethod.GET)
	public String share(Model mode) {
		
		return "share";
	}
	
	@RequestMapping(value = "/sWrite", method = RequestMethod.GET)
	public String sWrite(Model mode) {
		
		return "shareAdd";
	}

}
