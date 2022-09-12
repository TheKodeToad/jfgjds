package io.toadlabs.jfgjds.exception;

import java.io.IOException;

public final class JsonParseException extends IOException {

	private static final long serialVersionUID = 6065931990953315542L;

	public JsonParseException(String message) {
		super(message);
	}

	public JsonParseException(String message, Throwable cause) {
		super(message, cause);
	}

}
