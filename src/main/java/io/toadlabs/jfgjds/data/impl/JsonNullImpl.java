package io.toadlabs.jfgjds.data.impl;

import io.toadlabs.jfgjds.data.JsonNull;

public class JsonNullImpl extends AbstractJsonValue implements JsonNull {

	public static final JsonNullImpl INSTANCE = new JsonNullImpl();

	private JsonNullImpl() {}

	@Override
	protected String getPrimaryInterface() {
		return "JsonNull";
	}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public String toString() {
		return "null";
	}

}
