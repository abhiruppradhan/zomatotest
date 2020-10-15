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
		proRepo.save(product);
	}
	
	public void editProduct(Product product) {
		proRepo.save(product);
	}
	
	public void deleteProduct(Set<Product> products) {
		for(Product p : products) {
			proRepo.delete(p);
		}
	}
	
	public void deleteOneproduct(int id) {
		proRepo.deleteById(id);;
	}
	
	public List<Product> getProducts(){
		return proRepo.findAll();
	}
	
	public Product getProduct(int id) {
		return proRepo.getOne(id);
	}
	
	public long getProductCount() {
		return proRepo.count();
	}

}
