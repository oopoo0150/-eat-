package com.closet.great.dao;

import java.util.List;
import java.util.Map;

import com.closet.great.bean.Clothes_Detail;

public interface ImgDao {

	List<Clothes_Detail> getImgList(int cl_num);

	boolean clothesimgInsert(Clothes_Detail clothes);

	Clothes_Detail getimgDetail(int num);

	boolean imgDelete(int cld_num);

	boolean clothesoriUpdate(Clothes_Detail cd);

	boolean clothessysUpdate(Clothes_Detail cd);

}
