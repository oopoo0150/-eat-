package com.closet.great;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Product;
import com.closet.great.bean.ProductImg;
import com.closet.great.bean.ProductReply;
import com.closet.great.service.ProductManagement;

@Controller
public class TradeController {
	ModelAndView mav;
	
	@Autowired
	ProductManagement pm;
	
	//중고거래 메인 이동 및 게시글 목록 출력
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
	
	//중고거래 상세보기 이동 및 출력
	@RequestMapping(value = "/product_detailGo", method = RequestMethod.GET)
	public ModelAndView pDetail(Integer db_num) {
		
		//조회수 증가
		pm.Pviews(db_num);
		
		mav = pm.getDetail(db_num);		
		return mav;
	}
	
	//중고거래 게시글 삭제(작성자, 관리자)
	@RequestMapping(value = "/productDelete")
	public ModelAndView productDelete(Integer db_num) {
		mav = pm.productDelete(db_num);		
		return mav;
	}
	
	//중고거래 게시글 수정화면으로 이동 및 출력(작성자, 관리자)
	@RequestMapping(value = "/product_UpdateGo", method = RequestMethod.GET)
	public ModelAndView productUpdateGo(Integer db_num){		
		mav = pm.productUpdateGo(db_num);		
		return mav;
	}
	
	//중고거래 게시글 수정(작성자, 관리자)
	@RequestMapping(value = "/product_update", method = RequestMethod.POST)
	public ModelAndView productUpdate(Product product) {
		mav = pm.setProductUpdate(product);		
		return mav;
	}
	
	//중고거래 게시글에 댓글 달기
	@RequestMapping(value = "/pReplyInsert", produces = "application/json; charset=UTF-8")
	public @ResponseBody Map<String, List<ProductReply>> productR_insert(ProductReply pr) {

		Map<String, List<ProductReply>> prMap = pm.productR_insert(pr);
		return prMap;
	}
	
	//중고거래 게시글 댓글 삭제
	@RequestMapping(value = "/productR_delete")
	public @ResponseBody Map<String, List<ProductReply>> productR_delete(@RequestParam(value = "num") Integer no){
		Map<String, List<ProductReply>> prMap = pm.productR_delete(no);
		return prMap;
	}
	
	//게시글 조회수 증가
	@RequestMapping(value = "/pviewsUp")
	public String pviewsUp(HttpServletRequest request, Model model) {
		return "product_mainGo";
	}
	
	//게시글 저장(파일)
	@RequestMapping(value = "writeInsertProduct", method = RequestMethod.POST)
	public ModelAndView writeInsertProduct(MultipartHttpServletRequest multi) {
		mav = pm.setWriteProduct(multi);
		
		return mav;
	}
	
	//파일 다운로드
	@RequestMapping(value = "/downloadP")
	public void downloadP(@RequestParam Map<String, Object> params,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//파일 경로 설정을 위한 루트 경로 구하기
		params.put("root", req.getSession().getServletContext().getRealPath("/"));
		params.put("resp", resp);
		/* pm.downLoadP(params); */
	}

}
