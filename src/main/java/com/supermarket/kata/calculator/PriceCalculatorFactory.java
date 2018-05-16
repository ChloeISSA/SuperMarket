package com.supermarket.kata.calculator;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Map;

import com.supermarket.kata.domain.DiscountType;

/**
 * @author missa
 * This class allows to calculate the price of products by their type of discount
 */
public class PriceCalculatorFactory {
	
	private static Map<DiscountType, PriceCalculator> priceCalculators = new HashMap<DiscountType, PriceCalculator>();
	
	/**
	 * @param discountType
	 * @param priceCalculator
	 * This method registers the price calculator according to it's discount type
	 */
	public static void registerPriceCalculator(DiscountType discountType, PriceCalculator priceCalculator){
        requireNonNull(discountType);
        requireNonNull(priceCalculator);
        priceCalculators.put(discountType, priceCalculator);
	}
	
	/**
	 * @param discountType
	 * @return
	 * Get the price claculator by discount type
	 */
	public static PriceCalculator getPriceCalculator(DiscountType discountType){
		requireNonNull(discountType);
		return priceCalculators.get(discountType);
	}

}
