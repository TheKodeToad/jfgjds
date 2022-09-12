package io.toadlabs.jfgjds.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JsonObject extends JsonValue {

	private final Map<String, JsonValue> map;

	public JsonObject() {
		this(null);
	}

	public JsonObject(@Nullable Map<String, JsonValue> map) {
		if(map == null) {
			this.map = new HashMap<>();
		}
		else {
			this.map = new HashMap<>(map);
		}
	}

	/**
	 * Gets a value on the object - nullable version.
	 * @param key The key.
	 * @return The value, or <code>null</code>.
	 */
	public @Nullable JsonValue get(@NotNull String key) {
		return map.get(Objects.requireNonNull(key));
	}

	/**
	 * Gets a value on the object - optional version.
	 * @param key The key.
	 * @return An optional value.
	 */
	public @NotNull Optional<JsonValue> getOpt(@NotNull String key) {
		return Optional.ofNullable(get(key));
	}

	/**
	 * Sets a value in the object.
	 * @param key The key.
	 * @param value The value.
	 * @return The previous value associated with the key, which may be <code>null</code>.
	 */
	public @Nullable JsonValue put(@NotNull String key, @Nullable JsonValue value) {
		return map.put(Objects.requireNonNull(key), value);
	}

	/**
	 * Sets a value in the object.
	 * @param key The key.
	 * @param value The value.
	 * @return Optionally, the previous value associated with the key.
	 */
	public @NotNull Optional<JsonValue> putOpt(@NotNull String key, @Nullable JsonValue value) {
		return Optional.ofNullable(put(key, value));
	}

	public @NotNull Set<String> keys() {
		return map.keySet();
	}

	public @NotNull Collection<JsonValue> values() {
		return map.values();
	}

	public @NotNull Set<Entry<String, JsonValue>> entries() {
		return map.entrySet();
	}

	public void forEach(@NotNull BiConsumer<String, JsonValue> action) {
		map.forEach(action);
	}

	@Override
	public boolean isObject() {
		return true;
	}

	@Override
	public @NotNull JsonObject asObject() {
		return this;
	}

	@Override
	public String toString() {
		return map.toString();
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonObject";
	}

}