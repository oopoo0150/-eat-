package com.closet.test2.dao;

import java.util.List;

import com.closet.test2.bean.InfoBoard;

public interface IBoardDao {

	boolean writeInsert(InfoBoard board);

	List<InfoBoard> getBoardList(int num);

	int getBoardCount();

	InfoBoard getContents(Integer inum);

	boolean update(InfoBoard board);

}
