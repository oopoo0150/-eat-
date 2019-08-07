package com.closet.great;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LookbookController {

	//룩북 메인 화면 이동
	@RequestMapping(value = "/lookbook_main")
	public String lookbook_main(Model model) {
		return "lookbook_main";
	}

	//룩북 메인에서 상세보기 화면 이동
	@RequestMapping(value = "/lookbook_detail")
	public String lookbook_detail(Model model) {
		return "lookbook_detail";
	}
}
