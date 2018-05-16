package com.supermarket.kata.calculator;

import java.math.BigDecimal;

import com.supermarket.kata.domain.Discount;
import com.supermarket.kata.domain.Product;

/**
 * @author missa
 * This class allows to handle the case of the purchase of many products for one free as the case
 * three for two
 */
public class ManyForFreeProductsCalculator implements PriceCalculator {

	/* (non-Javadoc)
	 * @see com.supermarket.kata.calculator.PriceCalculator#calculatePrice(com.supermarket.kata.domain.Product)
	 * This method allows to handle the case of the purchase of many products for one free as the case
	 * three for two
	 */
	@Override
	public BigDecimal calculatePrice(Product product) {
		BigDecimal price;
		Discount discount = product.getDiscount();
		Integer selledQuantity = discount.getSelledQuantity();
		Integer payedQuantity = discount.getPayedQuantity();
		
		if(product.getQuantity() >= selledQuantity){
			int numberOfFreeProducts =  BigDecimal.valueOf(product.getQuantity()).divide(BigDecimal.valueOf(selledQuantity)).multiply(BigDecimal.valueOf(selledQuantity - payedQuantity)).intValue();
			price = BigDecimal.valueOf(product.getQuantity() - numberOfFreeProducts).multiply(product.getPrice());
		}else{
			price = BigDecimal.valueOf(product.getQuantity()).multiply(product.getPrice());
		}
		return price;
	}
}
