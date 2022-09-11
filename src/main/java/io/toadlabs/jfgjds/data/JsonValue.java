package io.toadlabs.jfgjds.data;

import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
public interface JsonValue {

	/**
	 * Gets whether the JSON value is an object.
	 * @return <code>true</code> if this is a JSON object.
	 */
	boolean isObject();

	/**
	 * Gets the JSON value as an object, otherwise throws.
	 * @return The JSON object.
	 * @throws JsonElementCastException If the value is not an object.
	 */
	@NotNull JsonObject asObject() throws JsonElementCastException;

	/**
	 * Gets the JSON value as an object - nullable version.
	 * @return The JSON object, or <code>null</code>.
	 */
	@Nullable JsonObject asObjectOrNull();

	/**
	 * Gets the JSON value as an object - optional version.
	 * @return An optional JSON object.
	 */
	@NotNull Optional<JsonObject> asObjectObj();

	/**
	 * Gets whether the JSON value is an array.
	 * @return <code>true</code> if this is a JSON array.
	 */
	boolean isArray();

	/**
	 * Gets the JSON value as an array, otherwise throws.
	 * @return The JSON array.
	 * @throws JsonElementCastException If the value is not an array.
	 */
	@NotNull JsonArray asArray() throws JsonElementCastException;

	/**
	 * Gets the JSON value as an array - nullable version.
	 * @return The JSON array, or <code>null</code>.
	 */
	@Nullable JsonArray asArrayOrNull();

	/**
	 * Gets the JSON value as an array - optional version.
	 * @return An optional JSON array.
	 */
	@NotNull Optional<JsonArray> asArrayOpt();

	/**
	 * Gets whether the JSON value is a string.
	 * @return <code>true</code> if this is a JSON string.
	 */
	boolean isString();

	/**
	 * Gets the JSON value as a string, otherwise throws.
	 * @return The JSON string.
	 * @throws JsonElementCastException If the value is not an string.
	 */
	@NotNull JsonString asString() throws JsonElementCastException;

	/**
	 * Gets the JSON value as a string - nullable version.
	 * @return The JSON string, or <code>null</code>.
	 */
	@Nullable JsonString asStringOrNull();

	/**
	 * Gets the JSON value as a string - optional version.
	 * @return An optional JSON string.
	 */
	@NotNull Optional<JsonString> asStringOpt();

	/**
	 * Gets the Java value of the JSON string, otherwise throws.
	 * @return The Java string.
	 * @throws JsonElementCastException If the value is not a string.
	 */
	@NotNull String getStringValue();

	/**
	 * Gets the Java value of the JSON string - nullable version.
	 * @return The Java string, or <code>null</code>.
	 */
	@Nullable String getStringValueOrNull();

	/**
	 * Gets the Java value of the JSON string - optional version.
	 * @return An optional Java string.
	 */
	@Nullable Optional<String> getStringValueOpt();

	/**
	 * Gets whether the JSON value is a number.
	 * @return <code>true</code> if this is a JSON number.
	 */
	boolean isNumber();

	/**
	 * Gets the JSON value as a number, otherwise throws.
	 * @return The JSON number.
	 * @throws JsonElementCastException If the value is not an number.
	 */
	@NotNull JsonNumber asNumber() throws JsonElementCastException;

	/**
	 * Gets the JSON value as a number - nullable version.
	 * @return The JSON number.
	 */
	@Nullable JsonNumber asNumberOrNull();

	/**
	 * Gets the JSON value as a number - optional version.
	 * @return An optional JSON number.
	 */
	@NotNull Optional<JsonNumber> asNumberOpt();

	/**
	 * Gets the Java value of the JSON number, otherwise throws.
	 * @return The Java number.
	 * @throws JsonElementCastException If the value is not a number.
	 */
	@NotNull Number getNumberValue();

	@Nullable Number getNumberValueOrNull();

	@NotNull Optional<Number> getNumberValueOpt();

	byte getByteNumberValue();

	@Nullable Byte getByteNumberValueOrNull();

	@NotNull Optional<Byte> getByteNumberValueOpt();

	short getShortNumberValue();

	@Nullable Short getShortNumberValueOrNull();

	@NotNull Optional<Short> getShortNumberValueOpt();

	int getIntNumberValue();

	@Nullable Integer getIntNumberValueOrNull();

	@NotNull Optional<Integer> getIntNumberValueOpt();

	long getLongNumberValue();

	@Nullable Long getLongNumberValueOrNull();

	@NotNull Optional<Long> getLongNumberValueOpt();

	float getFloatNumberValue();

	@Nullable Float getFloatNumberValueOrNull();

	@NotNull Optional<Float> getFloatNumberValueOpt();

	double getDoubleNumberValue();

	@Nullable Double getDoubleNumberValueOrNull();

	@NotNull Optional<Double> getDoubleNumberValueOpt();

	/**
	 * Gets whether the JSON value is a boolean.
	 * @return <code>true</code> if this is a boolean.
	 */
	boolean isBoolean();

	/**
	 * Gets the JSON value as a boolean, otherwise throws.
	 * @return The JSON boolean.
	 * @throws JsonElementCastException If the value is not a boolean.
	 */
	@NotNull JsonBoolean asBoolean();

	/**
	 * Gets the JSON value as a boolean - nullable version.
	 * @return The JSON boolean.
	 */
	@Nullable JsonBoolean asBooleanOrNull();

	/**
	 * Gets the JSON value as a boolean - optional version.
	 * @return An optional JSON boolean.
	 */
	@NotNull Optional<JsonBoolean> asBooleanOpt();

	/**
	 * Gets the primitive value of the JSON boolean, otherwise throws.
	 * @return The primitive boolean.
	 * @throws JsonElementCastException If the value is not a boolean.
	 */
	boolean getBooleanValue() throws JsonElementCastException;

	/**
	 * Gets the nullable boxed value of the JSON boolean.
	 * @return The value, or <code>null</code>.
	 */
	@Nullable Boolean getBooleanValueOrNull();

	/**
	 * Gets the boxed value of the JSON boolean - optional version.
	 * @return An optional value.
	 */
	@NotNull Optional<Boolean> getBooleanValueOpt();

	/**
	 * Gets whether the JSON value is <code>false</code>.
	 * @return <code>true</code> if this is a JSON boolean with <code>false</code> as its value.
	 */
	boolean isFalse();

	/**
	 * Gets whether the JSON value is <code>true</code>.
	 * @return <code>true</code> if this is a JSON boolean with <code>true</code> as its value.
	 */
	boolean isTrue();

	/**
	 * Gets whether the JSON value is <code>null</code>.
	 * @return <code>true</code> if this is <code>null</code>.
	 */
	boolean isNull();

}