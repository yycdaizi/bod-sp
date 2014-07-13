package com.ort.bodsp.core.exception;

public class BusinessException extends BaseException {
	
	static final long serialVersionUID = -1L;
	
	private String errorCode;
	private String message;
	private String systemException;

	public BusinessException() {
		super();	
	}

	public BusinessException(String message) {
		super(message);	
		this.message = message;
	}
	
	public BusinessException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public BusinessException(String errorCode, String message, String systemException) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
		this.systemException = systemException;
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSystemException() {
		return systemException;
	}

	public void setSystemException(String systemException) {
		this.systemException = systemException;
	}
	
}