package com.closet.great.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Product;
import com.closet.great.dao.MypageDao;
import com.closet.great.util.mpPaging;


@Service
public class MPSaleManagement {
	
	ModelAndView mav;
	
	@Autowired
	MypageDao myDao;
	
	HttpSession session;

	public ModelAndView SaleList(String id, Integer pageNum, String cate) {
		
		mav = new ModelAndView();
		String view = null;
		int num = (pageNum == null) ? 1 : pageNum;
		List<Product> mpList = null;	
		String table = null;
		
		if(cate==null) {
			table = "DLIST_1";
			cate = "전체";
		}else {
			if(cate.equals("전체")) {
				table = "DLIST_1";
			}else if(cate.equals("거래가능")) {
				table = "DLIST_OK";
			}else if(cate.equals("거래중")) {
				table = "DLIST_ING";
			}else if(cate.equals("거래완료")) {
				table = "DLIST_END";
			}else if(cate.equals("기간만료")) {
				table = "DLIST_OVER";
			}
		}
		
		//HashMap생성
		Map<String, String> map = new HashMap<String, String>();
		map.put("table", table);
		map.put("num", String.valueOf(num));
		map.put("id",id);
		
		mpList = myDao.getSaleList(map);
		view = "mp_sale";
			
		mav.addObject("mpList",mpList);
		mav.addObject("mppaging",getPaging(num,table,cate,id));
		mav.addObject("cate",cate);
		mav.addObject("id",id);
		mav.setViewName(view);
					
		return mav;
	}

	//게시판 하단에 페이지 표시를 위한 처리 메소드
	private Object getPaging(int num, String table, String cate, String id) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("table", table);
		map.put("id", id);
		
		//전체 글 수
 		int maxNum = myDao.getSpeUserCount(map);
		//페이지당 글 수
		int listCnt = 10;
		//그룹당 페이지 수 
		int pageCnt = 5;
		//게시판이 여러종류가 있을 경우 대비	
		String boardName = "SaleList" ;
		mpPaging paging = new mpPaging(maxNum, num, listCnt, pageCnt, boardName, cate);
			
		return paging.makeHtmlpaging();

	}

	public boolean saleListDel(List<String> list) {

		boolean result = false;		
		for(int i = 0; i < list.size(); i++) {
			result = myDao.saleListDel(list.get(i));
		}
		
		return result;
	}
	
	
	

}
