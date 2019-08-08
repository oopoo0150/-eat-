package com.closet.great.dao;

import java.util.List;
import java.util.Map;

import com.closet.great.bean.Follow;
import com.closet.great.bean.Support;

public interface MypageDao {

	List<Support> getSupportList(int num);

	int getSpBoardCount();

	boolean spBoardInsert(Support support);

	Support getSpContents(Integer spnum);

	boolean spBoardDel(Integer spnum);

	boolean spBoardUpdate(Integer spnum);

	boolean profileInsert(Map<String, String> fMap);

	boolean profileUpdate(Map<String, String> fMap);

	List<Follow> getFollowingList(String id);

	int getFolCnt();

	
}
