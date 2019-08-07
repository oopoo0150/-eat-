package com.closet.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.test2.bean.InfoBoard;
import com.closet.test2.dao.IBoardDao;

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


	
	public ModelAndView writeInsert(InfoBoard board) {
		mav = new ModelAndView();

		String view = null;


		// 파일 파일 파이리

		// 아이디 가져오기
		String id = "tami";
		//String id = session.getAttribute("id").toString();
		board.setIn_sid(id);


		// DB에 글 저장
		iDao.writeInsert(board);

		//int inum = board.getIn_num();

		// 게시글 번호로 파일 저장
		// 파일 성공 
		view = "info";
		mav.setViewName(view);
		mav.addObject("check", 1);

		return mav;
	}
	

	//@Autowired
	//private IBoardDao iDao;

	//@Autowired
	//HttpSession session;

	// @Autowired
	// FileProcess fileProc;


	/*
	public ModelAndView writeInsert(MultipartHttpServletRequest multi) {

		mav = new ModelAndView();

		String view = null;

		String cate = multi.getParameter("icate");
		String title = multi.getParameter("ititle");
		String contents = multi.getParameter("icontents");

		// 파일 파일 파이리

		// 아이디 가져오기
		String id = "tami";
		//String id = session.getAttribute("id").toString();

		InfoBoard board = new InfoBoard();

		board.setIn_cate(cate);
		board.setIn_title(title);
		board.setIn_content(contents);
		board.setIn_sid(id);

		// DB에 글 저장
		boolean i = iDao.writeInsert(board);

		int inum = board.getIn_num();

		// 게시글 번호로 파일 저장
		// 파일 성공 
		view = "redirect:info";
		mav.setViewName(view);

		return mav;
	}
	 */
}
