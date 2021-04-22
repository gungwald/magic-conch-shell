package com.alteredmechanism.mcsh;

public class ShellException extends Exception {

	private static final long serialVersionUID = 1L;

	public ShellException() {
	}

	public ShellException(String message) {
		super(message);
	}

	public ShellException(Throwable t) {
		super(t);
	}

	public ShellException(String message, Throwable t) {
		super(message, t);
	}

}
