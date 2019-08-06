package com.closet.great;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MPSupportController {
	
	//관리자 작성
	@RequestMapping(value = "/spWrite")
	public String MoveSupWrite(Model model) {
		
		return "mp_support_write";
	}

}
