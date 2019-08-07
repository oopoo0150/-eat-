package com.closet.great;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContestController {

	//콘테스트 메인 화면 이동
	@RequestMapping(value = "/contest_main")
	public String contest_main(Model model) {
		return "contest_main";
	}

	//콘테스트 메인에서 참가 안내 화면 이동
	@RequestMapping(value = "/contest_info")
	public String contest_info(Model model) {
		return "contest_info";
	}

	//콘테스트 메인에서 참가 하기 화면 이동
	@RequestMapping(value = "/contest_regist")
	public String contest_regist(Model model) {
		return "contest_regist";
	}

	//콘테스트 안내화면 에서 참가 하기 화면 이동
	@RequestMapping(value = "/contestInfo_regist")
	public String contestInfo_regist(Model model) {
		return "contest_regist";
	}

	//콘테스트 메인에서 상세보기로 이동
	@RequestMapping(value = "/contest_detail")
	public String contest_detail(Model model) {
		return "contest_detail";
	}
}
