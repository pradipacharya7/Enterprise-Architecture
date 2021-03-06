package edu.mum.service;

import java.util.List;

import edu.mum.domain.Product;
 
public interface ProductService {

	public void save(Product product) throws Throwable ;
	public void update(Product product) throws Throwable ;
	public List<Product> findAll();
	public Product findByProductName(String name);

	public Product findOne(Long id);

}
