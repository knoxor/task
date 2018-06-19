package com.knoxor.jpa.task.service;


import com.knoxor.jpa.task.dto.repository.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product update(Product product);

    Iterable<Product> findAll();

    Product findById(Long productId);

    void update(List<Product> products);
}
