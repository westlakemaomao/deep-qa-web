package com.deepQAWeb.exception;

@SuppressWarnings("serial")
public class ManagerException extends RuntimeException {
	public ManagerException() {
		super();
	}

	public ManagerException(String msg) {
		super(msg);
	}

	public ManagerException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
