package com.gh.exception;

import com.gh.constant.Constant;


/**
 * @author finally
 */
public class ParamException extends RuntimeException {
	
	private int errorCode;

	public ParamException() {
	}

	public ParamException(String message) {
		super(message);
	}
	
	public ParamException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	

}
