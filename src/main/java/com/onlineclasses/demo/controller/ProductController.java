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

import java.io.IOException;

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
	public String updateClient(@PathVariable String id, Model model) {
		model.addAttribute("product", productService.findById(Long.valueOf(id)));
		return "viewProduct";
	}

	@RequestMapping("admin")
	public String productInventory() {
		return "admin";
	}

	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model) {
		model.addAttribute("products", productService.getProducts());
		return "productInventory";
	}

	@RequestMapping("/admin/prodcutInventory/addProduct")
	public String newEmployee(Model model) {
		model.addAttribute("product", new Product());
		return "addProdcut";
	}

	@RequestMapping("/admin/prodcutInventory/{id}/updateProduct")
	public String updateProduct(@PathVariable String id, Model model) {
		model.addAttribute("product", productService.findById(Long.valueOf(id)));
		return "addProdcut";
	}

	@PostMapping("/admin/prodcutInventory/addProduct/saveProduct")
	public String saveOrUpdate(Model model, Product product) {
		productService.saveProduct(product);
		model.addAttribute("products",productService.getProducts());
		return "redirect:/admin/productInventory/";
	}


	@RequestMapping("product/{id}/delete")
	public ModelAndView deleteEmployee(@PathVariable String id, ModelMap model) {
		productService.deleteProduct(Long.valueOf(id));
		 model.addAttribute("products", productService.getProducts());
		 return new ModelAndView("redirect:/products", model);	
	}
}