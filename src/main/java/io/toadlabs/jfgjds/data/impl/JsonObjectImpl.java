package io.toadlabs.jfgjds.data.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.toadlabs.jfgjds.data.JsonObject;
import io.toadlabs.jfgjds.data.JsonValue;

public class JsonObjectImpl extends AbstractJsonValue implements Cloneable, JsonObject {

	private final Map<String, JsonValue> map;

	public JsonObjectImpl(@NotNull Map<String, JsonValue> map) {
		this.map = Objects.requireNonNull(map);
	}

	@Override
	public JsonValue get(String key) {
		return map.get(key);
	}

	@Override
	public Optional<JsonValue> getOpt(String key) {
		return Optional.ofNullable(get(key));
	}

	@Override
	public @Nullable JsonValue put(String key, JsonValue value) {
		return map.put(key, value);
	}

	@Override
	public @NotNull Optional<JsonValue> putOpt(String key, JsonValue value) {
		return Optional.ofNullable(put(key, value));
	}

	@Override
	public @NotNull Set<String> keys() {
		return map.keySet();
	}

	@Override
	public @NotNull Collection<JsonValue> values() {
		return map.values();
	}

	@Override
	public @NotNull Set<Entry<String, JsonValue>> entries() {
		return map.entrySet();
	}

	@Override
	public void forEach(@NotNull BiConsumer<String, JsonValue> action) {
		map.forEach(action);
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonObject";
	}

	@Override
	public String toString() {
		return map.toString();
	}

	@Override
	public boolean isObject() {
		return true;
	}

	@Override
	public JsonObject asObject() {
		return this;
	}

}
