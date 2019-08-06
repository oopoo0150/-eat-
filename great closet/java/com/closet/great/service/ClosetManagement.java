package com.closet.great.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Closet;
import com.closet.great.dao.ClosetDao;

@Service
public class ClosetManagement {
	
	private ModelAndView mav;

	@Autowired
	private ClosetDao cDao;

	@Autowired
	HttpSession session;

	

	public ModelAndView closetList(String user) {
		mav = new ModelAndView();
		String view = null;
		List<Closet> cList = null;
		
		cList = cDao.getClosetList(user);
		
		mav.addObject("cList", cList);
		view = "mp_closet_list";
		mav.setViewName(view);
		
		return mav;
	}

}
