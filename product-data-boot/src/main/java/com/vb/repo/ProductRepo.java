package com.vb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vb.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
//	List<Product>findByPriceBetween(double min,double max);
//	List<Product>findByCategory(String category);
//	List<Product>findByPriceAsc();
}
