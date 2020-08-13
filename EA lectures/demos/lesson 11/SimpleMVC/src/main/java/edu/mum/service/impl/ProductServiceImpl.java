package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.ProductDao;
import edu.mum.domain.Product;
import edu.mum.service.ProductService;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService{
	
 	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

 
 	public void save(Product product) {
		   productDao.save(product);
	}
	
	public Product findOne(long productID) {
		return productDao.findOne(productID);
	}

 
 


}
