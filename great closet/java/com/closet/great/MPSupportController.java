package com.closet.great;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.service.MPSupportManagement;

@Controller
public class MPSupportController {
	
	//mav생성
	ModelAndView mav;
	
	//Management 생성
	MPSupportManagement spm;
	
	
	/*사용자*/
	
	//spList출력용
	public ModelAndView supportList(Integer pageNum) {
		
		mav = spm.getSupportList(pageNum);
		
		return mav;
	}
	
	
	
	
	/*관리자*/
	
	
	//관리자 작성
	@RequestMapping(value = "/spWrite")
	public String MoveSupWrite(Model model) {
		
		return "mp_support_write";
	}
	
	

}
