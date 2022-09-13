package io.toadlabs.jfgjds.data;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.toadlabs.jfgjds.JsonSerializer;
import io.toadlabs.jfgjds.exception.JsonElementCastException;

/**
 * Represents one of the following:
 * <ul>
 *   <li>JSON object</li>
 *   <li>JSON array</li>
 *   <li>JSON string</li>
 *   <li>JSON number</li>
 *   <li>JSON boolean</li>
 *   <li>JSON null</li>
 * </ul>
 */
public abstract class JsonValue {

	public static @NotNull JsonValue coerce(Object value) {
		if(value == null) {
			return JsonNull.INSTANCE;
		}
		else if(value instanceof JsonValue) {
			return (JsonValue) value;
		}
		else if(value instanceof String) {
			return new JsonString((String) value);
		}
		else if(value instanceof Number) {
			return new JsonNumber(((Number) value).doubleValue());
		}
		else if(value instanceof Boolean) {
			return (boolean) value ? JsonBoolean.TRUE : JsonBoolean.FALSE;
		}
		else if(value instanceof Map) {
			return JsonObject.ofCoerced((Map<Object, Object>) value);
		}
		else if(value instanceof List) {
			return JsonArray.of((List<Object>) value);
		}
		else if(value instanceof Object[]) {
			return JsonArray.of((Object[]) value);
		}
		else {
			return new JsonString(value.toString());
		}
	}


	/**
	 * Gets whether the JSON value is an object.
	 * @return <code>true</code> if this is a JSON object.
	 */
	public boolean isObject() {
		return false;
	}

	/**
	 * Gets the JSON value as an object, otherwise throws.
	 * @return The JSON object.
	 * @throws JsonElementCastException If the value is not an object.
	 */
	public @NotNull JsonObject asObject() {
		throw new JsonElementCastException("Not a JsonObject: " + this + " (" + getPrimaryInterface() + ")");
	}

	/**
	 * Gets the JSON value as an object - nullable version.
	 * @return The JSON object, or <code>null</code>.
	 */
	public final @Nullable JsonObject asObjectOrNull() {
		return isObject() ? asObject() : null;
	}

	/**
	 * Gets the JSON value as an object - optional version.
	 * @return An optional JSON object.
	 */
	public final @NotNull Optional<JsonObject> asObjectOpt() {
		return Optional.ofNullable(asObjectOrNull());
	}

	/**
	 * Gets whether the JSON value is an array.
	 * @return <code>true</code> if this is a JSON array.
	 */
	public boolean isArray() {
		return false;
	}

	/**
	 * Gets the JSON value as an array, otherwise throws.
	 * @return The JSON array.
	 * @throws JsonElementCastException If the value is not an array.
	 */
	public @NotNull JsonArray asArray() throws JsonElementCastException {
		throw new JsonElementCastException("Not a JsonArray: " + this + " (" + getPrimaryInterface() + ")");
	}

	/**
	 * Gets the JSON value as an array - nullable version.
	 * @return The JSON array, or <code>null</code>.
	 */
	public final @Nullable JsonArray asArrayOrNull() {
		return isArray() ? asArray() : null;
	}

	/**
	 * Gets the JSON value as an array - optional version.
	 * @return An optional JSON array.
	 */
	public final @NotNull Optional<JsonArray> asArrayOpt() {
		return Optional.ofNullable(asArrayOrNull());
	}

	/**
	 * Gets whether the JSON value is a string.
	 * @return <code>true</code> if this is a JSON string.
	 */
	public boolean isString() {
		return false;
	}

	/**
	 * Gets the JSON value as a string, otherwise throws.
	 * @return The JSON string.
	 * @throws JsonElementCastException If the value is not an string.
	 */
	public @NotNull JsonString asString() throws JsonElementCastException {
		throw new JsonElementCastException("Not a JsonString: " + this + " (" + getPrimaryInterface() + ")");
	}

	/**
	 * Gets the JSON value as a string - nullable version.
	 * @return The JSON string, or <code>null</code>.
	 */
	public final @Nullable JsonString asStringOrNull() {
		return isString() ? asString() : null;
	}

	/**
	 * Gets the JSON value as a string - optional version.
	 * @return An optional JSON string.
	 */
	public final @NotNull Optional<JsonString> asStringOpt() {
		return Optional.ofNullable(asStringOrNull());
	}

	/**
	 * Gets the Java value of the JSON string, otherwise throws.
	 * @return The Java string.
	 * @throws JsonElementCastException If the value is not a string.
	 */
	public @NotNull String getStringValue() {
		throw new JsonElementCastException("Not a JsonString: " + this + " (" + getPrimaryInterface() + ")");
	}

	/**
	 * Gets the Java value of the JSON string - nullable version.
	 * @return The Java string, or <code>null</code>.
	 */
	public final @Nullable String getStringValueOrNull() {
		return isString() ? getStringValue() : null;
	}

	/**
	 * Gets the Java value of the JSON string - optional version.
	 * @return An optional Java string.
	 */
	public final @NotNull Optional<String> getStringValueOpt() {
		return Optional.ofNullable(getStringValueOrNull());
	}

	/**
	 * Gets whether the JSON value is a number.
	 * @return <code>true</code> if this is a JSON number.
	 */
	public boolean isNumber() {
		return false;
	}

