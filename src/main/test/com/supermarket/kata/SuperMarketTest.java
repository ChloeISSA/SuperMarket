/**
 * 
 */
package com.supermarket.kata;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.supermarket.kata.domain.Cart;
import com.supermarket.kata.domain.DiscountType;
import com.supermarket.kata.domain.Product;
import com.supermarket.kata.domain.ProductFactory;

/**
 * @author missa
 *
 */
class SuperMarketTest {
	
	private Cart cart = new Cart();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ProductFactory productFactory = new ProductFactory();
		Product productThreeForOneDollar = productFactory.article(3, 1.2, "Choclate", DiscountType.THREE_FOR_ONE_DOLAR);
		Product productThreeForTwo = productFactory.article(3, 4.0, "Candy", DiscountType.THREE_FOR_TWO);
		Product productSimple = productFactory.article(5, 3.3, "Pen", DiscountType.SIMPLE);
		List<Product> products = new ArrayList<Product>();
		products.add(productThreeForOneDollar);
		products.add(productThreeForTwo);
		products.add(productSimple);
		cart = new Cart(products);
	}

	/**
	 * Test method for {@link com.supermarket.kata.CartCalculator#calculateTotal(java.util.List)}.
	 */
	@Test
	void testCalculateTotal() {
		CartCalculator cartCalculator= new CartCalculator();
		double total = cartCalculator.calculateTotal(cart);
		
		assertEquals(25.5, total);
	}

}
