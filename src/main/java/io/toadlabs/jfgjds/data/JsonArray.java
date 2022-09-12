package io.toadlabs.jfgjds.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.toadlabs.jfgjds.exception.JsonElementCastException;

public final class JsonArray extends JsonValue implements Iterable<JsonValue> {

	private final List<JsonValue> list;

	public JsonArray() {
		this(null);
	}

	public JsonArray(@Nullable List<JsonValue> list) {
		if(list == null) {
			this.list = new ArrayList<>();
		}
		else {
			this.list = new ArrayList<>(list);
		}
	}

	@Override
	public Iterator<JsonValue> iterator() {
		return list.iterator();
	}

	/**
	 * Gets the value at the specified index, otherwise throws.
	 * @param index The index.
	 * @return The value.
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	public @NotNull JsonValue get(int index) throws IndexOutOfBoundsException {
		return list.get(index);
	}

	public int size() {
		return list.size();
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonArray";
	}

	public void add(@NotNull JsonValue value) {
		list.add(value);
	}

	@Override
	public String toString() {
		return list.toString();
	}

	@Override
	public boolean isArray() {
		return true;
	}

	@Override
	public @NotNull JsonArray asArray() throws JsonElementCastException {
		return this;
	}

}
