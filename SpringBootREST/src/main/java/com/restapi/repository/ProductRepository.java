package com.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapi.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
