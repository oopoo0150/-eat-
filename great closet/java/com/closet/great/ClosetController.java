package com.closet.great;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Closet;
import com.closet.great.bean.Clothes;
import com.closet.great.service.ClosetManagement;


@Controller
public class ClosetController {
	
	ModelAndView mav;
	
	boolean result = false;

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
	
	@RequestMapping(value = "/closetAdd")
	public ModelAndView closetAdd(Closet closet) {
		mav = cm.closetAdd(closet);
		
		return mav;
	} 
	
	
	@RequestMapping(value = "/closetClothes")
	public ModelAndView closetClothes(String c_num) {
		
			
		mav.addObject("c_num", c_num);
		mav.setViewName("closet_clothes");
				
		return mav;
	} 
	
	@RequestMapping(value = "/closetUpdate")
	public ModelAndView closetUpdate(Closet closet) {
		
		mav = cm.closetUpdate(closet);
			
		return mav;
	} 
	
	
	@RequestMapping(value = "/closetDel", method = RequestMethod.POST)
	public @ResponseBody boolean closetAdd(@RequestParam(value="ls[]") List<String> list) {
				
		result = cm.closetDel(list);
		
		return result;
	} 
	

}
