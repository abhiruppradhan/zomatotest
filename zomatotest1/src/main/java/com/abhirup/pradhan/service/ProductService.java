package com.abhirup.pradhan.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhirup.pradhan.model.Product;
import com.abhirup.pradhan.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo proRepo;
	
	public void addProduct(Product product) {
		product.setProduct_Id(proRepo.count()+1);
		product.setActive(1);
		proRepo.save(product);
	}
	
	public void editProduct(Product product) {
		proRepo.save(product);
	}
	
	public void deleteProduct(Set<Product> products) {
		for(Product p : products) {
			p.setActive(0);
			proRepo.save(p);
		}
	}
	
	public void deleteOneproduct(long id) {
		proRepo.deleteById(id);;
	}
	
	public List<Product> getProducts(){
		return proRepo.findAll();
	}
	
	public Product getProduct(long id) {
		return proRepo.getOne(id);
	}
}
