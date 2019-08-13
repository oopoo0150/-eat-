package com.closet.great.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.closet.great.bean.Clothes;

public interface ClothesDao {

	List<Clothes> getClothesList(HashMap<String, String> map);

	boolean clothesInsert(Clothes clothes);
	
	boolean clothesDelete(String string);

	boolean clothesUpdate(Clothes clothes);

}
