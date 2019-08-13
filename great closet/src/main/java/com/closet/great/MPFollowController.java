package com.closet.great;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.service.MPFollowManagement;
import com.sun.org.apache.regexp.internal.recompile;

import sun.print.resources.serviceui;

@Controller
public class MPFollowController {
	
	ModelAndView mav;
	 
	@Autowired
	MPFollowManagement fom;
	
	@Autowired
	HttpSession session;
	
	//팔로잉 리스트 출력
	@RequestMapping(value = "/followingList")
	public ModelAndView followingList(String id) { 
		
		String cid = session.getAttribute("id").toString();
		
		System.out.println(session.getAttribute("id"));
			
		mav = fom.followingList(cid);
		
		return mav;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	}
	
	//팔로잉 리스트에서 언팔로우
	@RequestMapping(value = "/unfollow", method = RequestMethod.POST)
	public ModelAndView doUnfollow(String uid) {

		mav = fom.doUnfollow(uid);
		
		return mav;
		
	}
	
	//팔로잉 리스트 출력
	@RequestMapping(value = "/followerList")
	public ModelAndView followerList(String id) {
		
		String cid = session.getAttribute("id").toString();
		mav = fom.followerList(cid);	
		
		return mav;
	}
	
	
	
	
	//상대 페이지로 이동
	@RequestMapping(value = "/urpage")
	public ModelAndView goUrpage(String uid, String myId) {
	
		mav = fom.goUrpage(uid, myId);
		
		return mav;
	}
	
	//following count
	@RequestMapping(value = "/followingCnt")
	public ModelAndView followingCnt(String id) {
		
		mav = fom.followingCnt(id);
		
		return mav;
	}
	@RequestMapping(value = "/blockUser")
	
	public ModelAndView blockUser(String id, @RequestParam(value = "uid")String uid) {
		
		String cid = session.getAttribute("id").toString();
		
		mav = fom.blockUser(cid, uid);
		
		return mav;
	}

}
