package com.restapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.restapi.model.Product;
import com.restapi.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRestApplicationTests {

	@Autowired
	ProductService productService;

	String expectedSave = "Product saved successfully";
	String expectedUpdate = "Product updated successfully";

	@Test
	public void addProductTest() {
		Product product = new Product();
		product.setDescription("Laptop");
		product.setPrice(39400.00);
		assertEquals(expectedSave, productService.saveProduct(product));
	}

	@Test
	public void getProductListTest() {
		assertNotNull(productService.listAllProducts());
	}

	@Test
	public void getProductByIdTest() {
		assertNotNull(productService.getProductById(1));
	}

	@Test
	public void updateProductTest() {
		Product product = new Product();
		product.setId(1);
		product.setDescription("Laptop");
		product.setPrice(45400.00);
		assertEquals(expectedUpdate, productService.updateProduct(product));
	}

}
