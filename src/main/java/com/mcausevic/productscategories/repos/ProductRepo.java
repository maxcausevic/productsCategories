package com.mcausevic.productscategories.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcausevic.productscategories.models.Category;
import com.mcausevic.productscategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	List<Product>findAll();
	void deleteById(Long id);
	//Product save(Product x);
	Optional<Product> findById(Long id);
	Category findByName(String name);

}
