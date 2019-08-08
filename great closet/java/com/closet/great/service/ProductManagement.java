package com.closet.great.service;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Product;
import com.closet.great.dao.ProductDao;
import com.closet.great.util.Paging;

@Service
public class ProductManagement {
	private ModelAndView mav;

	@Autowired
	private ProductDao pDao;

	@Autowired
	HttpSession session;

	//상품 게시글 등록
	public ModelAndView setProductWrite(Product product) {
		mav = new ModelAndView();
		String view = null;
		String id ="이진"; 
		product.setDb_sid(id);

		pDao.writeInsert(product);

		view = "redirect:product_mainGo"; //이거 uri 값 넣어야됨!!

		mav.setViewName(view);

		return mav;
	}

	//상품 게시글 리스트
	public ModelAndView getProductList(Integer pageNum) {
		mav = new ModelAndView();

		String view = null;
		List<Product> productList = null;
		
		int num = (pageNum == null) ? 1 : pageNum;
		
		productList = pDao.getProductList(num);
		
		mav.addObject("productList", productList);
		mav.addObject("paging", getPaging(num));
		view = "product_main";
		mav.setViewName(view);

		return mav;
	}

	//페이징 처리
	private Object getPaging(int num) {
		int maxNum = pDao.getProductCount();
		int listCnt = 10; //나중에 계산해서 33개로 바꾸기
		int pageCnt = 2; //나중에 5개로 계산
		
		String boardName = "product_mainGo";
		Paging paging = new Paging(maxNum, num, listCnt, pageCnt, boardName);
		
		return paging.makeHtmlpaging();
	}

	//상품 게시글 상세보기
	public ModelAndView getDetail(Integer db_num) {
		mav = new ModelAndView();
		String view = null;

		Product product = pDao.getDetail(db_num);
		mav.addObject("product", product);

		view = "product_detail";
		mav.setViewName(view);

		return mav;
	}
	
	//상품 게시글 삭제
	public ModelAndView productDelete(Integer db_num) throws RuntimeException{
		mav = new ModelAndView();
		
		boolean p = pDao.productDelete(db_num);
		if(p == false) {
			mav.addObject("check", 2);
			throw new RuntimeException();
		}
		else {
			mav.addObject("check", 1);
		}
		mav.setViewName("redirect:product_mainGo");
		
		return mav;
	}

}
