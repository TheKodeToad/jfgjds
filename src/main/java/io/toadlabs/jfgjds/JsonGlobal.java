package io.toadlabs.jfgjds;

import io.toadlabs.jfgjds.data.JsonArray;
import io.toadlabs.jfgjds.data.JsonBoolean;
import io.toadlabs.jfgjds.data.JsonNull;
import io.toadlabs.jfgjds.data.JsonObject;

/**
 * Use this if with a static import. If you are avoiding static imports,
 * don't use this.
 */
public final class JsonGlobal {

	public static final JsonNull JSON_NULL = JsonNull.INSTANCE;
	public static final JsonBoolean JSON_FALSE = JsonBoolean.FALSE;
	public static final JsonBoolean JSON_TRUE = JsonBoolean.TRUE;

	public static JsonObject jsonObj(Object... values) {
		return JsonObject.of(values);
	}

	public static JsonArray jsonArray(Object... values) {
		return JsonArray.of(values);
	}

}
