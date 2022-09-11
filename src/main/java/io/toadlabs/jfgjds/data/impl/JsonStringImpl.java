package io.toadlabs.jfgjds.data.impl;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.data.JsonString;
import io.toadlabs.jfgjds.exception.JsonElementCastException;

public class JsonStringImpl extends AbstractJsonValue implements JsonString {

	private final String value;

	public JsonStringImpl(String value) {
		this.value = Objects.requireNonNull(value);
	}

	@Override
	public @NotNull String getValue() {
		return value;
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonString";
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean isString() {
		return true;
	}

	@Override
	public @NotNull JsonString asString() throws JsonElementCastException {
		return this;
	}

	@Override
	public @NotNull String getStringValue() {
		return getValue();
	}

}
