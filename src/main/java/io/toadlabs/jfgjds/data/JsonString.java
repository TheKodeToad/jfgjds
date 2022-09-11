package io.toadlabs.jfgjds.data;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.data.impl.JsonStringImpl;

public interface JsonString extends JsonValue {

	static JsonString EMPTY = new JsonStringImpl("");

	static JsonString of(@NotNull String value) {
		return new JsonStringImpl(value);
	}

	/**
	 * Gets the string value, guaranteed not to be null.
	 * @return The string value.
	 */
	@NotNull String getValue();

}
