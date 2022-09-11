package io.toadlabs.jfgjds.data;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.data.impl.JsonArrayImpl;

public interface JsonArray extends JsonValue, Iterable<JsonValue> {

	static JsonArray clean() {
		return new JsonArrayImpl(new ArrayList<>());
	}

	static JsonArray of(@NotNull List<JsonValue> list) {
		return new JsonArrayImpl(list);
	}

	/**
	 * Gets the value at the specified index, otherwise throws.
	 * @param index The index.
	 * @return The value.
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	@NotNull JsonValue get(int index) throws IndexOutOfBoundsException;

	/**
	 * Gets the size of the JSON array.
	 * @return The size.
	 */
	int size();

	void add(@NotNull JsonValue value);

}
