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

	String id = "";
	

	public ModelAndView closetList(String user) {
		mav = new ModelAndView();
		String view = null;
		List<Closet> cList = null;
			
		cList = cDao.getClosetList(user);
		
		id = cList.get(0).getC_sid();
		
		mav.addObject("cList", cList);
		mav.addObject("c_sid", id);
		view = "mp_closet_list";
		mav.setViewName(view);
		
		return mav;
	}



	public ModelAndView closetAdd(Closet closet) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;
		
		
		
		if(cDao.closetInsert(closet)) {
			view = "redirect:closetList?user="+ id;
		}
		
		mav.setViewName(view);
		
		
		return mav;
	}



	public boolean closetDel(List<String> list) {
		// TODO Auto-generated method stub
				
		boolean result = false;
		for(int i = 0; i < list.size(); i++) {

			result = cDao.closetDelete(list.get(i));
		}
				
		return result;
	}



	public ModelAndView closetUpdate(Closet closet) {
		mav = new ModelAndView();
		String view = null;
		
		if(cDao.closetUpdate(closet)) {
			view = "redirect:closetList?user="+ id;
			}
				
		mav.setViewName(view);
		
		
		return mav;
	}

}
