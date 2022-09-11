package io.toadlabs.jfgjds.data.impl;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.data.JsonNumber;

public class JsonNumberImpl extends AbstractJsonValue implements JsonNumber {

	private final Number value;

	public JsonNumberImpl(@NotNull Number value) {
		this.value = Objects.requireNonNull(value);
	}

	@Override
	public Number getValue() {
		return value;
	}

	@Override
	public byte getByteValue() {
		return (byte) getValue();
	}

	@Override
	public byte getByteNumberValue() {
		return getByteValue();
	}

	@Override
	public short getShortValue() {
		return (short) getValue();
	}

	@Override
	public short getShortNumberValue() {
		return getShortValue();
	}

	@Override
	public int getIntValue() {
		return (int) value;
	}

	@Override
	public int getIntNumberValue() {
		return getIntValue();
	}

	@Override
	public long getLongValue() {
		return (long) value;
	}

	@Override
	public long getLongNumberValue() {
		return getLongValue();
	}

	@Override
	public float getFloatValue() {
		return (float) value;
	}

	@Override
	public float getFloatNumberValue() {
		return getFloatValue();
	}

	@Override
	public double getDoubleValue() {
		return (double) value;
	}

	@Override
	public double getDoubleNumberValue() {
		return getDoubleValue();
	}

	@Override
	public @NotNull Class<? extends Number> getValueType() {
		return getValue().getClass();
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonNumber";
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

}
