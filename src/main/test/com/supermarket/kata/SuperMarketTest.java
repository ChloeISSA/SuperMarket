/**
 * 
 */
package com.supermarket.kata;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.supermarket.kata.domain.Cart;
import com.supermarket.kata.domain.Discount;
import com.supermarket.kata.domain.DiscountType;
import com.supermarket.kata.domain.Product;
import com.supermarket.kata.domain.ProductFactory;
import com.supermarket.kata.domain.exceptions.DiscountException;

/**
 * @author missa
 * SuperMarket Test class
 */
class SuperMarketTest {
	
	private Cart cart = new Cart();
	private CartCalculator cartCalculator= new CartCalculator();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		ProductFactory productFactory = new ProductFactory();
		Discount discountThreeForOneDollard = new Discount(3, null, BigDecimal.valueOf(1), DiscountType.MANY_FOR_ONE_PRICE);
		Product productThreeForOneDollar = productFactory.article(3, 1.2, "Choclate", discountThreeForOneDollard);
		Discount discountThreeForTwo = new Discount(3, 2, null, DiscountType.MANY_FOR_FREE);
		Product productThreeForTwo = productFactory.article(3, 4.0, "Candy", discountThreeForTwo);
		Discount noDiscount = new Discount(null, null, null, DiscountType.SIMPLE_PURCHASE);
		Product productSimple = productFactory.article(5, 3.3, "Pen", noDiscount);
		List<Product> products = new ArrayList<Product>();
		products.add(productThreeForOneDollar);
		products.add(productThreeForTwo);
		products.add(productSimple);
		cart = new Cart(products);
	}

	/**
	 * Test method for {@link com.supermarket.kata.CartCalculator#calculateTotal(java.util.List)}.
	 * as we hava calculated in this method multiple types of discounts on products added in the cart
	 */
	@Test
	public void testCalculateTotal() {
		BigDecimal total = cartCalculator.calculateTotalPrice(cart);
		
		assertEquals(BigDecimal.valueOf(25.5), total);
	}
	
	/**
	 * This function tests the thrown exception in the case of three for one Dollar the selledQuantity is mandatory
	 */
	@Test
	public void testCalculateTotalWithException() {
		Executable closureContainingCodeToTest = () -> new Discount(null, null, BigDecimal.valueOf(1), DiscountType.MANY_FOR_ONE_PRICE);		
		Assertions.assertThrows(DiscountException.class, closureContainingCodeToTest);
	}
	
	/**
	 * This function tests many for one fixed price as the case three for one Dollar
	 */
	@Test
	public void testCalculateManyForOnePrice() {
		cart = new Cart();
		ProductFactory productFactory = new ProductFactory();
		Discount discountThreeForOneDollard = new Discount(3, 3, BigDecimal.valueOf(1.0), DiscountType.MANY_FOR_ONE_PRICE);
		Product productThreeForOneDollar = productFactory.article(3, 1.2, "Choclate", discountThreeForOneDollard);
		cart.getProducts().add(productThreeForOneDollar);
		BigDecimal total = cartCalculator.calculateTotalPrice(cart);
		assertEquals(BigDecimal.valueOf(1.0), total);
	}
	
	/**
	 * This function tests many for free products as the case three for two
	 */
	@Test
	public void testCalculateManyForFree() {
		cart = new Cart();
		ProductFactory productFactory = new ProductFactory();
		Discount discountThreeForTwo = new Discount(3, 2, null, DiscountType.MANY_FOR_FREE);
		Product productThreeForTwo = productFactory.article(3, 4.0, "Candy", discountThreeForTwo);
		cart.getProducts().add(productThreeForTwo);
		BigDecimal total = cartCalculator.calculateTotalPrice(cart);
		assertEquals(BigDecimal.valueOf(8.0), total);
	}
	

	/**
	 * This function tests simple purchase case
	 */
	@Test
	public void testCalculateSimplePurchase() {
		cart = new Cart();
		ProductFactory productFactory = new ProductFactory();
		Discount noDiscount = new Discount(null, null, null, DiscountType.SIMPLE_PURCHASE);
		Product productSimple = productFactory.article(5, 3.3, "Pen", noDiscount);
		cart.getProducts().add(productSimple);
		BigDecimal total = cartCalculator.calculateTotalPrice(cart);
		assertEquals(BigDecimal.valueOf(16.5), total);
	}

}
