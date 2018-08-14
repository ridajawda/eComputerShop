package com.onlineclasses.demo.dao;

import com.onlineclasses.demo.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
