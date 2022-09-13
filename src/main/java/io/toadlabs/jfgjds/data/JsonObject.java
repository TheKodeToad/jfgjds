package io.toadlabs.jfgjds.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public final class JsonObject extends JsonValue {

	private final Map<String, JsonValue> map;

	/**
	 * A helper method to create an object similar to how you would in other languages.
	 * Values will be converted automatically.
	 * @param values An array of key value pairs.
	 * @return The object.
	 */
	public static @NotNull JsonObject of(Object... values) {
		if(values.length % 2 != 0) {
			throw new IllegalArgumentException("Uneven argument length");
		}

		Map<Object, Object> map = new HashMap<>();
		Object key = null;
		Object item;

		for(int index = 0; index < values.length; index++) {
			item = values[index];

			if(index % 2 == 0) {
				key = values[index];
				continue;
			}

			map.put(key, item);
		}

		return ofCoerced(map);
	}

	public static @NotNull JsonObject ofCoerced(Map<Object, Object> map) {
		JsonObject result = new JsonObject();

		map.forEach((_key, value) -> {
			String key = Objects.toString(_key);
			result.put(key, JsonValue.coerce(value));
		});

		return result;
	}

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
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject put(@NotNull String key, @Nullable JsonValue value) {
		map.put(Objects.requireNonNull(key), value);
		return this;
	}

	/**
	 * Sets a string in the object.
	 * @param key The key.
	 * @param value The string.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject put(@NotNull String key, @Nullable String value) {
		return put(key, new JsonString(value));
	}

	/**
	 * Sets a number in the object.
	 * @param key The key.
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject put(@NotNull String key, @Nullable double value) {
		return put(key, new JsonNumber(value));
	}

	/**
	 * Sets a boolean in the object.
	 * @param key The key.
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject put(@NotNull String key, @Nullable boolean value) {
		return put(key, value ? JsonBoolean.TRUE : JsonBoolean.FALSE);
	}

	/**
	 * Sets JSON null in the object.
	 * @param key The key.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject putNull(@NotNull String key) {
		return put(key, JsonNull.INSTANCE);
	}

	/**
	 * Removes a value by its key.
	 * @param key The key.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject remove(@NotNull String key) {
		map.remove(key);
		return this;
	}

	/**
	 * Removes a key from the map, only if it matches the specified value.
	 * @param key The key.
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject remove(@NotNull String key, @NotNull JsonValue value) {
		map.remove(key, value);
		return this;
	}

	/**
	 * Removes a key from the map, only if it matches the specified value.
	 * @param key The key.
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject remove(@NotNull String key, @NotNull String value) {
		return remove(key, new JsonString(value));
	}

	/**
	 * Removes a key from the map, only if it matches the specified value.
	 * @param key The key.
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject remove(@NotNull String key, double value) {
		return remove(key, new JsonNumber(value));
	}

	/**
	 * Removes a key from the map, only if it matches the specified value.
	 * @param key The key.
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonObject remove(@NotNull String key, boolean value) {
		return remove(key, value ? JsonBoolean.TRUE : JsonBoolean.FALSE);
	}

	/**
	 * Gets whether the object contains a mapping from the specified key.
	 * @param key The key.
	 * @return <code>true</code> if the key is present.
	 */
	public boolean contains(@NotNull String key) {
		return map.containsKey(key);
	}

	/**
	 * Gets whether the object contains the specified value.
	 * @param value The value.
	 * @return <code>true</code> if the value is present.
	 */
	public boolean contains(@NotNull JsonValue value) {
		return map.containsValue(value);
	}

	public @UnknownNullability JsonValue computeIfAbsent(@NotNull String key, @NotNull Function<String, JsonValue> mappingFunction) {
		return map.computeIfAbsent(key, mappingFunction);
	}

	public @UnknownNullability JsonValue computeIfPresent(@NotNull String key, @NotNull BiFunction<? super String, ? super JsonValue, ? extends JsonValue> mappingFunction) {
		return map.computeIfPresent(key, mappingFunction);
	}

	public @UnknownNullability JsonValue compute(@NotNull String key, @NotNull BiFunction<? super String, ? super JsonValue, ? extends JsonValue> remappingFunction) {
		return map.compute(key, remappingFunction);
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

	public int size() {
		return map.size();
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
	protected String getPrimaryInterface() {
		return "JsonObject";
	}

	@Override
	public int hashCode() {
		return map.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}

		if(!(obj instanceof JsonObject)) {
			return false;
		}

		JsonObject other = (JsonObject) obj;
		return map.equals(other.map);
	}

}