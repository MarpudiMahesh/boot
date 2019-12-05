package com.sample.springrest;

public class CustException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustException(String msg) {
		super(msg);
	}
}
