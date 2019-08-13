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
import com.closet.great.service.ClothesManagement;

@Controller
public class ClothesController {

	ModelAndView mav;

	@Autowired
	ClothesManagement cm;

	// 세션 호출
	@Autowired
	HttpSession session;

	boolean result = false;

	@RequestMapping(value = "/clothesList")
	public ModelAndView clothesList(String cl_cnum, String cl_style) {

		mav = cm.clothesList(cl_cnum, cl_style);

		return mav;
	}

	@RequestMapping(value = "/clothesAdd")
	public ModelAndView clothesAdd(Clothes clothes) {
		mav = cm.clothesAdd(clothes);

		return mav;
	}

	

	  @RequestMapping(value = "/clothesUpdate")
	  public ModelAndView clothesUpdate(Clothes clothes) {

	  mav = cm.clothesUpdate(clothes);

	  return mav;
	  }

	 

	@RequestMapping(value = "/clothesDel", method = RequestMethod.POST)	 
	public @ResponseBody boolean clothesDel(@RequestParam(value="ls[]")List<String> list) {

		result = cm.clothesDel(list);

		return result; 

	}


}
