package com.closet.great;

import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Support;
import com.closet.great.service.MPSupportManagement;

import sun.print.resources.serviceui;

@Controller
public class MPSupportController {
	
	//mav생성
	ModelAndView mav;
	
	//Management 생성
	@Autowired
	MPSupportManagement spm;
	
	@Autowired
	HttpSession session;
	
	
	//게시글 상세보기
	@RequestMapping(value = "/spcontents")
	public ModelAndView SpContents(Integer spnum) {
		
		 mav = spm.getSpContents(spnum,"mp_support_detail");
		
		return mav;
	}
	

	//관리자 작성페이지 이동
	@RequestMapping(value = "/spWrite")
	public String MoveSupWrite(Model model) {
		
		return "mp_support_write";
	}
	
	//작성 글 저장 처리를 위한 것
	@RequestMapping(value = "/spBoardInsert", method = RequestMethod.POST)
	public ModelAndView spBoardInsert(Support support) {
		
		String sid = session.getAttribute("id").toString();
		support.setSpsid(sid);
		
		mav = spm.spBoardInsert(support);
		
		return mav;
	}
	
	//게시글 상세보기
	@RequestMapping(value = "/adSpContents")
	public ModelAndView adSpContents(Integer spnum) {
		
		 mav = spm.getSpContents(spnum,"mp_support_detail_ad");
		
		return mav;
	}
	
	//게시물 삭제
	@RequestMapping(value = "/spDel")
	public ModelAndView spBoardDel(Integer spnum) throws RuntimeException {
		
		mav = spm.spBoardDel(spnum);
		
		return mav;
		
	}
	
	//게시물 수정하기 이동
	@RequestMapping(value = "/mspUpdate")
	public ModelAndView moveSpUpdate(Integer spnum) {
		
		mav = spm.moveSpUpdate(spnum);
		
		return mav;
	}
	
	@RequestMapping(value = "/spUpdate", method = RequestMethod.POST)
	public ModelAndView updateSpBoard(Support support) {
		// TODO Auto-generated method stub
		
		mav = spm.spBoardUpdate(support);

		return mav;
	}
	
	//select box 선택값에 따른 리스트 재출력
	@RequestMapping(value = "/supportList")
	public ModelAndView sboxSelList(String spcate, Integer pageNum, String id) {
		
		String cid = session.getAttribute("id").toString();
		
		mav = spm.sboxSelList(spcate, pageNum, cid);
		
		return mav;
	}

	
	
	
	
	
	

}
