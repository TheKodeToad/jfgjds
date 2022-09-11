package io.toadlabs.jfgjds.data.impl;

import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.toadlabs.jfgjds.data.JsonArray;
import io.toadlabs.jfgjds.data.JsonBoolean;
import io.toadlabs.jfgjds.data.JsonNumber;
import io.toadlabs.jfgjds.data.JsonObject;
import io.toadlabs.jfgjds.data.JsonString;
import io.toadlabs.jfgjds.data.JsonValue;
import io.toadlabs.jfgjds.exception.JsonElementCastException;

public abstract class AbstractJsonValue implements JsonValue {

	protected abstract String getPrimaryInterface();

	@Override
	public boolean isObject() {
		return false;
	}

	@Override
	public JsonObject asObject() {
		throw new JsonElementCastException("Not a JsonObject: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final JsonObject asObjectOrNull() {
		return isObject() ? asObject() : null;
	}

	@Override
	public final Optional<JsonObject> asObjectObj() {
		return Optional.ofNullable(asObjectOrNull());
	}

	@Override
	public boolean isArray() {
		return false;
	}

	@Override
	public @NotNull JsonArray asArray() throws JsonElementCastException {
		throw new JsonElementCastException("Not a JsonArray: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable JsonArray asArrayOrNull() {
		return isArray() ? asArray() : null;
	}

	@Override
	public final @NotNull Optional<JsonArray> asArrayOpt() {
		return Optional.ofNullable(asArrayOrNull());
	}

	@Override
	public boolean isString() {
		return false;
	}

	@Override
	public @NotNull JsonString asString() throws JsonElementCastException {
		throw new JsonElementCastException("Not a JsonString: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable JsonString asStringOrNull() {
		return isString() ? asString() : null;
	}

	@Override
	public final @NotNull Optional<JsonString> asStringOpt() {
		return Optional.of(asStringOrNull());
	}

	@Override
	public @NotNull String getStringValue() {
		throw new JsonElementCastException("Not a JsonString: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable String getStringValueOrNull() {
		return isString() ? getStringValue() : null;
	}

	@Override
	public final @Nullable Optional<String> getStringValueOpt() {
		return Optional.ofNullable(getStringValueOrNull());
	}

	@Override
	public boolean isNumber() {
		return false;
	}

	@Override
	public JsonNumber asNumber() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final JsonNumber asNumberOrNull() {
		return isNumber() ? asNumber() : null;
	}

	@Override
	public final Optional<JsonNumber> asNumberOpt() {
		return Optional.ofNullable(asNumberOrNull());
	}

	@Override
	public @NotNull Number getNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable Number getNumberValueOrNull() {
		return isNumber() ? getNumberValue() : null;
	}

	@Override
	public final @NotNull Optional<Number> getNumberValueOpt() {
		return Optional.ofNullable(getNumberValueOrNull());
	}

	@Override
	public byte getByteNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable Byte getByteNumberValueOrNull() {
		return isNumber() ? getByteNumberValue() : null;
	}

	@Override
	public final @NotNull Optional<Byte> getByteNumberValueOpt() {
		return Optional.ofNullable(getByteNumberValueOrNull());
	}

	@Override
	public short getShortNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable Short getShortNumberValueOrNull() {
		return isNumber() ? getShortNumberValue() : null;
	}

	@Override
	public final @NotNull Optional<Short> getShortNumberValueOpt() {
		return Optional.ofNullable(getShortNumberValueOrNull());
	}

	@Override
	public int getIntNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable Integer getIntNumberValueOrNull() {
		return isNumber() ? getIntNumberValue() : null;
	}

	@Override
	public final @NotNull Optional<Integer> getIntNumberValueOpt() {
		return Optional.ofNullable(getIntNumberValueOrNull());
	}

	@Override
	public long getLongNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable Long getLongNumberValueOrNull() {
		return isNumber() ? getLongNumberValue() : null;
	}

	@Override
	public final @NotNull Optional<Long> getLongNumberValueOpt() {
		return Optional.ofNullable(getLongNumberValueOrNull());
	}

	@Override
	public float getFloatNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable Float getFloatNumberValueOrNull() {
		return isNumber() ? getFloatNumberValue() : null;
	}

	@Override
	public final @NotNull Optional<Float> getFloatNumberValueOpt() {
		return Optional.ofNullable(getFloatNumberValueOrNull());
	}

	@Override
	public double getDoubleNumberValue() {
		throw new JsonElementCastException("Not a JsonNumber: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable Double getDoubleNumberValueOrNull() {
		return isNumber() ? getDoubleNumberValue() : null;
	}

	@Override
	public final @NotNull Optional<Double> getDoubleNumberValueOpt() {
		return Optional.ofNullable(getDoubleNumberValueOrNull());
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public JsonBoolean asBoolean() {
		throw new JsonElementCastException("Not a JsonBoolean: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable JsonBoolean asBooleanOrNull() {
		return isBoolean() ? asBoolean() : null;
	}

	@Override
	public final @NotNull Optional<JsonBoolean> asBooleanOpt() {
		return Optional.of(asBooleanOrNull());
	}

	@Override
	public boolean getBooleanValue() throws JsonElementCastException {
		throw new JsonElementCastException("Not a JsonBoolean: " + this + " (" + getPrimaryInterface() + ")");
	}

	@Override
	public final @Nullable Boolean getBooleanValueOrNull() {
		return isBoolean() ? getBooleanValue() : null;
	}

	@Override
	public final @NotNull Optional<Boolean> getBooleanValueOpt() {
		return Optional.ofNullable(getBooleanValueOrNull());
	}

	@Override
	public boolean isFalse() {
		return false;
	}

	@Override
	public boolean isTrue() {
		return false;
	}

	@Override
	public boolean isNull() {
		return false;
	}

}
