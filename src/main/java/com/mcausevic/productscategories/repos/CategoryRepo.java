package com.mcausevic.productscategories.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.mcausevic.productscategories.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	List<Category>findAll();
	void deleteById(Long id);
	//Category save(Category x);
	Optional<Category> findById(Long id);
	Category findByName(String name);
}
