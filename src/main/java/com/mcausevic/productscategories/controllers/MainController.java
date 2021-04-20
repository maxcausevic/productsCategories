package com.mcausevic.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcausevic.productscategories.models.Category;
import com.mcausevic.productscategories.models.Product;
import com.mcausevic.productscategories.services.CategoryService;
import com.mcausevic.productscategories.services.ProductService;

@Controller
public class MainController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public MainController(ProductService productService,CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
@RequestMapping("/")
public String index() {
	return "index.jsp";
}
@RequestMapping("/addProduct")
public String product(Model model) {
	List<Category>categories = categoryService.allCategories();
	model.addAttribute("categories", categories);
	model.addAttribute("product", new Product());
	
	
	return "addProduct.jsp";
}
@RequestMapping("/addCategory")
public String category(Model model) {
	List<Product>products = productService.allProducts();
	model.addAttribute("products", products);
	model.addAttribute("category", new Category());
	return "addCategory.jsp";
}
@RequestMapping(value="/addProduct/new",method=RequestMethod.POST)
public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
	if(result.hasErrors()) {
		return "addProduct.jsp";
	}else
		productService.createProduct(product);
		
	return "redirect:/";
}
@RequestMapping(value="/addCategory/new",method=RequestMethod.POST)
public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
	if(result.hasErrors()) {
		return "addCategory.jsp";
	}else
		categoryService.createCategory(category);
		
	return "redirect:/";
}
@RequestMapping("products/{id}")
public String showProduct(Model model, @PathVariable("id") Long id) {
	Product product = productService.findProduct(id);
	List<Category>categories = product.getCategories();
	List<Category>allCategories = categoryService.allCategories();
	model.addAttribute("product",product);
	model.addAttribute("categories", categories);
	model.addAttribute("allCategories", allCategories);
	return "show.jsp";
}
@RequestMapping("categories/{id}")
public String showCategories(Model model, @PathVariable("id") Long id) {
	Category category = categoryService.findCategory(id);
	List<Product>products = category.getProducts();
	List<Product>allProducts = productService.allProducts();
	model.addAttribute("category",category);
	model.addAttribute("products", products);
	model.addAttribute("allProducts", allProducts);
	return "showcategory.jsp";
}


@RequestMapping(value="/products/addCategory/{productId}", method=RequestMethod.POST)
public String addCategory(@PathVariable("productId") Long productId, @RequestParam("categoryId") Long categoryId){
	Category category = categoryService.findCategory(categoryId);
	Product product = productService.findProduct(productId);
	productService.addCategory(category, product);
	return "redirect:/products/"+ productId;
}
@RequestMapping(value="/categories/addProduct/{categoryId}", method=RequestMethod.POST)
public String addProduct(@PathVariable("categoryId") Long categoryId, @RequestParam("productId") Long productId){
	Category category = categoryService.findCategory(categoryId);
	Product product = productService.findProduct(productId);
	categoryService.addProduct(category, product);
	return "redirect:/categories/"+ categoryId;
}
}

