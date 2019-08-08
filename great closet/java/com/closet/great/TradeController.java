package com.closet.great;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Product;
import com.closet.great.service.ProductManagement;

@Controller
public class TradeController {
	ModelAndView mav;
	
	@Autowired
	ProductManagement pm;
	
	//중고거래 메인 이동 및 게시글 목록
	@RequestMapping(value = "/product_mainGo")
	public ModelAndView productList(Integer pageNum) {
		mav = pm.getProductList(pageNum);
		return mav;
	}

	//중고거래 상세 화면 이동
	@RequestMapping(value = "/product_detailGo")
	public String product_detail(Model model) {
		return "product_detail";
	}

	//중고거래 상품 등록하기 화면 이동
	@RequestMapping(value = "/product_registGo")
	public String product_registGo(Model model) {
		return "product_regist";
	}
	
	//중고거래 상품 등록
	@RequestMapping(value = "/product_regist", method = RequestMethod.POST)
	public ModelAndView product_regist(Product product) {
		mav = pm.setProductWrite(product);
		
		return mav;
	}
	
	//중고거래 상세보기
	@RequestMapping(value = "/product_detailGo", method = RequestMethod.GET)
	public ModelAndView pDetail(Integer db_num) {
		
		mav = pm.getDetail(db_num);
		
		return mav;
	}
	
	//중고거래 게시글 삭제(작성자, 관리자)
	@RequestMapping(value = "/productDelete")
	public ModelAndView productDelete(Integer db_num) {
		mav = pm.productDelete(db_num);
		
		return mav;
	}
	
}
