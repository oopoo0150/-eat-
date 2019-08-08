package com.closet.great.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Support;
import com.closet.great.dao.MypageDao;
import com.closet.great.util.Paging;

@Service
public class MPSupportManagement {
 
	//mav생성
	private ModelAndView mav;
	
	//Dao객체 생
	@Autowired
	private MypageDao myDao;
	
	
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
	
	//관리자용
	public ModelAndView getAdminSupList(Integer pageNum, String url) {
		
	mav = new ModelAndView();
		
		String view = null;
		List<Support> spList = null;
		
		int num = (pageNum == null) ? 1 : pageNum;
		
		spList = myDao.getSupportList(num);
		
		mav.addObject("spList",spList);
		mav.addObject("paging",getPaging(num, url));
		
		view="mp_admin_support";
		mav.setViewName(view);
				
		return mav;	
	}

	//게시판 하단에 페이지 표시를 위한 처리용 메소드
	private String getPaging(int num, String url) {		
		//전체 글 수
		int maxNum = myDao.getSpBoardCount();
		//페이지당 글 수
		int listCnt = 10;
		//그룹당 페이지 수 
		int pageCnt = 5;
		//게시판이 여러종류가 있을 경우 대비
		
		
		String boardName = url;
		Paging paging = new Paging(maxNum, num, listCnt, pageCnt, boardName);
			
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
	@RequestMapping(value = "/spUpdate")
	public ModelAndView spBoardUpdate(Integer spnum) {
		
		mav = new ModelAndView();
		String view = null;
		
	
		if(myDao.spBoardUpdate(spnum)) {
			//성공		
			view ="redirect:adminSpList";
			mav.addObject("update",1);
		}else {
			
			view="mp_support_update";
			
		}			
		return mav;
	
	}

	
	

}
