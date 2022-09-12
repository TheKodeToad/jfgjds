package io.toadlabs.jfgjds;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.data.JsonArray;
import io.toadlabs.jfgjds.data.JsonBoolean;
import io.toadlabs.jfgjds.data.JsonNumber;
import io.toadlabs.jfgjds.data.JsonObject;
import io.toadlabs.jfgjds.data.JsonString;
import io.toadlabs.jfgjds.data.JsonValue;

public final class JsonSerializer {

	private JsonSerializer() {
		throw new UnsupportedOperationException("Object initialization");
	}

	public static void write(@NotNull JsonValue value, @NotNull OutputStream out, @NotNull String charset) throws IOException {
		out.write(toString(value).getBytes(Charset.forName(charset)));
	}

	public static void write(@NotNull JsonValue value, @NotNull OutputStream out, @NotNull Charset charset) throws IOException {
		out.write(toString(value).getBytes(Objects.requireNonNull(charset)));
	}

	public static void write(@NotNull JsonValue value, @NotNull Writer writer) throws IOException {
		writer.write(toString(value).toCharArray());
		writer.flush();
	}

	public static @NotNull String toString(@NotNull JsonValue value) {
		StringBuilder out = new StringBuilder();
		write(Objects.requireNonNull(value), out);
		return out.toString();
	}

	private static void write(JsonValue value, StringBuilder out) {
		if(value.isObject()) {
			write(value.asObject(), out);
		}
		else if(value.isArray()) {
			write(value.asArray(), out);
		}
		else if(value.isString()) {
			write(value.asString(), out);
		}
		else if(value.isNumber()) {
			write(value.asNumber(), out);
		}
		else if(value.isBoolean()) {
			write(value.asBoolean(), out);
		}
		else if(value.isNull()) {
			writeNull(out);
		}
	}

	private static void write(JsonObject obj, StringBuilder out) {
		out.append('{');
		boolean comma = false;
		for(Map.Entry<String, JsonValue> entry : obj.entries()) {
			if(comma) {
				out.append(',');
			}
			write(entry.getKey(), out);
			out.append(':');
			write(entry.getValue(), out);
			comma = true;
		}
		out.append('}');
	}

	private static void write(JsonArray array, StringBuilder out) {
		out.append('[');
		boolean comma = false;
		for(JsonValue entry : array) {
			if(comma) {
				out.append(',');
			}
			write(entry, out);
			comma = true;
		}
		out.append(']');
	}

	private static void write(JsonString str, StringBuilder out) {
		write(str.getValue(), out);
	}

	private static void write(String str, StringBuilder out) {
		out.append('"');

		for(char character : str.toCharArray()) {
			switch(character) {
				case '\\':
				case '"':
					out.append('\\');
					break;
				case '\b':
					out.append("\\b");
					continue;
				case '\f':
					out.append("\\f");
					continue;
				case '\n':
					out.append("\\n");
					continue;
				case '\r':
					out.append("\\r");
					continue;
				case '\t':
					out.append("\\t");
					continue;
			}
			out.append(character);
		}

		out.append('"');
	}

	private static void write(JsonNumber number, StringBuilder out) {
		out.append(number.getValue());
	}

	private static void write(JsonBoolean bool, StringBuilder out) {
		out.append(bool.getValue() ? "true" : "false");
	}

	private static void writeNull(StringBuilder out) {
		out.append("null");
	}

}
