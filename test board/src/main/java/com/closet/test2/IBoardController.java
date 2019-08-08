package com.closet.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.test2.bean.InfoBoard;
import com.closet.test2.service.IBoardManagement;

@Controller
public class IBoardController {
	
	ModelAndView mav;
	
	@Autowired
	IBoardManagement ibm;
	
	@RequestMapping(value = "/goInfo", method = RequestMethod.GET)
	public String goInfo(Model mode) {
		
		return "info";
	}
	
	@RequestMapping(value = "/info")
	public ModelAndView infoList(Integer pageNum) {
		
		mav = ibm.getBoardList(pageNum);
		
		return mav;
	}
	
	@RequestMapping(value = "/iWrite", method = RequestMethod.GET)
	public String iWrite(Model mode) {
		
		return "infoAdd";
	}
	
	@RequestMapping(value = "/iwriteInsert", method = RequestMethod.POST)
	public ModelAndView iwriteInsert(InfoBoard board) {
		mav = ibm.writeInsert(board);
		
		return mav;
	}
	
	@RequestMapping(value = "/infoUpdate", method = RequestMethod.GET)
	public ModelAndView infoUpdate(Integer num) {
		mav = ibm.infoUpdate(num);
		
		return mav;
	}
	
	@RequestMapping(value = "/updateInsert", method = RequestMethod.POST)
	public ModelAndView updateInsert(InfoBoard board) {
		mav = ibm.infoUpdateInsert(board);
		
		return mav;
	}
	
	@RequestMapping(value = "/infoDetail", method = RequestMethod.GET)
	public ModelAndView contents(Integer inum) {
		//ibm.ClickBoard(bnum);
		mav = ibm.getContents(inum);
		return mav;
	}
	
//	@RequestMapping(value = "/iwriteInsert", method = RequestMethod.POST)
//	public ModelAndView iwriteInsert(MultipartHttpServletRequest multi) {
//		mav = ibm.writeInsert(multi);
//		
//		return mav;
//	}
	
	

}
