package com.closet.great;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.InfoBoard;
import com.closet.great.service.IBoardManagement;

@Controller
public class IBoardController {
	
	ModelAndView mav;
	
	@Autowired
	IBoardManagement ibm;
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(Model mode) {
		
		return "info";
	}
	
	@RequestMapping(value = "/iWrite", method = RequestMethod.GET)
	public String iWrite(Model mode) {
		
		return "infoAdd";
	}
	
	@RequestMapping(value = "/iwriteInsert", method = RequestMethod.POST)
	public ModelAndView iwriteInsert(InfoBoard board) {
		mav = ibm.writeInsert(board);
		
		return mav;
	}
	
//	@RequestMapping(value = "/iwriteInsert", method = RequestMethod.POST)
//	public ModelAndView iwriteInsert(MultipartHttpServletRequest multi) {
//		mav = ibm.writeInsert(multi);
//		
//		return mav;
//	}
	
	

}
