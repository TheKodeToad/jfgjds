package io.toadlabs.jfgjds.data;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.exception.JsonElementCastException;

public final class JsonString extends JsonValue {

	private final String value;

	public JsonString(String value) {
		this.value = Objects.requireNonNull(value);
	}

	/**
	 * Gets the string value, guaranteed not to be null.
	 *
	 * @return The string value.
	 */
	public @NotNull String getValue() {
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

	@Override
	protected String getPrimaryInterface() {
		return "JsonString";
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JsonString)) {
			return false;
		}

		JsonString other = (JsonString) obj;
		return Objects.equals(value, other.value);
	}

}
