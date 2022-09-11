package io.toadlabs.jfgjds.data.impl;

import io.toadlabs.jfgjds.data.JsonBoolean;
import io.toadlabs.jfgjds.exception.JsonElementCastException;

public class JsonBooleanImpl extends AbstractJsonValue implements JsonBoolean {

	public static final JsonBooleanImpl FALSE = new JsonBooleanImpl(false);
	public static final JsonBooleanImpl TRUE = new JsonBooleanImpl(true);

	private final boolean value;

	private JsonBooleanImpl(boolean value) {
		this.value = value;
	}

	@Override
	public boolean getValue() {
		return value;
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonBoolean";
	}

	@Override
	public String toString() {
		return value ? "true" : "false";
	}

	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public JsonBoolean asBoolean() {
		return this;
	}

	@Override
	public boolean getBooleanValue() throws JsonElementCastException {
		return getValue();
	}

	@Override
	public boolean isFalse() {
		return !value;
	}

	@Override
	public boolean isTrue() {
		return value;
	}

}
