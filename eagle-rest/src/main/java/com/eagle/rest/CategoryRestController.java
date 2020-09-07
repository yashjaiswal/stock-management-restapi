package com.eagle.rest;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.entity.Category;
import com.eagle.service.CategoryService;

@RestController
@RequestMapping("/eagle")
public class CategoryRestController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@GetMapping("/category/{categoryId}")
	public Category getCategoryType(@PathVariable int categoryId) {
		return categoryService.getCategory(categoryId);
		
	}
}
