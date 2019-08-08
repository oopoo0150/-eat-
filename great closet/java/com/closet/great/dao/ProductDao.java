package com.closet.great.dao;

import java.util.List;

import com.closet.great.bean.Product;

public interface ProductDao {

	boolean writeInsert(Product product);

	int getProductCount();

	List<Product> getProductList(int num);

	Product getDetail(Integer db_num);

	boolean productDelete(Integer db_num);
}
