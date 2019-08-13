package com.closet.great.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Follow;
import com.closet.great.dao.MypageDao;

@Service
public class MPFollowManagement {
	
	
	private ModelAndView mav;
	
	@Autowired
	private MypageDao myDao;
	
	//Session 생성
	HttpSession session;
	
	//bean생성
	Follow follow;
	
	
	public ModelAndView followingList(String id) {
				
		mav = new ModelAndView();
		String view = null;
		List<Follow> fList = null;	
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		

		fList = myDao.getFollowingList(map);
		
		mav.addObject("fList", fList);
		
		view ="mp_following";
		
		mav.setViewName(view);
			
		return mav;		 
		
	}

	//팔로우 삭제하기
	public ModelAndView doUnfollow(String uid) {
		
		mav = new ModelAndView();
		String view = null;
		
		if(myDao.doUnfollow(uid)) {
			view = "redirect:followingList";
			mav.addObject("check", 1);
		}
		else {
			//실패
			view ="mp_following";
		}
		mav.setViewName(view);
				
		return mav;
		
	}

	public ModelAndView goUrpage(String uid, String myId) {
		
		mav = new ModelAndView();		
		mav.addObject("uid",uid);
		mav.addObject("myId",myId);
		mav.setViewName("urpage");
			
		return mav;
	}

	public ModelAndView followingCnt(String id) {
		
		mav = new ModelAndView();
		
		int fingCnt = myDao.followingCnt(id);
		
		if(fingCnt == 0) {
			
			fingCnt = 0;
		}
		
		mav.addObject("fingCnt", fingCnt);
		
		return mav;
	}

	public ModelAndView blockUser(String cid, String uid) {			
		mav = new ModelAndView();
		
		String ccid = cid;
		String uuid = uid;
				
		return mav;
	}

	public ModelAndView followerList(String id) {
		
		mav = new ModelAndView();	
		String view = null;
		List<Follow> ferList = null;	
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		

		ferList = myDao.getFollowerList(map);
		
		mav.addObject("ferList", ferList);
		
		view ="mp_follower";
		
		mav.setViewName(view);
			
		return mav;		 
		
	}


}
