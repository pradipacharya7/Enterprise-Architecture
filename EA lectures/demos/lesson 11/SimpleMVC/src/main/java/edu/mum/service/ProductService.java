package edu.mum.service;

import java.util.List;

import edu.mum.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

  	void save(Product product);

	Product findOne(long id);
 
 

}
