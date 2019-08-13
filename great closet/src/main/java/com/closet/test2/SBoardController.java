package com.closet.test2;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.test2.bean.InfoReply;
import com.closet.test2.bean.ShareReply;
import com.closet.test2.service.SBoardManagement;

@Controller
public class SBoardController {
	
	ModelAndView mav;
	
	@Autowired
	SBoardManagement sbm;
	
	/*
	@RequestMapping(value = "/share", method = RequestMethod.GET)
	public String share(Model mode) {
		
		return "share";
	}
	*/
	@RequestMapping(value = "/share")
	// Method를 생략하면 GET, POST 둘 다 처리
	public ModelAndView boardList(Integer pageNum) {
		// DB 검색하여 목록을 생성
		
		mav = sbm.getBoardList(pageNum);
		
		return mav;
	}
	
	@RequestMapping(value = "/sWrite", method = RequestMethod.GET)
	public String sWrite(Model mode) {
		
		return "shareAdd";
	}
	
	@RequestMapping(value = "/swriteInsert", method = RequestMethod.POST)
	public ModelAndView swriteInsert(MultipartHttpServletRequest multi) {
		mav = sbm.swriteInsert(multi);
		
		return mav;
	}
	
	@RequestMapping(value = "/shareUpdate", method = RequestMethod.GET)
	public ModelAndView shareUpdate(Integer num) {
		mav = sbm.shareUpdate(num);
		
		return mav;
	}
	
	@RequestMapping(value = "/shareUpdateInsert", method = RequestMethod.POST)
	public ModelAndView shareUpdateInsert(MultipartHttpServletRequest multi) {
		mav = sbm.shareUpdateInsert(multi);
		
		return mav;
	}
	
	@RequestMapping(value = "/shareDetail", method = RequestMethod.GET)
	public ModelAndView shareDetail(Integer num) {
		sbm.ClickBoard(num);
		mav = sbm.getContents(num);
		return mav;
	}
	
	@RequestMapping(value = "/shareDelete")
	public ModelAndView shareDelete(Integer num) {
		mav = sbm.shareDelete(num);
		
		return mav;
	}
	
	@RequestMapping(value = "/shareReplyInsert", produces = "application/json; charset=UTF-8")
	public @ResponseBody Map<String, List<ShareReply>> shareReplyInsert(ShareReply r){ // json타입으로 변환
		Map<String, List<ShareReply>> rMap = sbm.replyInsert(r);
		
		return rMap;
	}

}
