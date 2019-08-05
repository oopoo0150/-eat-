package com.closet.great.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.dao.ProductDao;

@Service
public class ProductManagement {
	private ModelAndView mav;
	
	@Autowired
	private ProductDao pDao;
}
