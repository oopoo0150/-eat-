package com.closet.great.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Follow;
import com.closet.great.dao.MypageDao;

@Service
public class MPFollowManagement {
	
	private ModelAndView mav;
	
	@Autowired
	private MypageDao myDao;
	
	

	public ModelAndView followingList(String id) {
		
		mav = new ModelAndView();
		
		String tid = "tami";
		fo
		
		List<Follow> followList = null;
		
		followList = myDao.getFollowingList(tid);
		
		mav.addObject("followList", followList);
			
		return mav;		 
		
	}


}
