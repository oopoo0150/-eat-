
package com.closet.great.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Closet;
import com.closet.great.bean.Clothes_Detail;
import com.closet.great.dao.ClosetDao;
import com.closet.great.dao.ImgDao;
import com.closet.great.util.FileProcess;

@Service
public class ImageManagement {

	private ModelAndView mav;

	@Autowired
	private ImgDao iDao;

	@Autowired
	HttpSession session;

	@Autowired
	FileProcess fileProc;

	int id = 0;


	public ModelAndView imgList(int cl_num) {

		mav = new ModelAndView();
		String view = null;
		List<Clothes_Detail> iList = null;

		iList = iDao.getImgList(cl_num);

		id = cl_num;
		
		mav.addObject("iList", iList);
		mav.addObject("cl_num", id);
		view = "closet_clothes_img";
		mav.setViewName(view);

		return mav;
	}


	public ModelAndView clothesimgAdd(MultipartHttpServletRequest multi) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;
		String color = multi.getParameter("cld_color");
		String size = multi.getParameter("cld_size");
		String content = multi.getParameter("cld_content");
		String season = multi.getParameter("cld_season");
		String amt = multi.getParameter("cld_amount");
		String num = multi.getParameter("cld_clnum");
		int amount = Integer.parseInt(amt);
		int clnum = Integer.parseInt(num);

		String check = multi.getParameter("fileCheck");

		Clothes_Detail cd = new Clothes_Detail();
		cd.setCld_amount(amount);
		cd.setCld_clnum(clnum);
		cd.setCld_color(color);
		cd.setCld_content(content);
		cd.setCld_season(season);
		cd.setCld_size(size);

		HashMap<String, String> f = new HashMap<String, String>();

		if(check.equals("1")) {
			f = fileProc.upFile(multi);
		}

		cd.setCld_oriname(f.get("oriFileName"));
		cd.setCld_sysname(f.get("sysFileName"));

		boolean c = iDao.clothesimgInsert(cd);

		if(c) { 
			
			view = "redirect:imgList?cl_num="+id;}
		else { 
			
			view = "imgAddform"; }


		mav.setViewName(view);


		return mav;
	}


	public ModelAndView imgDetail(int num) {

		mav = new ModelAndView();
		String view = null;
		Clothes_Detail cldImg = null;
		int cld_num = 0;
			
		cldImg = iDao.getimgDetail(num);
		
		cld_num = cldImg.getCld_num();
		
		mav.addObject("cldImg", cldImg);
		mav.addObject("cld_num", cld_num);
		view = "clothes_detail";
		mav.setViewName(view);
		
		return mav;
		
	}


	public ModelAndView imgDelete(int cld_num) {
			
		mav = new ModelAndView();
		String view = null;
		
			if(iDao.imgDelete(cld_num)) {
				view = "redirect:imgList?cl_num="+ id;	
			}
			
			mav.setViewName(view);
		
		return mav;
		
		
	}


	public ModelAndView imgUpdate(MultipartHttpServletRequest multi) {
		mav = new ModelAndView();
		boolean c = false;
		String view = null;
		String color = multi.getParameter("cld_color");
		String size = multi.getParameter("cld_size");
		String content = multi.getParameter("cld_content");
		String season = multi.getParameter("cld_season");
		String amt = multi.getParameter("cld_amount");
		String num = multi.getParameter("cld_num");

		int amount = Integer.parseInt(amt);
		int clnum = Integer.parseInt(num);

		String check = multi.getParameter("fileCheck");

		Clothes_Detail cd = new Clothes_Detail();
		cd.setCld_amount(amount);
		cd.setCld_num(clnum);
		cd.setCld_color(color);
		cd.setCld_content(content);
		cd.setCld_season(season);
		cd.setCld_size(size);

		HashMap<String, String> f = new HashMap<String, String>();

		if(check.equals("1")) {
			f = fileProc.upFile(multi);
			
			cd.setCld_oriname(f.get("oriFileName"));
			cd.setCld_sysname(f.get("sysFileName"));
			

			c = iDao.clothesoriUpdate(cd);
		} else {

			c = iDao.clothessysUpdate(cd);
		}
		

		if(c) { 			
			view = "redirect:imgDetail?cld_num="+num;}
		else { 
			
			view = "imgUpdateform"; }


		mav.setViewName(view);


		return mav;
	}

}
