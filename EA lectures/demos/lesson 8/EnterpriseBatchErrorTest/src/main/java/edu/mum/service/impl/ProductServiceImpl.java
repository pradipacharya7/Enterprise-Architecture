package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.ProductDao;
import edu.mum.domain.Product;

@Service
@Transactional 
 public class ProductServiceImpl implements edu.mum.service.ProductService {
	
 	@Autowired
	private ProductDao productDao;

    public Product save( Product product) {  
 // 		 if (product.getStatus() != ProductionStatus.INVALID) 
  			 this.performSave(product);
  			 return product;
 	}
  	
    private void performSave( Product product) {  		
  		productDao.save(product);
 	}
  	
    public void update( Product product) {  		
  		this.performUpdate(product);
 	}
  
    
    private void performUpdate( Product product) {  		
  		productDao.update(product);
 	}
     
  	
	public List<Product> findAll() {
		return (List<Product>)productDao.findAll();
	}

	public Product findByProductName(String name) {
		return productDao.findByProductName(name);
	}
 
	public Product findOne(Long id) {
		return productDao.findOne(id);
	}
	
 
}
