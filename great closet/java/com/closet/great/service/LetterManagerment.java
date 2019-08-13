package com.closet.great.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.LetterBox;
import com.closet.great.dao.LetterDao;

@Service
public class LetterManagerment {
	
	@Autowired
	LetterDao ltDao;
	
	private ModelAndView mav;

	public ModelAndView letterbox(String id) {
		
		mav = new ModelAndView();
		String view = null;
		
		List<LetterBox> LBList = null;
		
		LBList = ltDao.getlblist(id);
		view = "Letterbox";
		
		mav.addObject("LBList", LBList);
		
		mav.setViewName(view);
		
		return mav;
	}
	
}
