package com.supermarket.kata.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author missa
 * Pojo class cart
 */
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7607487705302283241L;
	private List<Product> products = new ArrayList<Product>();
	
	/**
	 * 
	 */
	public Cart() {
		super();
	}
	/**
	 * @param products
	 */
	public Cart(List<Product> products) {
		super();
		this.products = products;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		Cart other = (Cart) obj;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}
	
}
