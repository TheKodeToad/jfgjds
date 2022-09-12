package io.toadlabs.jfgjds.data;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.exception.JsonElementCastException;

public final class JsonBoolean extends JsonValue {

	public static final JsonBoolean FALSE = new JsonBoolean(false);
	public static final JsonBoolean TRUE = new JsonBoolean(true);

	private final boolean value;

	private JsonBoolean(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public @NotNull JsonBoolean asBoolean() {
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

	@Override
	public String toString() {
		return value ? "true" : "false";
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonBoolean";
	}

}
