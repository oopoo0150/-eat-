package com.closet.great.dao;

import java.util.List;

import com.closet.great.bean.Support;

public interface MypageDao {

	List<Support> getSupportList(int num);

	int getSpBoardCount();

	boolean spBoardInsert(Support support);

	
}
