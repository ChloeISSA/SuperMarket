package com.supermarket.kata.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.supermarket.kata.domain.exceptions.DiscountException;

/**
 * @author missa
 * Pojo class discount
 */
public class Discount implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer selledQuantity;
	private Integer payedQuantity;
	private BigDecimal discountPrice;
	private DiscountType discountType;
	
	/**
	 * @param selledQuantity
	 * @param payedQuantity
	 * @param discountPrice
	 * @param discountType
	 */
	public Discount(Integer selledQuantity, Integer payedQuantity,
			BigDecimal discountPrice, DiscountType discountType) {
		super();
		this.selledQuantity = selledQuantity;
		this.payedQuantity = payedQuantity;
		this.discountPrice = discountPrice;
		this.discountType = discountType;
		
		if(discountType.equals(DiscountType.MANY_FOR_FREE) && (selledQuantity == null || payedQuantity == null)){
			throw new DiscountException("The selled and the payed quantities are mandatory if the discount Type is Many For Free Products.");
		}
		
		if(discountType.equals(DiscountType.MANY_FOR_ONE_PRICE) && (selledQuantity == null || discountPrice == null)){
			throw new DiscountException("The selled quantity and the discount price are mandatory if the discount Type is Many For One Price.");
		}
	}
	
	/**
	 * @return the discountType
	 */
	public DiscountType getDiscountType() {
		return discountType;
	}
	/**
	 * @param discountType the discountType to set
	 */
	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	/**
	 * @return the selledQuantity
	 */
	public Integer getSelledQuantity() {
		return selledQuantity;
	}
	/**
	 * @param selledQuantity the selledQuantity to set
	 */
	public void setSelledQuantity(Integer selledQuantity) {
		this.selledQuantity = selledQuantity;
	}
	/**
	 * @return the payedQuantity
	 */
	public Integer getPayedQuantity() {
		return payedQuantity;
	}
	/**
	 * @param payedQuantity the payedQuantity to set
	 */
	public void setPayedQuantity(Integer payedQuantity) {
		this.payedQuantity = payedQuantity;
	}
	/**
	 * @return the discountPrice
	 */
	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}
	/**
	 * @param discountPrice the discountPrice to set
	 */
	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountPrice == null) ? 0 : discountPrice.hashCode());
		result = prime * result + ((discountType == null) ? 0 : discountType.hashCode());
		result = prime * result + ((payedQuantity == null) ? 0 : payedQuantity.hashCode());
		result = prime * result + ((selledQuantity == null) ? 0 : selledQuantity.hashCode());
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
		Discount other = (Discount) obj;
		if (discountPrice == null) {
			if (other.discountPrice != null)
				return false;
		} else if (!discountPrice.equals(other.discountPrice))
			return false;
		if (discountType != other.discountType)
			return false;
		if (payedQuantity == null) {
			if (other.payedQuantity != null)
				return false;
		} else if (!payedQuantity.equals(other.payedQuantity))
			return false;
		if (selledQuantity == null) {
			if (other.selledQuantity != null)
				return false;
		} else if (!selledQuantity.equals(other.selledQuantity))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Discount [selledQuantity=" + selledQuantity + ", payedQuantity=" + payedQuantity + ", discountPrice="
				+ discountPrice + ", discountType=" + discountType + "]";
	}

}
