package com.knoxor.jpa.task.dto.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    ProductType productType;

    String description;

    BigDecimal price;

    Integer vatRate;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinTable(name = "PRODUCT_TO_PROMOTION", joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, inverseJoinColumns = { @JoinColumn(name = "PARENT_PRODUCT_ID") } )
    private Product promotion;

    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY)
    List<Product> promotions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Product productType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getVatRate() {
        return vatRate;
    }

    public Product vatRate(Integer vatRate) {
        this.vatRate = vatRate;
        return this;
    }


    public List<Product> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Product> promotions) {
        this.promotions = promotions;
    }

    public void addPromotion(Product product) {
        this.promotions.add(product);
    }
}
