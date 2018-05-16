package com.supermarket.kata.calculator;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;

import com.supermarket.kata.domain.Product;

/**
 * @author missa
 * This class allows to calculate the price of products not having a discount on
 * by the mean of calculatePrice method
 */
public class SimplePriceCalculator implements PriceCalculator {

	/* (non-Javadoc)
	 * @see com.supermarket.kata.calculator.PriceCalculator#calculatePrice(com.supermarket.kata.domain.Product)
	 * This method allows to calculate the price of products not having a discount on
	 * by the mean of calculatePrice method
	 */
	@Override
	public BigDecimal calculatePrice(Product product) {
		requireNonNull(product);
		return product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()));
	}

}
