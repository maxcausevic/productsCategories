package com.mcausevic.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcausevic.productscategories.models.Category;
import com.mcausevic.productscategories.models.Product;
import com.mcausevic.productscategories.repos.CategoryRepo;



@Service
public class CategoryService {
private final CategoryRepo categoryRepo;
	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	public List<Category>allCategories(){
		return categoryRepo.findAll();
	}
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}
	public Category findCategory(Long id) {
		Optional<Category>optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	public void addProduct(Category category, Product product ) {
		category.getProducts().add(product);
		categoryRepo.save(category);
		
	}
}
