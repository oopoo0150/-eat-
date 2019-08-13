package com.closet.great.service;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Product;
import com.closet.great.bean.ProductImg;
import com.closet.great.bean.ProductReply;
import com.closet.great.dao.ProductDao;
import com.closet.great.util.FileProcess;
import com.closet.great.util.Paging;

@Service
public class ProductManagement {
	private ModelAndView mav;

	@Autowired
	private ProductDao pDao;

	@Autowired
	HttpSession session;
	
	@Autowired
	FileProcess fileProc;

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
		int pageCnt = 5; //나중에 5개로 계산

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
		
		//파일 리스트
		List<ProductImg> pfList = pDao.getPfList(db_num);
		mav.addObject("pfList", pfList);
		
		//댓글 리스트
		List<ProductReply> prList = pDao.getPReplyList(db_num);
		mav.addObject("prList", prList);

		view = "product_detail";
		mav.setViewName(view);

		return mav;
	}

	//상품 게시글 삭제
	public ModelAndView productDelete(Integer db_num) throws RuntimeException{
		mav = new ModelAndView();

		//댓글 먼저 삭제
		boolean prd = pDao.productR_deleteA(db_num);
		//파일삭제
		boolean pfd = pDao.productF_deleteA(db_num);
		
		//게시글 삭제
		boolean pd = pDao.productDelete(db_num);

		if(pd == false) {
			mav.addObject("check", 2);
			throw new RuntimeException();
		}
		else {
			mav.addObject("check", 1);
		}
		mav.setViewName("redirect:product_mainGo");

		return mav;
	}

	//수정 화면 이동
	public ModelAndView productUpdateGo(Integer db_num) {
		mav = new ModelAndView();

		String view = null;

		Product product = pDao.getDetail(db_num);

		mav.addObject("product", product);

		view = "product_update";
		mav.setViewName(view);

		return mav;
	}

	//수정
	public ModelAndView setProductUpdate(Product product) {
		mav = new ModelAndView();
		
		String view = null;
		
		String id ="hyeon"; 
		product.setDb_sid(id);
		
		if(pDao.writeUpdate(product)) {
			view = "redirect:product_detailGo?db_num="+product.getDb_num();
			mav.addObject("check", 2);
		}
		else {
			view = "product_main";
		}
		mav.setViewName(view);
		
		return mav;
	}

	//상품 게시글 상세보기 댓글 추가
	public Map<String, List<ProductReply>> productR_insert(ProductReply pr){
		Map<String, List<ProductReply>> jMap = null;

		//session대신 임시 아이디
		String id = "hyeon";
		pr.setDbr_sid(id);

		Integer pnum = pr.getDbr_dbnum();
		int num = pnum;

		if(pDao.productR_insert(pr)) {
			List<ProductReply> prList = pDao.getPReplyList(pnum);

			mav.addObject("prList", prList);

			jMap = new HashMap<String, List<ProductReply>>();
			jMap.put("prList", prList);
		}
		else {
			jMap = null;
		}

		return jMap;
	}

	//댓글 삭제
	public Map<String, List<ProductReply>> productR_delete(Integer no) {
		Map<String, List<ProductReply>> jMap = null;
		
		int Bnum = pDao.getBnum(no);
		
		if(pDao.productR_delete(no)) {
			List<ProductReply> prList = pDao.getPReplyList(Bnum);
			
			jMap = new HashMap<String, List<ProductReply>>();
			jMap.put("prList", prList);
			
		}
		else {
			mav.addObject("result", 2);
			throw new RuntimeException();
			
		}
		return jMap;
	}

	//게시글 조회수 보여주기
	public ModelAndView Pviews(Integer db_num) {
		mav = new ModelAndView();
		pDao.Pviews(db_num);
		mav.setViewName("redirect:product_mainGo");
		
		return mav;
	}
	
	//게시글 조회수 올리기
	public ModelAndView pviewsUp(Integer pageNum) throws Exception {
		mav = new ModelAndView();
		String view = null;	
		
		mav.setViewName(view);
		
		return mav;
	}

	
	//게시글 작성(파일)
	public ModelAndView setWriteProduct(MultipartHttpServletRequest multi) {
		mav = new ModelAndView();
		String view = null;
		String title = multi.getParameter("db_title");
		int price = Integer.parseInt(multi.getParameter("db_price"));
		String content = multi.getParameter("db_content");
		
		//파일 유무
		String check = multi.getParameter("fileCheck");
		String id = "hyeon"; //임시아이디
		
		Product product = new Product();
		product.setDb_title(title);
		product.setDb_price(price);
		product.setDb_content(content);
		product.setDb_sid(id);
		
		boolean p = pDao.writeInsert(product);
		int db_num = product.getDb_num();
		
		//게시글 번호로 파일 저장
		boolean pf = false;
		
		if(check.equals("1")) {
			pf = fileProc.upFile(multi, db_num);
			view = "redirect:product_mainGo";
		}
		else {
			
			view = "product_regist";
		}
		mav.setViewName(view);
		
		return mav;
	}
	
	//파일 다운로드
	public void downLoadP(Map<String, Object> params) throws Exception{
		String dbi_oriName = (String)params.get("dbi_oriName");
		String dbi_sysName = (String)params.get("dbi_sysName");
		String root = (String)params.get("root");
		String path = root + "/resources/files/" + dbi_sysName;
		
		HttpServletResponse resp = (HttpServletResponse)params.get("resp");
		
		fileProc.downFileP(path, dbi_oriName, resp);
	}
		
	
}
