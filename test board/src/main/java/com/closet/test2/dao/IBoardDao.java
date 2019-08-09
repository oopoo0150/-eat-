package com.closet.test2.dao;

import java.util.HashMap;
import java.util.List;

import com.closet.test2.bean.InfoBoard;
import com.closet.test2.bean.InfoReply;

public interface IBoardDao {

	boolean writeInsert(InfoBoard board);

	//List<InfoBoard> getBoardList(int num);
	List<InfoBoard> getBoardList(HashMap<String, String> map);

	int getBoardCount(HashMap<String, String> table);

	InfoBoard getContents(Integer inum);

	boolean update(InfoBoard board);

	boolean delete(Integer num);

	List<InfoReply> getReplyList(Integer inum);

	boolean replyInsert(InfoReply r);

	boolean replyDelete(Integer num);

	int getBoardnum(Integer no);

	boolean replyBoardDelete(Integer num);

}
