package com.closet.great;


import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Closet;
import com.closet.great.service.ClosetManagement;
import com.closet.great.service.ProductManagement;


@Controller
public class ClosetController {
	
	ModelAndView mav;

	@Autowired
	ClosetManagement cm;

	//세션 호출
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/closetList")
	public ModelAndView closetList(String user) {
		mav = cm.closetList(user);
		
		return mav;
	} 


}
