package com.closet.test2.dao;

import java.util.List;

import com.closet.test2.bean.InfoBoard;
import com.closet.test2.bean.InfoReply;

public interface IBoardDao {

	boolean writeInsert(InfoBoard board);

	List<InfoBoard> getBoardList(int num);

	int getBoardCount();

	InfoBoard getContents(Integer inum);

	boolean update(InfoBoard board);

	boolean delete(Integer num);

	List<InfoReply> getReplyList(Integer inum);

	boolean replyInsert(InfoReply r);

	boolean replyDelete(Integer num);

	int getBoardnum(Integer no);

	boolean replyBoardDelete(Integer num);

}
