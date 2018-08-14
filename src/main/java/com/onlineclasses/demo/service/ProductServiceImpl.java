package com.onlineclasses.demo.service;

import com.onlineclasses.demo.dao.ProductRepository;
import com.onlineclasses.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Set<Product> getProducts() {
        Set<Product> productSet = new HashSet<>();
       productRepository.findAll().iterator().forEachRemaining(productSet::add);
        return productSet;
    }

    @Override
    public Product findById(Long l) {
        Optional<Product> productOptional = productRepository.findById(l);

        if (!productOptional.isPresent()) {
            throw new RuntimeException("Employee Not Found!");
        }

        return productOptional.get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);

    }
}




