package com.closet.great;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MPMainController {
	//Main Mypage에서 세부 패이지로 이동하기 위한 Controller
	
	ModelAndView mav;
	
	//페이지 구현을 위한 임시 페이지 넘김
	@RequestMapping(value = "/mypage")
	public String mypage(Model model) {
			
		return "mypage";
	}
	
	//관리자 페이지 구현을 위한 임시 페이지 넘김
	 //관리자
		@RequestMapping(value = "/adminpage")
		public String MoveAdminPage(Model model) {
			
			return "admin_mypage";
		}
		
		//관리자 이미지 클릭 시 관리자 리스트로 페이지 전환 
		@RequestMapping(value = "/adminSup")
		public String mAdminSupPage(Model model) {
			
			return "mp_admin_support";
		}

	

	@RequestMapping(value = "/mEditProfile")
	public String moveEditProfile(Model modle) {
		
		return "mp_profile_edit";
	}
	
	@RequestMapping(value = "/mSetting")
	public String moveSetting(Model modle) {
		
		return "mp_setting";
	}
	
	
	@RequestMapping(value = "/mSelction")
	public String moveSelection(Model modle) {
		
		return "mp_selection";
	}
	
	@RequestMapping(value = "/mFollowing")
	public String moveFollowing(Model modle) {
		
		return "mp_following";
	}
	
	@RequestMapping(value = "/mFollower")
	public String moveFollower(Model modle) {
		
		return "mp_follower";
	}
	
	
	@RequestMapping(value = "/mCal")
	public String moveCal(Model modle) {
		
		return "mp_cal";
	}
	
	@RequestMapping(value = "/mBoard")
	public String moveBoard(Model modle) {
		
		return "mp_board";
	}
	
	@RequestMapping(value = "/mLookbook")
	public String moveLookBook(Model modle) {
		
		return "mp_lookbook";
	}
	
	@RequestMapping(value = "/mLog")
	public String moveLog(Model modle) {
		
		return "mp_log";
	}
	
	@RequestMapping(value = "/mStatistics")
	public String moveStatistics(Model modle) {
		
		return "mp_statistics";
	}
	
	@RequestMapping(value = "/mSale")
	public String moveSale(Model modle) {
		
		return "mp_sale";
	}
	

	

	
	

}
