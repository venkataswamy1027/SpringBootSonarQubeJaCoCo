package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Product;
import com.restapi.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> listAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public Product getProductById(Integer id) {
		Optional<Product> optinalProdcusts = productRepository.findById(id);
		return optinalProdcusts.get();
	}

	public String saveProduct(Product product) {
		productRepository.save(product);
		return "Product saved successfully";
	}

	public String updateProduct(Product product) {
		productRepository.save(product);
		return "Product updated successfully";
	}

}
