package com.supermarket.kata;

import com.supermarket.kata.domain.Cart;
import com.supermarket.kata.domain.DiscountType;
import com.supermarket.kata.domain.Product;

/**
 * @author missa
 *
 */
public class CartCalculator {
	
	private double total;

	/**
	 * @param cart
	 * @return
	 */
	public double calculateTotal(Cart cart) {
		total = 0.0;
		cart.getProducts().stream().forEach((product) -> {
			if (product.getDiscountType().equals(DiscountType.SIMPLE)) {
				total = totalSimple(total, product);
			} else if (product.getDiscountType().equals(DiscountType.THREE_FOR_TWO)) {
				total = totalThreeForTwo(total, product);
			} else if (product.getDiscountType().equals(DiscountType.THREE_FOR_ONE_DOLAR)) {
				total = totalThreeForOneDollar(total, product);
			}
		});
		return total;
	}

	/**
	 * @param total
	 * @param product
	 * @return
	 */
	private double totalThreeForOneDollar(double total, Product product) {
		if (product.getQuantity() == 3) {
			total += 1;
		} else {
			total += (1 / 3) * product.getQuantity();
		}
		return total;
	}

	/**
	 * @param total
	 * @param product
	 * @return
	 */
	private double totalThreeForTwo(double total, Product product) {
		if (product.getQuantity() == 3) {
			total += product.getPrice() * product.getQuantity() - product.getPrice();
		} else {
			total += (product.getPrice() / 3) * product.getQuantity();
		}
		return total;
	}

	/**
	 * @param total
	 * @param product
	 * @return
	 */
	private double totalSimple(double total, Product product) {
		total += product.getPrice() * product.getQuantity();
		return total;
	}
}
