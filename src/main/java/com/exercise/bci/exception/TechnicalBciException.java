package com.exercise.bci.exception;

import com.exercise.bci.enums.Error;

public class TechnicalBciException extends Exception {

	private static final long serialVersionUID = -8477693501103275974L;

	private final Error error;
	
	public TechnicalBciException(Error error) {
		super(error.getDetalle());
		this.error = error;
	}

	public Error getError() {
		return error;
	}
}
