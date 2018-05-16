package com.supermarket.kata.calculator;

import java.math.BigDecimal;

import com.supermarket.kata.domain.Discount;
import com.supermarket.kata.domain.Product;

/**
 * @author missa
 * This class allows to handle the case of the purchase of many products for one fixed price as the case
 * three for one Dollar
 */
public class ManyForOnePriceCalculator implements PriceCalculator {

	/* (non-Javadoc)
	 * @see com.supermarket.kata.calculator.PriceCalculator#calculatePrice(com.supermarket.kata.domain.Product)
	 * This method allows to handle the case of the purchase of many products for one fixed price as the case
	 * three for one Dollar
	 */
	@Override
	public BigDecimal calculatePrice(Product product) {
		BigDecimal price;
		Discount discount = product.getDiscount();
		if(product.getQuantity() >=  discount.getSelledQuantity()){
			price = BigDecimal.valueOf(product.getQuantity()).divide(BigDecimal.valueOf(discount.getSelledQuantity())).multiply(discount.getDiscountPrice());
			price.add(BigDecimal.valueOf(product.getQuantity()).subtract(BigDecimal.valueOf(discount.getSelledQuantity())).multiply(product.getPrice()));
		}else{
			price = BigDecimal.valueOf(product.getQuantity()).multiply(product.getPrice());
		}
		return price;
	}

}
