package com.vb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.dto.ProductDto;
import com.vb.entity.Product;
import com.vb.repo.ProductRepo;

@Service
public class ProductServieImpl implements ProductService {
	@Autowired
	private ProductRepo repo;
	@Override
	public void save(ProductDto p) {
		Product prod=new Product();
		prod.setCode(p.getCode());
		prod.setName(p.getName());
		prod.setCategory(p.getCategory());
		prod.setPrice(p.getPrice());
		repo.save(prod);
		
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public Product getByCode(int code) {
		return repo.findById(code).get();
	}

	@Override
	public void delete(int code) {
		repo.deleteById(code);
	}

	@Override
	public List<Product> listByCategory(String category) {
		//return repo.findByCategory(category);
		return repo.findAll().stream().filter(p->p.getCategory().equalsIgnoreCase(category)).toList();
	}

	@Override
	public List<Product> listByPriceBetween(double min, double max) {
	//	return repo.findByPriceBetween(min, max);
		return repo.findAll().stream().filter(p->p.getPrice()>=min && p.getPrice()<=max).toList();
		
	}

	@Override
	public List<Product> listByAsc() {
		//return repo.findByPriceAsc();
		List<Product>p=repo.findAll();
		 p.sort((a,b)->a.getPrice()>b.getPrice()?1:-1);
		 return p;
	}

}
