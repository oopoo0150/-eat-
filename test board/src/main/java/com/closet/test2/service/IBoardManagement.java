package com.closet.test2.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.test2.bean.InfoBoard;
import com.closet.test2.bean.InfoReply;
import com.closet.test2.dao.IBoardDao;
import com.closet.test2.util.Compare;
import com.closet.test2.util.Paging;
import com.closet.test2.util.replyCompare;

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



	public ModelAndView getBoardList(Integer pageNum, String in_cate) {
		mav = new ModelAndView();
		String view = null;
		List<InfoBoard> iList = null;

		//String cate = null;
		
		String in_cate1 = in_cate;

		// pageNum이 null(로그인 직후)이면 첫 페이지를 보이도록
		int num = (pageNum == null) ? 1 : pageNum;
		String in_num = ""+ num;
		String cate = (in_cate1 == null) ? "전체" : in_cate;
		
		String table = null;

		if(cate.equals("도움")) {
			table = "INFOHELP";
		}else if(cate.equals("정보")) {
			table = "INFOINFO";
		}else if(cate.equals("기타")) {
			table = "INFOETC";
		}else {
			table = "INFO";
		}


		HashMap<String, String> map = new HashMap<String, String>();
		map.put("table", table);
		map.put("num", in_num);		

		iList = iDao.getBoardList(map);


		mav.addObject("iList", iList);
		mav.addObject("paging", getPaging(num, table, cate));
		mav.addObject("in_cate", cate);
		view = "info";
		mav.setViewName(view);

		return mav;
	}

	private Object getPaging(int num, String table, String cate) {
		// 전체 글 수
		HashMap<String, String> tbl = new HashMap<String, String>();
		
		tbl.put("table", table);
				
		int maxNum = iDao.getBoardCount(tbl);
		// 페이지당 글 수
		int listCnt = 10;
		// 그룹당 페이지 수
		int pageCnt = 3;
		// 게시판이 여러 종류가 있다면
		String boardName = "info";
		Paging paging = new Paging(maxNum, num, listCnt, pageCnt, boardName, table, cate); 
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
		String boardDelName = "infoDelete";
		int num = inum;
		//id(현재 아이디), writer(게시글 글쓴이), boardName(수정 uri), boardDelName(삭제 uri), num(게시글)
		Compare compare = new Compare(id, writer, boardName, boardDelName, num);

		mav.addObject("info", iboard);
		mav.addObject("compare", compare.makeHtmlcompare());

		// 댓글
		List<InfoReply> rList = iDao.getReplyList(inum);

		// 댓글용 수정 삭제
		//id(현재 아이디), writer(댓글쓴이), boardName(수정 uri), boardDelName(삭제 uri), num(게시글 번호), num(게시글 번호), rnum(댓글 번호)
		for(int i=0;i<rList.size();i++) {
			writer = rList.get(i).getInr_sid();
			boardName = ""; 
			boardDelName = "replyDelete";
			int rnum = rList.get(i).getInr_num();
			replyCompare rcompare = new replyCompare(id, writer, boardName, boardDelName, num, rnum);
			//rList.set(i, compare);
			String rc = rcompare.makeHtmlcompare();
			rList.get(i).setCompare(rc);
		}

		mav.addObject("rList", rList);


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



			view = "redirect:infoDetail";
			mav.addObject("check", 2);
			mav.addObject("inum", board.getIn_num());
		}
		else {
			// 실패
			view="info";
		}
		mav.setViewName(view);

		return mav;
	}

	public ModelAndView infoDelete(Integer num) {
		mav = new ModelAndView();

		String view = null;

		// DB에 글 수정
		if(iDao.replyBoardDelete(num)) {
			if(iDao.delete(num)) {



				view = "redirect:info";
				mav.addObject("check", 3);
			}
			else {
				// 실패
				view="info";
				mav.addObject("check", 4);
			}
		}
		mav.setViewName(view);

		return mav;
	}

	public Map<String, List<InfoReply>> replyInsert(InfoReply r) {
		Map<String, List<InfoReply>> jMap = null;
		//r.setR_id(session.getAttribute("id").toString());

		String id = "tami";
		r.setInr_sid(id);
		Integer inum = r.getInr_innum();
		int num = inum;

		if(iDao.replyInsert(r)) {
			List<InfoReply> rList = iDao.getReplyList(inum);

			// 댓글출력용 수정 삭제
			//id(현재 아이디), writer(댓글쓴이), boardName(수정 uri), boardDelName(삭제 uri), num(게시글 번호), num(게시글 번호), rnum(댓글 번호)
			for(int i=0;i<rList.size();i++) {
				String writer = rList.get(i).getInr_sid();
				String boardName = ""; 
				String boardDelName = "replyDelete";

				int rnum = rList.get(i).getInr_num();
				replyCompare rcompare = new replyCompare(id, writer, boardName, boardDelName, num, rnum);
				String rc = rcompare.makeHtmlcompare();
				rList.get(i).setCompare(rc);
			}

			mav.addObject("rList", rList);

			jMap = new HashMap<String, List<InfoReply>>();
			jMap.put("rList", rList);
		}
		else {
			jMap = null;
		}
		return jMap;
	}

	public Map<String, List<InfoReply>> replyDelete(Integer no) {
		Map<String, List<InfoReply>> jMap = null;

		int boardNum = iDao.getBoardnum(no);

		if(iDao.replyDelete(no)) {

			List<InfoReply> rList = iDao.getReplyList(boardNum);

			// 댓글출력용 수정 삭제
			//id(현재 아이디), writer(댓글쓴이), boardName(수정 uri), boardDelName(삭제 uri), num(게시글 번호), num(게시글 번호), rnum(댓글 번호)
			for(int i=0;i<rList.size();i++) {
				String writer = rList.get(i).getInr_sid();
				String boardName = ""; 
				String boardDelName = "replyDelete";
				String id = "tami";
				int num = no;

				int rnum = rList.get(i).getInr_num();
				replyCompare rcompare = new replyCompare(id, writer, boardName, boardDelName, num, rnum);
				String rc = rcompare.makeHtmlcompare();
				rList.get(i).setCompare(rc);
			}

			jMap = new HashMap<String, List<InfoReply>>();
			jMap.put("rList", rList);
		}
		else {
			jMap = null;
		}
		return jMap;
	}

	//	public Map<String, List<InfoReply>> replyDelete(Integer r) {
	//		Map<String, List<InfoReply>> jMap = null;
	//		// r = 
	//		
	//		int boardNum = iDao.getBoardnum(r);
	//		
	//		if(iDao.replyDelete(r)) {
	//			List<InfoReply> rList = iDao.getReplyList(boardNum);
	//			jMap = new HashMap<String, List<InfoReply>>();
	//			jMap.put("rList", rList);
	//		}
	//		else {
	//			jMap = null;
	//		}
	//		return jMap;
	//	}


}








