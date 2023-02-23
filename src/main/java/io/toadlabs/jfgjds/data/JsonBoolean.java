package io.toadlabs.jfgjds.data;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.exception.JsonElementCastException;

public final class JsonBoolean extends JsonValue {

	public static final JsonBoolean FALSE = new JsonBoolean();
	public static final JsonBoolean TRUE = new JsonBoolean();

	private JsonBoolean() {
	}

	public boolean getValue() {
		return isTrue();
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
		return this == FALSE;
	}

	@Override
	public boolean isTrue() {
		return this == TRUE;
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonBoolean";
	}

	// no need for hashCode and equals since there is only true and false

}
