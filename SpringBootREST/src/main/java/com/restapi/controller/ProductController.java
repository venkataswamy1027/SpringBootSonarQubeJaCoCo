package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Product;
import com.restapi.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductController {
	@Autowired
	private ProductService productService;

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/list")
	public List<Product> list() {
		return productService.listAllProducts();
	}

	@ApiOperation(value = "Search a product with an ID", response = Product.class)
	@GetMapping("/{id}")
	public Product showProduct(@PathVariable Integer id) {
		Product product = productService.getProductById(id);
		return product;
	}

	@ApiOperation(value = "Add a product")
	@PostMapping("/add")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		String result = productService.saveProduct(product);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a product")
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		Product storedProduct = productService.getProductById(id);
		storedProduct.setDescription(product.getDescription());
		storedProduct.setPrice(product.getPrice());
		String result = productService.updateProduct(storedProduct);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
