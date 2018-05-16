package com.supermarket.kata.calculator;

import java.math.BigDecimal;

import com.supermarket.kata.domain.Product;

/**
 * @author missa
 * This class allows to handle the case of the purchase of three for two products
 */
public class ManyForOneFreeCalculator implements PriceCalculator {

	/* (non-Javadoc)
	 * @see com.supermarket.kata.calculator.PriceCalculator#calculatePrice(com.supermarket.kata.domain.Product)
	 * This method allows to handle the case of the purchase of three for two products
	 */
	@Override
	public BigDecimal calculatePrice(Product product) {
		BigDecimal price;
		int productNumber = 3;
		if (product.getQuantity() == productNumber) {
			price = product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())).subtract(product.getPrice());
		} else {
			price = product.getPrice().multiply(BigDecimal.valueOf(2)).divide(BigDecimal.valueOf(3)).multiply(BigDecimal.valueOf(product.getQuantity()));
		}
		return price;
	}
}
