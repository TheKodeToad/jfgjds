package io.toadlabs.jfgjds.data;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.data.impl.JsonNumberImpl;

public interface JsonNumber extends JsonValue {

	static JsonNumber of(@NotNull Number value) {
		return new JsonNumberImpl(value);
	}

	@NotNull Number getValue();

	byte getByteValue();

	short getShortValue();

	int getIntValue();

	long getLongValue();

	float getFloatValue();

	double getDoubleValue();

	@NotNull Class<? extends Number> getValueType();

}