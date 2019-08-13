package com.closet.great.dao;

import java.util.List;

import com.closet.great.bean.Product;
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

	

}
