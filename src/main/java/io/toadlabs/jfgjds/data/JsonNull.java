package io.toadlabs.jfgjds.data;

import io.toadlabs.jfgjds.data.impl.JsonNullImpl;

/**
 * Empty class used to distinguish <code>null</code> values.
 * There is only one instance.
 */
public interface JsonNull extends JsonValue {

	JsonNull INSTANCE = JsonNullImpl.INSTANCE;

}
