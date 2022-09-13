package io.toadlabs.jfgjds.data;

/**
 * Empty class used to distinguish <code>null</code> values.
 * There is only one instance.
 */
public final class JsonNull extends JsonValue {

	public static final JsonNull INSTANCE = new JsonNull();

	private JsonNull() {}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonNull";
	}

	// no need for hashCode and equals since there is only one instance

}
