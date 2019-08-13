package com.closet.test2.dao;

import java.util.List;

import com.closet.test2.bean.InfoReply;
import com.closet.test2.bean.ShareBoard;
import com.closet.test2.bean.ShareReply;

public interface SBoardDao {

	boolean writeInsert(ShareBoard share);

	List<ShareBoard> getBoardList(int num);

	int getBoardCount(int num);

	ShareBoard getContents(Integer num);

	boolean delete(Integer num);

	boolean updateInsert(ShareBoard share);

	boolean replyInsert(ShareReply share);

	List<ShareReply> getReplyList(int num);

	void ClickBoard(Integer num);

}
