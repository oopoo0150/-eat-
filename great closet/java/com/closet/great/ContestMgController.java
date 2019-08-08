package com.closet.great;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.service.ProductManagement;

@Controller
public class ContestMgController {
	//콘테스트 안내화면에서 안내 추가하기 화면 이동(관리자)
	@RequestMapping(value = "/contestMg_info_addGo")
	public String contestMg_info_add(Model model) {
		return "contest_info_add";
	}

	//콘테스트 안내화면에서 안내 수정하기 이동(관리자)
	@RequestMapping(value = "contestMg_info_updateGo")
	public String contestMg_info_update(Model model) {
		return "contest_info_update";
	}
}
