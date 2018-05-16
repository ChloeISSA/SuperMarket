package com.supermarket.kata.domain;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.math.BigDecimal;

import com.supermarket.kata.calculator.PriceCalculator;
import com.supermarket.kata.calculator.PriceCalculatorFactory;

/**
 * @author missa
 * Pojo class product
 */
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2483395985089899855L;
	private int id;
	private int quantity;
	private BigDecimal price;
	private String name;
	private Discount discount;
	
	public Product() {
		super();
	}
	/**
	 * @param id
	 * @param quantity
	 * @param price
	 * @param name
	 * @param discountType
	 */
	public Product(int id, int quantity, double price, String name, Discount discount) {
		super(); 
		this.id = id;
		this.quantity = quantity;
		this.price = BigDecimal.valueOf(price);
		this.name = requireNonNull(name);
		this.discount = requireNonNull(discount);
	}
	
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getCalculatedPrice(){
		PriceCalculator priceCalculator = PriceCalculatorFactory.getPriceCalculator(discount.getDiscountType());
		return priceCalculator.calculatePrice(this);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + quantity;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", quantity=" + quantity + ", price="
				+ price + ", name=" + name + ", discount=" + discount + "]";
	}
	
	
	
}
