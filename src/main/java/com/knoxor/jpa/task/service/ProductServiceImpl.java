package com.knoxor.jpa.task.service;

import com.knoxor.jpa.task.dto.repository.Product;
import com.knoxor.jpa.task.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product create(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long productId) {
        return null;
    }

    @Override
    public void update(List<Product> products) {
        productRepo.saveAll(products);
    }
}
