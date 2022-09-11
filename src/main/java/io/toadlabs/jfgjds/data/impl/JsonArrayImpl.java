package io.toadlabs.jfgjds.data.impl;

import java.util.Iterator;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.data.JsonArray;
import io.toadlabs.jfgjds.data.JsonValue;
import io.toadlabs.jfgjds.exception.JsonElementCastException;

public class JsonArrayImpl extends AbstractJsonValue implements JsonArray {

	private final List<JsonValue> list;

	public JsonArrayImpl(@NotNull List<JsonValue> list) {
		this.list = list;
	}

	@Override
	public Iterator<JsonValue> iterator() {
		return list.iterator();
	}

	@Override
	public @NotNull JsonValue get(int index) throws IndexOutOfBoundsException {
		return list.get(index);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonArray";
	}

	@Override
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
