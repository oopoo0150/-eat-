package com.closet.great;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Support;
import com.closet.great.service.MPSupportManagement;

@Controller
public class MPSupportController {
	
	//mav생성
	ModelAndView mav;
	
	//Management 생성
	@Autowired
	MPSupportManagement spm;
	
	
	/*사용자*/ 
	
	//spList출력용
	@RequestMapping(value = "/supportList")
	public ModelAndView supportList(Integer pageNum) {
	
		
		mav = spm.getSupportList(pageNum);
		
		return mav;
	}
	
	
	
	
	/*관리자*/
	
	//관리자 화면 리스트 출력
	@RequestMapping(value = "/adminSpList")
	public ModelAndView adminSpList(Integer pageNum) {
		
		mav = spm.getAdminSupList(pageNum);
		
		return mav;
	}
	
	
	//관리자 작성페이지 이동
	@RequestMapping(value = "/spWrite")
	public String MoveSupWrite(Model model) {
		
		return "mp_support_write";
	}
	
	//작성 글 저장 처리를 위한 것
	@RequestMapping(value = "/spBoardInsert")
	public ModelAndView spBoardInsert(Support support) {
		
		mav = spm.spBoardInsert(support);
		
		return mav;
	}
	
	
	

}
