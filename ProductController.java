package com.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Product;
import com.app.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productservice;
	@GetMapping("/")
	public String msg() {
		return"welcome saurabh";
	}
	@PostMapping(value="/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productservice.addProduct(product),HttpStatus.OK);
		////http://localhost:8080/add in postman select post  
		
	}
	@GetMapping(value="/list")
	public ResponseEntity<List<Product>> getProduct(){
		return new ResponseEntity<List<Product>> (productservice.getProduct(),HttpStatus.OK);
		//http://localhost:8080/list
	}
	@GetMapping(value="/get/{id}")
	public ResponseEntity<Product> getProductbyId(@PathVariable int id){
		return new ResponseEntity<Product>(productservice.getProductbyId(id),HttpStatus.OK);
		//http://localhost:8080/get/1
	}
	@GetMapping(value="/getByname")
	public ResponseEntity<Product> getProductByName(@RequestParam String name){
		return new ResponseEntity<Product>(productservice.getProductByname(name),HttpStatus.OK);
		//http://localhost:8080/getByname?name=wipro
	}
	@DeleteMapping(value="/deleteById")
	public ResponseEntity<List<Product>> deleteProductById(@RequestParam int Id){
		return new ResponseEntity<List<Product>>(productservice.deleteProductById(Id),HttpStatus.OK);
		//http://localhost:8080/deleteById?Id=5
	}
	@PutMapping(value="/put/{id}")
	public ResponseEntity<Product> putProduct(@PathVariable int id , @RequestBody Product product){
		return new ResponseEntity<Product>(productservice.putProduct(id,product),HttpStatus.OK);
		//http://localhost:8080/put/3  med as put 
		// in body type          {"pid":3,"name":"Accenture","price":456002}
	}
}
