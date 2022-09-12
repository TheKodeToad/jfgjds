package io.toadlabs.jfgjds.data;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public final class JsonNumber extends JsonValue {

	private final Number value;

	public JsonNumber(@NotNull Number value) {
		this.value = Objects.requireNonNull(value);
	}

	public Number getValue() {
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
		return (double) value;
	}

	@Override
	public double getDoubleNumberValue() {
		return getDoubleValue();
	}

	public @NotNull Class<? extends Number> getValueType() {
		return getValue().getClass();
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
	public @NotNull Number getNumberValue() {
		return getValue();
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonNumber";
	}

}