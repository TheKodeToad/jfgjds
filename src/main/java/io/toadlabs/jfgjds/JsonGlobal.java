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

	public static final JsonNull J_NULL = JsonNull.INSTANCE;
	public static final JsonBoolean J_FALSE = JsonBoolean.FALSE;
	public static final JsonBoolean J_TRUE = JsonBoolean.TRUE;

	public static JsonObject obj(Object... values) {
		return JsonObject.of(values);
	}

	public static JsonArray arr(Object... values) {
		return JsonArray.of(values);
	}

}
