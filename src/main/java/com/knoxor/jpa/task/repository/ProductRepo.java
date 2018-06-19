package com.knoxor.jpa.task.repository;

import com.knoxor.jpa.task.dto.repository.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
}
