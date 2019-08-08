package com.closet.test2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.test2.bean.InfoBoard;
import com.closet.test2.dao.IBoardDao;
import com.closet.test2.util.Compare;
import com.closet.test2.util.Paging;

@Service
public class IBoardManagement {

	private ModelAndView mav;
	
	@Autowired
	private IBoardDao iDao;
	
	//@Autowired
	//HttpSession session;
	//
	// @Autowired
	// FileProcess fileProc;
	
	
	
	public ModelAndView getBoardList(Integer pageNum) {
		mav = new ModelAndView();
		String view = null;
		List<InfoBoard> iList = null;
		// pageNum이 null(로그인 직후)이면 첫 페이지를 보이도록
		int num = (pageNum == null) ? 1 : pageNum;
		
		iList = iDao.getBoardList(num);
		
		mav.addObject("iList", iList);
		mav.addObject("paging", getPaging(num));
		view = "info";
		mav.setViewName(view);
		
		return mav;
	}
	
	private Object getPaging(int num) {
		// 전체 글 수
		int maxNum = iDao.getBoardCount();
		// 페이지당 글 수
		int listCnt = 10;
		// 그룹당 페이지 수
		int pageCnt = 3;
		// 게시판이 여러 종류가 있다면
		String boardName = "info";
		Paging paging = new Paging(maxNum, num, listCnt, pageCnt, boardName); 
		return paging.makeHtmlpaging();
	}


	public ModelAndView writeInsert(InfoBoard board) {
		mav = new ModelAndView();

		String view = null;


		// 파일 파일 파이리

		// 아이디 가져오기
		String id = "tami";
		//String id = session.getAttribute("id").toString();
		board.setIn_sid(id);


		// DB에 글 저장
		if(iDao.writeInsert(board)) {

		//int inum = board.getIn_num();

		// 게시글 번호로 파일 저장
		// 파일 성공 
		
		
		view = "redirect:info";
		mav.addObject("check", 1);
		}
		else {
			// 실패
			view="infoAdd";
		}
		mav.setViewName(view);

		return mav;
	}

	public ModelAndView getContents(Integer inum) {
		
		mav = new ModelAndView();
		String view = null;
		
		// 아이디 가져오기
		String id = "tami";
		//String id = session.getAttribute("id").toString();
		
		InfoBoard iboard = iDao.getContents(inum);
		
		//mav.addObject("compare", Compare(id, iboard.getIn_sid()));
		String writer = iboard.getIn_sid();
		
		String boardName = "infoUpdate";
		int num = inum;
		Compare compare = new Compare(id, writer, boardName, num);
		
		mav.addObject("info", iboard);
		mav.addObject("compare", compare.makeHtmlcompare());
		
		view = "infoDetail";
		mav.setViewName(view);
		
		return mav;
	}

	public ModelAndView infoUpdate(Integer num) {
		mav = new ModelAndView();
		String view = null;
		
		InfoBoard iboard = iDao.getContents(num);
		
		
		//보내기
		mav.addObject("info", iboard);
		
		view = "infoUpdate";
		
		mav.setViewName(view);
		
		return mav;
	}

	public ModelAndView infoUpdateInsert(InfoBoard board) {
		
		mav = new ModelAndView();

		String view = null;

		// DB에 글 수정
		if(iDao.update(board)) {
 
		
		
		view = "info";
		mav.addObject("check", 1);
		//mav.addObject("inum", board.getIn_num());
		}
		else {
			// 실패
			view="info";
		}
		mav.setViewName(view);

		return mav;
	}

}








