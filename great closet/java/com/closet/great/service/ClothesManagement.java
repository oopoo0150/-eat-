package com.closet.great.service;


import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Closet;
import com.closet.great.bean.Clothes;
import com.closet.great.dao.ClosetDao;
import com.closet.great.dao.ClothesDao;

@Service
public class ClothesManagement {

	private ModelAndView mav;

	@Autowired
	private ClothesDao cDao;

	@Autowired
	HttpSession session;

	String id;

	public ModelAndView clothesList(String cl_cnum, String cl_style) {

		mav = new ModelAndView();
		String view = null;
		List<Clothes> cList = null;
		HashMap<String, String> map = new HashMap<String, String>();


		map.put("cl_cnum", cl_cnum);
		map.put("cl_style", cl_style);


		id = cl_cnum;

		cList = cDao.getClothesList(map);


		mav.addObject("cList", cList);
		mav.addObject("cl_cnum", id);
		mav.addObject("cl_style", cl_style);
		view = "closet_clothes_detail";
		mav.setViewName(view);


		return mav;
	}

	public ModelAndView clothesAdd(Clothes clothes) {

		mav = new ModelAndView();
		String view = null;		
		String move = null;

		if(cDao.clothesInsert(clothes)) {
			
			try {
				move = URLEncoder.encode(clothes.getCl_style(), "UTF-8") ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			view = "redirect:clothesList?cl_cnum="+ id + "&cl_style=" + move;

		}

		mav.setViewName(view);


		return mav;
	}

	public boolean clothesDel(List<String> list) {
		
		boolean result = false;
		
		for(int i = 0; i < list.size(); i++) {

			result = cDao.clothesDelete(list.get(i));
		}
				
		return result;

	}

	public ModelAndView clothesUpdate(Clothes clothes) {
		
		mav = new ModelAndView();
		String view = null;
		String move = null;

		if(cDao.clothesUpdate(clothes)) {
			
			try {
				move = URLEncoder.encode(clothes.getCl_style(), "UTF-8") ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			view = "redirect:clothesList?cl_cnum="+ id + "&cl_style=" + move;

		}
		
		mav.setViewName(view);
		
		
		
		return mav;
		
		
	}

}
