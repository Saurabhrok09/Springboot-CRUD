package com.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.app.entity.Product;
import com.app.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Product getProductbyId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	public Product getProductByname(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	public List<Product> deleteProductById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return repo.findAll();
	}

	public Product putProduct(int id, Product product) {
		// TODO Auto-generated method stub
		Product response=repo.findById(id).orElseGet(null);
		Product p=new Product();
		
		if(response!=null) {
			response.setName(product.getName());
			response.setPrice(product.getPrice());
			p=repo.save(response);
			
		}
		
		return p;
	}

}
