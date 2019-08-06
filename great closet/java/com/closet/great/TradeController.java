package com.closet.great;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.service.ProductManagement;

@Controller
public class TradeController {

	//중고거래 메인 화면 이동
	@RequestMapping(value = "/product_main")
	public String product_main(Model model) {
		return "product_main";
	}

	//중고거래 상세 화면 이동
	@RequestMapping(value = "/product_detail")
	public String product_detail(Model model) {
		return "product_detail";
	}

	//중고거래 상품 등록하기 화면 이동
	@RequestMapping(value = "/product_regist")
	public String product_regist(Model model) {
		return "product_regist";
	}

}
