package com.knoxor.jpa.task.dto.web;

import com.knoxor.jpa.task.discount.PromotionStrategy;
import com.knoxor.jpa.task.dto.repository.Product;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    List<Product> products;

    PromotionStrategy promotionStrategy = new PromotionStrategy();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalAmount() {
        return products.stream().mapToDouble(product -> product.getPrice().doubleValue()).sum();
    }

    public void applyPromotions() {
        products.stream().map(p -> promotionStrategy.applyPromotion(this)).collect(Collectors.toList());
    }
}
