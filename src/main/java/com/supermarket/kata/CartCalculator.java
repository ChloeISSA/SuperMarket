package com.supermarket.kata;

import java.math.BigDecimal;

import com.supermarket.kata.calculator.PriceCalculatorFactory;
import com.supermarket.kata.calculator.SimplePriceCalculator;
import com.supermarket.kata.calculator.ManyForOnePriceCalculator;
import com.supermarket.kata.calculator.ManyForFreeProductsCalculator;
import com.supermarket.kata.domain.Cart;
import com.supermarket.kata.domain.DiscountType;
import com.supermarket.kata.domain.Product;

/**
 * @author missa
 * This class calculates the total price of the cart based on each case of discount type
 * and by respecting the generic cases possible
 */
public class CartCalculator {

	public CartCalculator(){
		PriceCalculatorFactory.registerPriceCalculator(DiscountType.SIMPLE_PURCHASE, new SimplePriceCalculator());
		PriceCalculatorFactory.registerPriceCalculator(DiscountType.MANY_FOR_ONE_PRICE, new ManyForOnePriceCalculator());
		PriceCalculatorFactory.registerPriceCalculator(DiscountType.MANY_FOR_FREE, new ManyForFreeProductsCalculator());
	}
	/**
	 * @param cart
	 * @return
	 * We iterate over the list of products to calculate the total price
	 */
	public BigDecimal calculateTotalPrice(Cart cart) {
		BigDecimal totalPrice = cart.getProducts().stream().map(Product::getCalculatedPrice).reduce(BigDecimal::add).get();
		return totalPrice;
	}

}
