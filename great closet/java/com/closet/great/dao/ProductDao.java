package com.closet.great.dao;

import java.util.List;
import java.util.Map;

import com.closet.great.bean.Product;
import com.closet.great.bean.ProductImg;
import com.closet.great.bean.ProductReply;

public interface ProductDao {

	boolean writeInsert(Product product);

	int getProductCount();

	List<Product> getProductList(int num);

	Product getDetail(Integer db_num);

	boolean productDelete(Integer db_num);

	boolean writeUpdate(Product product);

	boolean productR_insert(ProductReply pr);

	List<ProductReply> getPReplyList(Integer pnum);

	boolean productR_delete(Integer no);

	int getBnum(Integer no);
	
	//게시글 삭제 시 댓글 전체 삭제
	boolean productR_deleteA(Integer db_num);

	void Pviews(Integer bnum);

	boolean fileInsert(Map<String, String> pfMap);

	boolean productF_deleteA(Integer db_num);

	List<ProductImg> getPfList(Integer db_num);


}
