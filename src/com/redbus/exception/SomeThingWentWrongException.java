package com.redbus.exception;

public class SomeThingWentWrongException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 228398913099373032L;

	public SomeThingWentWrongException() {
		super();
	}

	public SomeThingWentWrongException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SomeThingWentWrongException(String message, Throwable cause) {
		super(message, cause);
	}

	public SomeThingWentWrongException(String message) {
		super(message);
	}

	public SomeThingWentWrongException(Throwable cause) {
		super(cause);
	}

}
