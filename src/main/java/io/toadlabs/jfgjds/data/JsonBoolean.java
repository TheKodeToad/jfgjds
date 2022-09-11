package io.toadlabs.jfgjds.data;

import io.toadlabs.jfgjds.data.impl.JsonBooleanImpl;

public interface JsonBoolean extends JsonValue {

	JsonBoolean FALSE = JsonBooleanImpl.FALSE;
	JsonBoolean TRUE = JsonBooleanImpl.TRUE;

	boolean getValue();

}
