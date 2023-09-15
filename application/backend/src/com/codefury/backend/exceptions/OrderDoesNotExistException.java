package com.codefury.backend.exceptions;

/*
 * Custom Exception:
 * 		-
 */
public class OrderDoesNotExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2412972543829833608L;

	// Constructors
	public OrderDoesNotExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDoesNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public OrderDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OrderDoesNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OrderDoesNotExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
