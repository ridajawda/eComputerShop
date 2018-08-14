package com.onlineclasses.demo.service;

import com.onlineclasses.demo.domain.Product;

import java.util.Set;

public interface ProductService {
    Set<Product> getProducts();

    Product findById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);
}
