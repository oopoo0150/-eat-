package com.closet.great.dao;

import java.util.HashMap;
import java.util.List;

import com.closet.great.bean.InfoBoard;
import com.closet.great.bean.InfoReply;

public interface IBoardDao {

	boolean writeInsert(InfoBoard board);

	//List<InfoBoard> getBoardList(int num);
	List<InfoBoard> getBoardList(HashMap<String, String> map);

	int getBoardCount(HashMap<String, String> table);

	InfoBoard getContents(Integer num);

	boolean update(InfoBoard board);

	boolean delete(Integer num);

	List<InfoReply> getReplyList(Integer num);

	boolean replyInsert(InfoReply r);

	boolean replyDelete(Integer num);

	int getBoardnum(Integer no);

	boolean replyBoardDelete(Integer num);

	boolean replyUpdate(InfoReply info);

	void ClickBoard(Integer num);


}
