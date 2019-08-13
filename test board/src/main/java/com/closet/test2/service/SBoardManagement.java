package com.closet.test2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.test2.bean.InfoBoard;
import com.closet.test2.bean.InfoReply;
import com.closet.test2.bean.ShareBoard;
import com.closet.test2.bean.ShareReply;
import com.closet.test2.dao.SBoardDao;
import com.closet.test2.util.Compare;
import com.closet.test2.util.FileProcess;
import com.closet.test2.util.Paging;
import com.closet.test2.util.PagingShare;
import com.closet.test2.util.replyCompare;


@Service
public class SBoardManagement {
	
	private ModelAndView mav;

	@Autowired
	private SBoardDao sDao;
	
	@Autowired
	FileProcess fileProc;

	public ModelAndView swriteInsert(MultipartHttpServletRequest multi) {
		mav = new ModelAndView();
		String view = null;
		String title = multi.getParameter("sb_title");
		String contents = multi.getParameter("sb_content");
		//String lengtn = multi.getParameter("length");
		// String id = multi.getParameter("bid");
		
		//String id = session.getAttribute("id").toString();
		String id = "이진";
		
		ShareBoard share = new ShareBoard();
		share.setSb_title(title);
		share.setSb_content(contents);
		share.setSb_sid(id);		
		//DB에 글 내용 저장 후 게시글 번호를 얻어와서
		
		Map<String, String> map = new HashMap<String, String>();
		map = fileProc.upFile(multi);
		share.setSb_oriname(map.get("oriFileName"));
		share.setSb_sysname(map.get("sysFileName"));
		
		boolean b = sDao.writeInsert(share);
		if(b) {
			view = "redirect:share";
		}else {
			view = "sWrite";
		}
		mav.setViewName(view);
		
		return mav;
	}

	public ModelAndView getBoardList(Integer pageNum) {
		mav = new ModelAndView();
		String view = null;
		List<ShareBoard> sList = null;
		// pageNum이 null(로그인 직후)이면 첫페이지를 보이도록
		int num = (pageNum == null) ? 1 : pageNum;
		
		sList = sDao.getBoardList(num);
		
		mav.addObject("sList", sList);
		mav.addObject("paging", getPaging(num));
		view = "share";
		mav.setViewName(view);
		
		return mav;
	}
	
	private Object getPaging(int num) {
		// 전체 글 수
		HashMap<String, String> tbl = new HashMap<String, String>();
		
		int maxNum = sDao.getBoardCount(num);
		// 페이지당 글 수
		int listCnt = 10;
		// 그룹당 페이지 수
		int pageCnt = 5;
		// 게시판이 여러 종류가 있다면
		String boardName = "share";
		PagingShare paging = new PagingShare(maxNum, num, listCnt, pageCnt, boardName); 
		
		return paging.makeHtmlpaging();
	}

	public ModelAndView getContents(Integer num) {

		mav = new ModelAndView(); 
		String view = null;
		
		//Board board = bDao.getContents(bnum);
		ShareBoard share = sDao.getContents(num);
		
		String id = "이진";
		//share.setBid(session.getAttribute("id").toString());
		share.setSb_sid(id);
		
		String writer = share.getSb_sid();

		String boardName = "shareUpdate";
		String boardDelName = "shareDelete";
		//id(현재 아이디), writer(게시글 글쓴이), boardName(수정 uri), boardDelName(삭제 uri), inum(게시글)
		Compare compare = new Compare(id, writer, boardName, boardDelName, num);
		String com = compare.makeHtmlcompare();

		
		// 댓글 처리
		List<ShareReply> rList = sDao.getReplyList(num);
		mav.addObject("rList", rList);
		
		mav.addObject("share", share);
		mav.addObject("compare", com);
		view = "shareDetail";
		mav.setViewName(view);
		
		return mav;
	}

	public ModelAndView shareDelete(Integer num) {
		mav = new ModelAndView();

		String view = null;

		// DB에 글 수정
		//if(sDao.replyBoardDelete(num)) {
			if(sDao.delete(num)) {



				view = "redirect:share";
				mav.addObject("check", 3);
			}
			else {
				// 실패
				view="share";
				mav.addObject("check", 4);
			}
		//}
		mav.setViewName(view);

		return mav;
	}
	
	/*
	public ModelAndView shareUpdate(MultipartHttpServletRequest multi) {
		mav = new ModelAndView();
		String view = null;

		int num = Integer.parseInt(multi.getParameter("sb_num"));
		ShareBoard sboard = sDao.getContents(num);


		//보내기
		mav.addObject("share", sboard);

		view = "shareUpdate";

		mav.setViewName(view);

		return mav;
	}
	*/

	
	public ModelAndView shareUpdate(Integer num) {
		mav = new ModelAndView();
		String view = null;

		ShareBoard sboard = sDao.getContents(num);


		//보내기
		mav.addObject("share", sboard);

		view = "shareUpdate";

		mav.setViewName(view);

		return mav;
	}

	public ModelAndView shareUpdateInsert(MultipartHttpServletRequest multi) {
		mav = new ModelAndView();
		String view = null;
		String title = multi.getParameter("sb_title");
		String contents = multi.getParameter("sb_content");
		String number = multi.getParameter("sb_num");
		int num = Integer.parseInt(number);
		//int num = Integer.parseInt(multi.getParameter("sb_num"));
		// String id = multi.getParameter("bid");
		
		//String id = session.getAttribute("id").toString();
		String id = "이진";
		
		ShareBoard share = new ShareBoard();
		share.setSb_title(title);
		share.setSb_content(contents);
		share.setSb_num(num);
		share.setSb_sid(id);		
		//DB에 글 내용 저장 후 게시글 번호를 얻어와서
		
		Map<String, String> map = new HashMap<String, String>();
		map = fileProc.upFile(multi);
		share.setSb_oriname(map.get("oriFileName"));
		share.setSb_sysname(map.get("sysFileName"));
		mav.addObject("num", share.getSb_num());
		
		boolean b = sDao.updateInsert(share);
		if(b) {
			view = "redirect:shareDetail";
		}else {
			view = "redirect:shareDetail";
		}
		mav.setViewName(view);
		
		return mav;
	}

	public Map<String, List<ShareReply>> replyInsert(ShareReply share) {
		Map<String, List<ShareReply>> jMap = null;
		//r.setR_id(session.getAttribute("id").toString());

				String id = "이진";
				share.setSbr_sid(id);
				Integer inum = share.getSbr_sbnum();
				int num = inum;// 게시글 번호

				if(sDao.replyInsert(share)) {
					List<ShareReply> rList = sDao.getReplyList(num);

					// 댓글출력용 수정 삭제
					//id(현재 아이디), writer(댓글쓴이), boardName(수정 uri), boardDelName(삭제 uri), num(게시글 번호), num(게시글 번호), rnum(댓글 번호)
					for(int i=0;i<rList.size();i++) {
						String writer = rList.get(i).getSbr_sid();
						String boardName = ""; 
						String boardDelName = "shareReplyDelete";

						int rnum = rList.get(i).getSbr_num();
						replyCompare rcompare = new replyCompare(id, writer, boardName, boardDelName, num, rnum, null);
						String rc = rcompare.makeHtmlcompare();
						rList.get(i).setCompare(rc);
					}

					mav.addObject("rList", rList);

					jMap = new HashMap<String, List<ShareReply>>();
					jMap.put("rList", rList);
				}
				else {
					jMap = null;
				}
				return jMap;
	}

	public void ClickBoard(Integer num) {
		mav = new ModelAndView();

		sDao.ClickBoard(num);
	}
	

}
