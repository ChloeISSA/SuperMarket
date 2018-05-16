package com.supermarket.kata.domain;

/**
 * @author missa
 * Product creation factory by auto incremented id
 */
public class ProductFactory {

	/**
	 * 
	 */
	private int nextId = 0;

	/**
	 * @param quantity
	 * @param price
	 * @param name
	 * @param discountType
	 * @return
	 */
	public Product article(int quantity, double price, String name, Discount discount) {
		nextId += 1;
		return new Product(nextId, quantity, price, name, discount);
	}
	
}
