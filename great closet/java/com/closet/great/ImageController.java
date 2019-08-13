package com.closet.great;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Closet;
import com.closet.great.bean.Clothes;
import com.closet.great.bean.Clothes_Detail;
import com.closet.great.service.ClothesManagement;
import com.closet.great.service.ImageManagement;

@Controller
public class ImageController {
	

	ModelAndView mav;

	@Autowired
	ImageManagement im;

	// 세션 호출
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/ClothesimgAdd")
	public ModelAndView ClothesimgAdd(MultipartHttpServletRequest multi) {
		mav = im.clothesimgAdd(multi);
		
		return mav;
	} 
	
	@RequestMapping(value = "/imgDetail")
	public ModelAndView imgDetail(int cld_num) {
		mav = im.imgDetail(cld_num);
		
		return mav;
	} 


	@RequestMapping(value = "/imgList")
	public ModelAndView imgList(int cl_num) {

		mav = im.imgList(cl_num);

		return mav;
	}
	
	@RequestMapping(value = "/imgAddform")
	public ModelAndView closetClothes(String cl_num) {
		
			
		mav.addObject("cl_num", cl_num);
		mav.setViewName("clothes_add");
				
		return mav;

	}


	@RequestMapping(value = "/imgDelete")
	public ModelAndView imgDelete(int cld_num) {

		mav = im.imgDelete(cld_num);

		return mav;
	}
	
	@RequestMapping(value = "/imgUpdateform")
	public ModelAndView imgUpdateform(Clothes_Detail cd) {
		String veiw = "clothes_update";
		
		mav.addObject(cd);
		mav.setViewName(veiw);

		return mav;
	}
	
	@RequestMapping(value = "/imgUpdate")
	public ModelAndView imgUpdate(MultipartHttpServletRequest multi) {
		mav = im.imgUpdate(multi);
		
		return mav;
	} 
	
	
	
	
}
