package com.vb.service;

import java.util.List;

import com.vb.dto.ProductDto;
import com.vb.entity.Product;


public interface ProductService {
	
	void save(ProductDto p);
	List<Product>list();
	Product getByCode(int code);
	void delete(int code);
	List<Product>listByCategory(String category);
	List<Product>listByPriceBetween(double min,double max);
	List<Product>listByAsc();
}
