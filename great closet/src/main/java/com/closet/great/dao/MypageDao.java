package com.closet.great.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Follow;
import com.closet.great.bean.Product;
import com.closet.great.bean.Support;

public interface MypageDao {

	List<Support> getSupportList(int num);

	int getSpBoardCount(HashMap<String, String> tbl);

	boolean spBoardInsert(Support support);

	Support getSpContents(Integer spnum);

	boolean spBoardDel(Integer spnum);

	boolean spBoardUpdate(Support support);

	boolean profileInsert(Map<String, String> fMap);

	boolean profileUpdate(Map<String, String> fMap);

	List<Follow> getFollowingList(HashMap<String, String> map);

	int getFolCnt();

	List<Support> sboxSelList(Map<String, String> map);

	boolean doUnfollow(String uid);

	int followingCnt(String id);

	ModelAndView doBlock(String cid, String uid);

	List<Follow> getFollowerList(HashMap<String, String> map);

	List<Product> getSaleList(Map<String, String> map);

	List<Product> getSaleList(String table, String id, int num);

	int getSpeUserCount(HashMap<String, String> map);

	boolean saleListDel(String string);

	
}
