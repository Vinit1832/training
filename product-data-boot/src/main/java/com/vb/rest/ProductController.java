package com.vb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vb.dto.ProductDto;
import com.vb.entity.Product;
import com.vb.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	
	@PostMapping(value="/product/save",consumes="application/json")
	public ResponseEntity<String> save(@RequestBody @Valid ProductDto p) {
		pservice.save(p);
		return new ResponseEntity<String>("Product has been saved", HttpStatus.OK);
	}
	
	@GetMapping(value="/product/list",produces ="application/json")
	public ResponseEntity<List<Product>> product()
	{
		return new ResponseEntity<List<Product>>(pservice.list(), HttpStatus.OK);
	}
	
	@GetMapping(value="/product/getbycode/{code}",produces ="application/json")
	public ResponseEntity<Product> getByCode(@PathVariable int code) {
		return new ResponseEntity<Product>(pservice.getByCode(code), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/product/delete/{code}")
	public void delete(@PathVariable int code)
	{
		pservice.delete(code);
	}
	
	@GetMapping(value="/product/listbycategory/{category}",produces  ="application/json")
	public List<Product> listbycategory(@PathVariable  String category) {
		return pservice.listByCategory(category);
	}
	
	@GetMapping(value="/product/listbypricebetween",produces  ="application/json")
	public List<Product> listbypricebetween(@RequestParam @Valid double min,double max) {
		return pservice.listByPriceBetween(min,max);
	}
	
	@GetMapping(value="/product/listbyasc",produces="application/json")
	public List<Product> listbyAsc() {
		return pservice.listByAsc();
	}
	
}
