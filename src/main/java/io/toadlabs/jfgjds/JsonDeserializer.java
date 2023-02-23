package io.toadlabs.jfgjds;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import io.toadlabs.jfgjds.data.JsonValue;
import io.toadlabs.jfgjds.exception.JsonParseException;

public final class JsonDeserializer {

	// Used to prevent unnecessary allocations.
	private static final ThreadLocal<Parser> PARSER = new ThreadLocal<Parser>() {

		@Override
		protected Parser initialValue() {
			return new Parser();
		}

	};

	private JsonDeserializer() {
		throw new UnsupportedOperationException("Object initialization");
	}

	public static @NotNull JsonValue read(@NotNull Reader in) throws JsonParseException, IOException {
		return PARSER.get().setup(Objects.requireNonNull(in)).readSingleValue();
	}

	public static @NotNull JsonValue read(@NotNull InputStream in, @NotNull String charset)
			throws JsonParseException, IOException {
		return read(in, Charset.forName(charset));
	}

	public static @NotNull JsonValue read(@NotNull InputStream in, @NotNull Charset charset)
			throws JsonParseException, IOException {
		return read(new InputStreamReader(Objects.requireNonNull(in), Objects.requireNonNull(charset)));
	}

	public static @NotNull JsonValue fromString(@NotNull String in) throws JsonParseException, IOException {
		return read(new StringReader(Objects.requireNonNull(in)));
	}

}
