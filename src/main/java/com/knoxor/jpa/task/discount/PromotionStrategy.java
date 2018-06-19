package com.knoxor.jpa.task.discount;

import static com.knoxor.jpa.task.dto.repository.ProductType.INSURANCE;
import static com.knoxor.jpa.task.dto.repository.ProductType.MYPHONE_7;
import static com.knoxor.jpa.task.dto.repository.ProductType.MYPHONE_X;
import static com.knoxor.jpa.task.dto.repository.ProductType.PHONE_CASE;
import static com.knoxor.jpa.task.dto.repository.ProductType.SIM_CARD;

import com.knoxor.jpa.task.dto.repository.Product;
import com.knoxor.jpa.task.dto.web.Cart;
import com.knoxor.jpa.task.factory.ProductFactory;
import java.math.BigDecimal;

public class PromotionStrategy {

    ProductFactory productFactory = new ProductFactory();

    public Cart applyPromotion(Cart cart) {

        for (Product product : cart.getProducts()) {
            if (MYPHONE_7.equals(product.getProductType()) || MYPHONE_X.equals(product.getProductType())) {

                product.addPromotion(productFactory.createProduct(SIM_CARD));
                Product insurance = productFactory.createProduct(INSURANCE);
                insurance.price(insurance.getPrice().divide(new BigDecimal(4)));
                product.addPromotion(insurance);

            } else if (SIM_CARD.equals(product.getProductType())) {

                product.addPromotion(productFactory.createProduct(SIM_CARD));

            }
        }

        // do sim card rule last to more than 10 are not purchased when
        long simCards = cart.getProducts().stream().filter(product -> SIM_CARD.equals(product.getProductType())).count();
        if(simCards > 10) {
            //reduce number to 10
        }

        long cases = cart.getProducts().stream().filter(product -> PHONE_CASE.equals(product.getProductType())).count();
        int casenumber = Math.toIntExact(cases % 3);
        // add multiple of 4 for 3 cases

        return cart;
    }
}
