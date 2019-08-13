package com.closet.great.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Support;
import com.closet.great.dao.MypageDao;
import com.closet.great.util.mpPaging;

@Service
public class MPSupportManagement {
 
	//mav생성
	private ModelAndView mav;
	
	//Dao객체 생
	@Autowired
	private MypageDao myDao;
	
	/*
	public ModelAndView getSupportList(Integer pageNum, String url) {
		
		mav = new ModelAndView();
		
		String view = null;
		List<Support> spList = null;
		
		int num = (pageNum == null) ? 1 : pageNum;
		spList = myDao.getSupportList(num);
		
		mav.addObject("spList",spList);
		mav.addObject("paging",getPaging(num, url));
		
		view="mp_support";
		mav.setViewName(view);
				
		return mav;
	}
//	*/
//	
//	//관리자용
//	public ModelAndView getAdminSupList(Integer pageNum, String url) {
//		
//	mav = new ModelAndView();
//		
//		String view = null;
//		List<Support> spList = null;
//		
//		int num = (pageNum == null) ? 1 : pageNum;
//		
//		spList = myDao.getSupportList(num);
//		
//		mav.addObject("spList",spList);
//		mav.addObject("paging",getPaging(num, url));
//		
//		view="mp_admin_support";
//		mav.setViewName(view);
//				
//		return mav;	
//	}

	//게시판 하단에 페이지 표시를 위한 처리용 메소드
	private String getPaging(int num, String table, String spcate) {
		
		HashMap<String, String> tbl = new HashMap<String, String>();
		tbl.put("table", table);
	
		//전체 글 수
		int maxNum = myDao.getSpBoardCount(tbl);
		//페이지당 글 수
		int listCnt = 10;
		//그룹당 페이지 수 
		int pageCnt = 5;
		//게시판이 여러종류가 있을 경우 대비	
		String boardName = "supportList" ;
		mpPaging paging = new mpPaging(maxNum, num, listCnt, pageCnt, boardName, spcate);
			
		return paging.makeHtmlpaging();
	}

	//게시물 작성
	public ModelAndView spBoardInsert(Support support) {
		
		mav = new ModelAndView();
		String view = null;
		String spid = "ADMIN";
		
		support.setSpsid(spid);
		 		
		//DB insert
		if(myDao.spBoardInsert(support)) {
			//성공
			view ="redirect:adminSpList";
			mav.addObject("write",1);
		}else {
			
			view="mp_support_write";
			
		}
		
		mav.setViewName(view);
		
		return mav;
	}

	public ModelAndView getSpContents(Integer spnum, String viewName) {
		
		mav = new ModelAndView();
	    String view = null;
		
		Support support = myDao.getSpContents(spnum);
		mav.addObject("support", support);
		
		view = viewName;
		mav.setViewName(view);		
		return mav;
	}

	public ModelAndView spBoardDel(Integer spnum) {
		
		mav = new ModelAndView();

		boolean spDel = myDao.spBoardDel(spnum);
		
		if(spDel == false) {
			mav.addObject("check", 2);
		}else {
			mav.addObject("check",1);
		}
		mav.setViewName("redirect:adminSpList");
		
		return mav;
	}


	//수정화면 이동 및 데이터 출력
	public ModelAndView moveSpUpdate(Integer spnum) {
		
		mav = new ModelAndView();
		String view = null;
		
		Support support = myDao.getSpContents(spnum);
		mav.addObject("support", support);
		
		view = "mp_support_update";
		mav.setViewName(view);		
		return mav;
		
	}
	
	//게시물 업데이트 하기
	
	public ModelAndView spBoardUpdate(Support support) {
		
		mav = new ModelAndView();
		String view = null;
		
	
		if(myDao.spBoardUpdate(support)) {
			//성공		
			view ="redirect:adminSpList";	
			mav.addObject("update",1);
			
		}else {
			
			view="mp_support_update";
			
		}	
		mav.setViewName(view);
		return mav;
	
	}

public ModelAndView sboxSelList(String spcate, Integer pageNum, String id) {
		
	mav = new ModelAndView();
		
	String view = null;	
	List<Support> spList = null;
	int num = (pageNum == null) ? 1 : pageNum;
	String table = null;
	
	if(spcate==null) {
		table="SPLIST_ALL";
		spcate = "전체";
	}else {	
	if(spcate.equals("전체")) {
		table="SPLIST_ALL";
	}else if(spcate.equals("공지사항")) {
		table="SPLIST_NO";
	}else {
		table="SPLIST_CON";
	}
	}
		
	Map<String, String> map = new HashMap<String, String>(); // MAP을 이용해 담기		 
	map.put("table", table);
	map.put("num", String.valueOf(num));
		
	spList = myDao.sboxSelList(map);
	view = "mp_support";
			
	mav.addObject("spList",spList);	
	mav.addObject("mppaging",getPaging(num,table,spcate));
	mav.addObject("spcate",spcate);
	mav.addObject("id", id);
	
	mav.setViewName(view);	
		
	return mav;
	}


	

}
