package com.onlineclasses.demo.controller;

import com.onlineclasses.demo.domain.Product;
import com.onlineclasses.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getProducts());
		return "products";
	}

	@RequestMapping("products/{id}/view")
	public String showProduct(@PathVariable String id, Model model) {
		model.addAttribute("product", productService.findById(Long.valueOf(id)));
		return "viewProduct";
	}

	}