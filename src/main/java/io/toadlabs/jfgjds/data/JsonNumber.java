package io.toadlabs.jfgjds.data;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public final class JsonNumber extends JsonValue {

	private final double value;

	public JsonNumber(@NotNull double value) {
		this.value = Objects.requireNonNull(value);
	}

	public double getValue() {
		return value;
	}

	public byte getByteValue() {
		return (byte) getValue();
	}

	@Override
	public byte getByteNumberValue() {
		return getByteValue();
	}

	public short getShortValue() {
		return (short) getValue();
	}

	@Override
	public short getShortNumberValue() {
		return getShortValue();
	}

	public int getIntValue() {
		return (int) value;
	}

	@Override
	public int getIntNumberValue() {
		return getIntValue();
	}

	public long getLongValue() {
		return (long) value;
	}

	@Override
	public long getLongNumberValue() {
		return getLongValue();
	}

	public float getFloatValue() {
		return (float) value;
	}

	@Override
	public float getFloatNumberValue() {
		return getFloatValue();
	}

	public double getDoubleValue() {
		return getValue();
	}

	@Override
	public boolean isNumber() {
		return true;
	}

	@Override
	public JsonNumber asNumber() {
		return this;
	}

	@Override
	public @NotNull double getNumberValue() {
		return getValue();
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonNumber";
	}

	@Override
	public int hashCode() {
		return Double.hashCode(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JsonNumber)) {
			return false;
		}

		JsonNumber other = (JsonNumber) obj;
		return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}

}