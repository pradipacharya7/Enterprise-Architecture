package edu.mum.service;

import java.util.List;

import edu.mum.domain.Category;

public interface CategoryService {

	List<Category> findAll();

  	void save(Category category);

	Category findOne(long id);
 
 

}
