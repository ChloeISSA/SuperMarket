/**
 * 
 */
package com.supermarket.kata.calculator;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;

import com.supermarket.kata.domain.Product;

/**
 * @author missa
 * Price Calculator interface
 */
public interface PriceCalculator {
	
	/**
	 * @param product
	 * @return
	 * Default method to be used by implementing classes
	 */
	default BigDecimal calculatePrice(Product product){
		requireNonNull(product);
		return product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()));
	};

}
