package com.onlineclasses.demo.controller;

import com.onlineclasses.demo.dao.ProductRepository;
import com.onlineclasses.demo.domain.Product;
import com.onlineclasses.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@SessionAttributes(names = "product")
public class AdminController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/admin")
	public String productInventory() {
		return "admin";
	}

	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model) {
		model.addAttribute("products", productService.getProducts());
		return "productInventory";
	}

	@GetMapping("/admin/prodcutInventory/addProduct")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}


	@RequestMapping("/admin/prodcutInventory/{id}/updateProduct")
	public String updateProduct(@PathVariable String id, Model model) {
		model.addAttribute("product", productService.findById(Long.valueOf(id)));
		return "addProduct";
	}

	@PostMapping("/admin/prodcutInventory/addProduct/saveProduct")
	public String saveOrUpdate(@Valid Product product, BindingResult bindingResult, Model model  ) {
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
       	productService.saveProduct(product);
		model.addAttribute("products",productService.getProducts());
		return "redirect:/admin/productInventory/";
	}

    @RequestMapping("admin/prodcutInventory/{id}/deleteProduct")
	public String deleteProduct(@PathVariable String id, ModelMap model) {
		productService.deleteProduct(Long.valueOf(id));
		model.addAttribute("products",productService.getProducts());
		return "redirect:/admin/productInventory/";
	}

    @GetMapping(value = "/403")
    public String accessDeniedPage() {
        return "accessDeniedPage";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }

}
