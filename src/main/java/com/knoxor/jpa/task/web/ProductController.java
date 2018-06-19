package com.knoxor.jpa.task.web;

import com.knoxor.jpa.task.dto.repository.Product;
import com.knoxor.jpa.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    EntityLinks entityLinks;

    @RequestMapping("/products")
    public ResponseEntity<Iterable<Product>> getProductList() {
        Iterable<Product> all = productService.findAll();
        return ResponseEntity.ok(all);
    }

    @RequestMapping("/products/{product}")
    public ResponseEntity<Product> updateProduct(@PathVariable Product product) {
        productService.update(product);
        return ResponseEntity.ok(product);
    }
}
