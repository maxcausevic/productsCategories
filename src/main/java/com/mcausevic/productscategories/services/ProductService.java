package com.mcausevic.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcausevic.productscategories.models.Category;
import com.mcausevic.productscategories.models.Product;
import com.mcausevic.productscategories.repos.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	public List<Product>allProducts(){
		return productRepo.findAll();
	}
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	public Product findProduct(Long id) {
		Optional<Product>optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
	public Product saveRelationship(Product product) {
		return productRepo.save(product);
	}
	public void addCategory(Category category, Product product ) {
		product.getCategories().add(category);
		productRepo.save(product);
		
	}
}
