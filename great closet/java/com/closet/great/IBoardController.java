package com.closet.great;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.InfoBoard;
import com.closet.great.bean.InfoReply;
import com.closet.great.service.IBoardManagement;

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
	public ModelAndView infoList(Integer pageNum, String in_cate) {
		
		mav = ibm.getBoardList(pageNum, in_cate);
		
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
	public ModelAndView contents(Integer num) {
		ibm.ClickBoard(num);
		mav = ibm.getContents(num);
		return mav;
	}
	
	@RequestMapping(value = "/infoDelete")
	public ModelAndView infoDelete(Integer num) {
		mav = ibm.infoDelete(num);
		
		return mav;
	}
	
	@RequestMapping(value = "/replyInsert", produces = "application/json; charset=UTF-8")
	public @ResponseBody Map<String, List<InfoReply>> replyInsert(InfoReply r){ // json타입으로 변환
		Map<String, List<InfoReply>> rMap = ibm.replyInsert(r);
		
		return rMap;
	}
	
	@RequestMapping(value = "/replyDelete")
	public @ResponseBody Map<String, List<InfoReply>> replyDelete(@RequestParam (value = "num") Integer no){ // json타입으로 변환
		Map<String, List<InfoReply>> rMap = ibm.replyDelete(no);
		
		return rMap;
	}
	
	@RequestMapping(value = "/replyUpdate")
	public ModelAndView replyUpdate(InfoReply info) {
		mav = ibm.replyUpdate(info);
		
		return mav;
	}
	
	
	@RequestMapping(value = "/replyUpdateIn")
	public @ResponseBody Map<String, List<InfoReply>> replyUpdateIn(InfoReply r){ // json타입으로 변환
		Map<String, List<InfoReply>> rMap = ibm.replyUpdateIn(r);
		
		return rMap;
	}
	
	
	
	
	

}