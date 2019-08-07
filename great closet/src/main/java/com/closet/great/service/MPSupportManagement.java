package com.closet.great.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Support;
import com.closet.great.dao.MypageDao;

public class MPSupportManagement {
 
	//mav생성
	private ModelAndView mav;
	
	//Dao객체 새엇ㅇ
	private MypageDao myDao;
	
	
	public ModelAndView getSupportList(Integer pageNum) {
		
		mav = new ModelAndView();
		
		String view = null;
		List<Support> spList = null;
		
		int num = (pageNum == null) ? 1 : pageNum;
		spList = myDao.getSupportList(num);
		
		
		
		
		
		return mav;
	}

}
