package io.toadlabs.jfgjds.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.toadlabs.jfgjds.data.impl.JsonObjectImpl;

public interface JsonObject extends JsonValue {

	static JsonObject clean() {
		return new JsonObjectImpl(new HashMap<>());
	}

	static JsonObject of(@NotNull Map<String, JsonValue> map) {
		return new JsonObjectImpl(map);
	}

	/**
	 * Gets a value on the object - nullable version.
	 * @param key The key.
	 * @return The value, or <code>null</code>.
	 */
	@Nullable JsonValue get(String key);

	/**
	 * Gets a value on the object - optional version.
	 * @param key The key.
	 * @return An optional value.
	 */
	@NotNull Optional<JsonValue> getOpt(String key);

	/**
	 * Sets a value in the object.
	 * @param key The key.
	 * @param value The value.
	 * @return The previous value associated with the key, which may be <code>null</code>.
	 */
	@Nullable JsonValue put(String key, JsonValue value);

	/**
	 * Sets a value in the object.
	 * @param key The key.
	 * @param value The value.
	 * @return Optionally, the previous value associated with the key.
	 */
	@NotNull Optional<JsonValue> putOpt(String key, JsonValue value);

	@NotNull Set<String> keys();

	@NotNull Collection<JsonValue> values();

	@NotNull Set<Entry<String, JsonValue>> entries();

	void forEach(@NotNull BiConsumer<String, JsonValue> action);

}