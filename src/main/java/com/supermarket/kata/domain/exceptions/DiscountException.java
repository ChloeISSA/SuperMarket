package com.supermarket.kata.domain.exceptions;

/**
 * @author missa
 * This class handles the excpetion thrown in the different cases of discount
 *
 */
public class DiscountException extends RuntimeException {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param errorMessage
	 */
	public DiscountException(String errorMessage) {
		super(errorMessage);
	}

}