	/**
	 * Gets the JSON value as a number, otherwise throws.
	 * @return The JSON number.
	 * @throws JsonElementCastException If the value is not an number.
	 */
	public @NotNull JsonNumber asNumber() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	/**
	 * Gets the JSON value as a number - nullable version.
	 * @return The JSON number.
	 */
	public final @Nullable JsonNumber asNumberOrNull() {
		return isNumber() ? asNumber() : null;
	}

	/**
	 * Gets the JSON value as a number - optional version.
	 * @return An optional JSON number.
	 */
	public final @NotNull Optional<JsonNumber> asNumberOpt() {
		return Optional.ofNullable(asNumberOrNull());
	}

	/**
	 * Gets the Java value of the JSON number, otherwise throws.
	 * @return The Java number.
	 * @throws JsonElementCastException If the value is not a number.
	 */
	public @NotNull double getNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	public final @Nullable Double getNumberValueOrNull() {
		return isNumber() ? getNumberValue() : null;
	}

	public final @NotNull Optional<Double> getNumberValueOpt() {
		return Optional.ofNullable(getNumberValueOrNull());
	}

	public byte getByteNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	public final @Nullable Byte getByteNumberValueOrNull() {
		return isNumber() ? getByteNumberValue() : null;
	}

	public final @NotNull Optional<Byte> getByteNumberValueOpt() {
		return Optional.ofNullable(getByteNumberValueOrNull());
	}

	public short getShortNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	public final @Nullable Short getShortNumberValueOrNull() {
		return isNumber() ? getShortNumberValue() : null;
	}

	public final @NotNull Optional<Short> getShortNumberValueOpt() {
		return Optional.ofNullable(getShortNumberValueOrNull());
	}

	public int getIntNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	public final @Nullable Integer getIntNumberValueOrNull() {
		return isNumber() ? getIntNumberValue() : null;
	}

	public final @NotNull Optional<Integer> getIntNumberValueOpt() {
		return Optional.ofNullable(getIntNumberValueOrNull());
	}

	public long getLongNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	public final @Nullable Long getLongNumberValueOrNull() {
		return isNumber() ? getLongNumberValue() : null;
	}

	public final @NotNull Optional<Long> getLongNumberValueOpt() {
		return Optional.ofNullable(getLongNumberValueOrNull());
	}

	public float getFloatNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	public final @Nullable Float getFloatNumberValueOrNull() {
		return isNumber() ? getFloatNumberValue() : null;
	}

	public final @NotNull Optional<Float> getFloatNumberValueOpt() {
		return Optional.ofNullable(getFloatNumberValueOrNull());
	}

	public final double getDoubleNumberValue() {
		return getNumberValue();
	}

	public final @Nullable Double getDoubleNumberValueOrNull() {
		return isNumber() ? getDoubleNumberValue() : null;
	}

	public final @NotNull Optional<Double> getDoubleNumberValueOpt() {
		return Optional.ofNullable(getDoubleNumberValueOrNull());
	}

	/**
	 * Gets whether the JSON value is a boolean.
	 * @return <code>true</code> if this is a boolean.
	 */
	public boolean isBoolean() {
		return false;
	}

	/**
	 * Gets the JSON value as a boolean, otherwise throws.
	 * @return The JSON boolean.
	 * @throws JsonElementCastException If the value is not a boolean.
	 */
	public @NotNull JsonBoolean asBoolean() {
		throw new JsonElementCastException("Not a JsonBoolean: " + this + " (" + getPrimaryInterface() + ")");
	}

	/**
	 * Gets the JSON value as a boolean - nullable version.
	 * @return The JSON boolean.
	 */
	public final @Nullable JsonBoolean asBooleanOrNull() {
		return isBoolean() ? asBoolean() : null;
	}

	/**
	 * Gets the JSON value as a boolean - optional version.
	 * @return An optional JSON boolean.
	 */
	public final @NotNull Optional<JsonBoolean> asBooleanOpt() {
		return Optional.ofNullable(asBooleanOrNull());
	}

	/**
	 * Gets the primitive value of the JSON boolean, otherwise throws.
	 * @return The primitive boolean.
	 * @throws JsonElementCastException If the value is not a boolean.
	 */
	public boolean getBooleanValue() throws JsonElementCastException {
		throw new JsonElementCastException("Not a JsonBoolean: " + this + " (" + getPrimaryInterface() + ")");
	}

	/**
	 * Gets the nullable boxed value of the JSON boolean.
	 * @return The value, or <code>null</code>.
	 */
	public final @Nullable Boolean getBooleanValueOrNull() {
		return isBoolean() ? getBooleanValue() : null;
	}

	/**
	 * Gets the boxed value of the JSON boolean - optional version.
	 * @return An optional value.
	 */
	public final @NotNull Optional<Boolean> getBooleanValueOpt() {
		return Optional.ofNullable(getBooleanValueOrNull());
	}

	/**
	 * Gets whether the JSON value is <code>false</code>.
	 * @return <code>true</code> if this is a JSON boolean with <code>false</code> as its value.
	 */
	public boolean isFalse() {
		return false;
	}

	/**
	 * Gets whether the JSON value is <code>true</code>.
	 * @return <code>true</code> if this is a JSON boolean with <code>true</code> as its value.
	 */
	public boolean isTrue() {
		return false;
	}

	/**
	 * Gets whether the JSON value is <code>null</code>.
	 * @return <code>true</code> if this is <code>null</code>.
	 */
	public boolean isNull() {
		return false;
	}

	@Override
	public final String toString() {
		return JsonSerializer.toString(this);
	}

	protected abstract String getPrimaryInterface();

}