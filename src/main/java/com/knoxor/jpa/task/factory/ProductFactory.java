package com.knoxor.jpa.task.factory;

import static com.knoxor.jpa.task.dto.repository.ProductType.INSURANCE;
import static com.knoxor.jpa.task.dto.repository.ProductType.MYPHONE_7;
import static com.knoxor.jpa.task.dto.repository.ProductType.MYPHONE_X;
import static com.knoxor.jpa.task.dto.repository.ProductType.PHONE_CASE;
import static com.knoxor.jpa.task.dto.repository.ProductType.SIM_CARD;

import com.knoxor.jpa.task.dto.repository.Product;
import com.knoxor.jpa.task.dto.repository.ProductType;
import java.math.BigDecimal;

public class ProductFactory {



    public Product createProduct(ProductType productType) {

        if(MYPHONE_7.equals(productType)) {

            return new Product().productType(MYPHONE_7).description("").price(new BigDecimal(300)).vatRate(14);

        } else  if(MYPHONE_X.equals(productType)) {

            return new Product().productType(MYPHONE_X).description("").price(new BigDecimal(500)).vatRate(14);

        } else  if(INSURANCE.equals(productType)) {

            return new Product().productType(INSURANCE).description("").price(new BigDecimal(300)).vatRate(0);

        } else  if(SIM_CARD.equals(productType)) {

            return new Product().productType(SIM_CARD).description("").price(new BigDecimal(300)).vatRate(14);

        } else  if(PHONE_CASE.equals(productType)) {

            return new Product().productType(PHONE_CASE).description("").price(new BigDecimal(300)).vatRate(14);

        }

        return new Product();

    }

}