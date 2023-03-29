package com.redbus.exception;

public class NoRecordFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6774948564892696257L;

	public NoRecordFoundException() {
		super();
	}

	public NoRecordFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoRecordFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoRecordFoundException(String message) {
		super(message);
	}

	public NoRecordFoundException(Throwable cause) {
		super(cause);
	}

}
