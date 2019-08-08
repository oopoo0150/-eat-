package com.closet.great;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.service.MPFollowManagement;

@Controller
public class MPFollowController {
	
	ModelAndView mav;
	
	MPFollowManagement fom;
	
	@RequestMapping(value = "/followerList")
	public ModelAndView followingList(String id) {
		
		mav = fom.followingList(id);
		
		return mav;
	}

}
